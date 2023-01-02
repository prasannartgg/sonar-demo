package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.service.ValidatorService;
import au.com.tgg.apps.foundation.util.FoundationUtil;
//import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import au.com.tgg.apps.foundation.util.ServiceBusSender;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderAsyncClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

@Service
public class ValidatorServiceImpl implements ValidatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorServiceImpl.class);
    ObjectMapper OBJECTMAPPER = new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

    @SneakyThrows
    public Mono<String> validateJson(String jsonString) {
        HttpStatus httpStatus = null;
        LOGGER.info("Function:RIBMsgValidator Java HTTP trigger processed a request.");
        String csodrEntityJsonString = jsonString;
        LOGGER.info("Function:RIBMsgValidator Queue message is: " + csodrEntityJsonString);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V201909);
        LOGGER.info("Function:RIBMsgValidator Begin reading json tree!");
        if (Objects.isNull(csodrEntityJsonString)) {
            return Mono.just(OBJECTMAPPER.writeValueAsString(new ResponseDTO("Receive a null json payload", HttpStatus.NOT_ACCEPTABLE, jsonString)));
//            return request.createResponseBuilder(HttpStatus.OK).body("receive a null json payload").build();
        }
        try {
            JsonNode json = objectMapper.readTree(csodrEntityJsonString);
            String actionName = json.get("operations").get(FoundationUtil.JSON_NODE_ACTION).asText().toLowerCase();
            String fileTableName = json.get("operations").get(FoundationUtil.JSON_NODE_TABLE_NAME).asText().toLowerCase();
            String modelSchemaFileName = fileTableName + "-" + actionName + ".json";;
            JsonSchema schema = schemaFactory.getSchema(getSchemaFromBlob(System.getenv("AzureWebJobsStorage"), modelSchemaFileName, System.getenv("jsonSchemaContainerName")));
            Set<ValidationMessage> validationResult = schema.validate(json);
            for (ValidationMessage validationMessage : validationResult) {
                if (validationMessage.getMessage().contains("missing") || validationMessage.getMessage().contains("null found")) {
                    LOGGER.info("Function:RIBMsgValidator JSON validation results" + validationResult);
                    //inValidMessage.setValue("Validation Error : " + validationMessage + " json payload is : " + csodrEntityJsonString);
                    ServiceBusSender.sendMessage(System.getenv("invalidMsgServiceBusTopic"), "Validation Error : " + validationMessage + " json payload is : " + csodrEntityJsonString);
//                    return httpStatus.is4xxClientError();
                    return Mono.just(OBJECTMAPPER.writeValueAsString(new ResponseDTO("Message is invalid, Function:RIBMsgValidator has been sent into service bus invalid topic", HttpStatus.NOT_ACCEPTABLE, jsonString)));
                    //                    return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("Message is invalid, Function:RIBMsgValidator has been sent into service bus invalid topic").build();
                }
            }
            //validMessage.setValue(csodrEntityJsonString);
            if(actionName.equals(FoundationUtil.CRUD_ACTION_INSERT)
                    && Arrays.asList(FoundationUtil.JSON_TABLE_NAME_PRODUCT_BARCODE, FoundationUtil.JSON_TABLE_NAME_PRODUCT_VOLUMETRICS, FoundationUtil.JSON_TABLE_NAME_SUPPLIER_ACCOUNT_PRODUCT)
                    .stream()
                    .anyMatch(fileTableName::equalsIgnoreCase)){
                ServiceBusSender.sendScheduledMessage(System.getenv("serviceBusTopic"), csodrEntityJsonString, Long.valueOf(180)); // 180L?
            } else {
                ServiceBusSender.sendMessage(System.getenv("serviceBusTopic"), csodrEntityJsonString);
            }
//            return httpStatus.is2xxSuccessful();
            return Mono.just(OBJECTMAPPER.writeValueAsString(new ResponseDTO("Message has been successfully sent to service bus", HttpStatus.OK, jsonString)));
//            return request.createResponseBuilder(HttpStatus.OK).body("Message has been successfully sent to service bus").build();
        } catch (Exception exception) {
//            sendScheduledMessage(System.getenv("serviceBusTopic"), csodrEntityJsonString);
            LOGGER.warn(String.valueOf(exception.getStackTrace().toString()));
            exception.printStackTrace();
            LOGGER.warn("Function:RIBMsgValidator encountered exception when process message : " + exception.getMessage());
            ServiceBusSender.sendMessage(System.getenv("invalidMsgServiceBusTopic"), csodrEntityJsonString);
            return Mono.just(OBJECTMAPPER.writeValueAsString(new ResponseDTO("Function:RIBMsgValidator encountered exception when process message, exception detail: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, jsonString)));
//            return httpStatus.is4xxClientError()  ;
//            return request.createResponseBuilder(H0.ttpStatus.INTERNAL_SERVER_ERROR).body("Function:RIBMsgValidator encountered exception when process message, exception detail: " + exception.getMessage() + exception.getStackTrace()[0]).build();
        }
//        return null;
    }

    public static String getSchemaFromBlob(String connection, String schemaFileName, String containerName) throws Exception {
        CloudStorageAccount storageAccount;
        CloudBlobClient blobClient = null;
        CloudBlobContainer container = null;
        storageAccount = CloudStorageAccount.parse(connection);
        blobClient = storageAccount.createCloudBlobClient();
        container = blobClient.getContainerReference(containerName);
        CloudBlockBlob blob = container.getBlockBlobReference(schemaFileName);
        String schemaJson = blob.downloadText();
        return schemaJson;
    }


}

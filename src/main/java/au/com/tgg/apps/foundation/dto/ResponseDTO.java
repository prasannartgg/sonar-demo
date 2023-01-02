package au.com.tgg.apps.foundation.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;

public class ResponseDTO {
    private String message;
    private HttpStatus status;
    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.status = null;
        this.data = data;
    }

    public ResponseDTO(String message, HttpStatus status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public ResponseDTO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNodeValueInOperationObject(String field, Object value) {
        try {
            JSONObject dataObject = new JSONObject((String) this.data);
            JSONObject operateObject = dataObject.getJSONObject("operations");
            operateObject.put(field, value);
            dataObject.put("operations", operateObject);
            this.setData(dataObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getNodeValueInOperationObject(String node) {
        JsonNode jsonNode;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        String nodeValue = "NULL";
        try {
            jsonNode = objectMapper.readTree((String) this.data);

            String operationsString = jsonNode.get("operations").toString();
            if (!operationsString.isEmpty()) {
                jsonNode = objectMapper.readTree(operationsString);
                nodeValue = jsonNode.get(node).asText();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return nodeValue;
    }

    public JSONObject getOperationField() {
        JSONObject operateObject = null;
        try {
            JSONObject dataObject = new JSONObject((String) this.data);
            operateObject = dataObject.getJSONObject("operations");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return operateObject;
    }

}

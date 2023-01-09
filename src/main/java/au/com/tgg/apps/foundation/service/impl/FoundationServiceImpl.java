package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.*;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.service.FoundationService;
import au.com.tgg.apps.foundation.util.FoundationUtil;
import au.com.tgg.apps.foundation.util.ServiceBusSender;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FoundationServiceImpl implements FoundationService {
    private final Logger LOGGER = LogManager.getLogger(FoundationServiceImpl.class);

    private final CrudService<Brand> brandCrudService;
    private final CrudService<MerchUda> merchUdaCrudService;
    private final CrudService<MerchUdaValue> merchUdaValueCrudService;
    private final CrudService<MerchClass> merchClassCrudService;
    private final CrudService<MerchDeps> merchDepsCrudService;
    private final CrudService<MerchSubclass> merchSubclassCrudService;
    private final CrudService<Country> countryCrudService;
    private final CrudService<Product> productCrudService;
    private final CrudService<SupplierAccountProduct> supplierAccountProductCrudService;
    private final CrudService<LocationState> locationStateCrudService;
    private final CrudService<Location> locationCrudService;
    private final CrudService<LocationSetCtl> locationSetCtlCrudService;
    private final CrudService<LocationSetDtl> locationSetDtlCrudService;
    private final CrudService<SupplierAccount> supplierAccountCrudService;
    private final CrudService<MerchUdaHierDefault> merchUdaHierDefaultCrudService;
    private final CrudService<ProductVolumetrics> productVolumetricsCrudService;
    private final CrudService<PosItemRollup> posItemRollupCrudService;
    private final CrudService<ProductBarcode> productBarcodeCrudService;
    private final CrudService<StockInfo> stockInfoCrudService;
    private final CrudService<LocationStateMapping> locationStateMappingCrudService;
    private final CrudService<ProductUdaMap> productUdaMapCrudService;
    private final CrudService<StoreInfo> storeInfoCrudService;
    private final CrudService<ProductUdaDate> productUdaDateCrudService;

    @Autowired
    public FoundationServiceImpl(CrudService<Brand> brandCrudService, CrudService<MerchUda> merchUdaCrudService, CrudService<MerchUdaValue> merchUdaValueCrudService, CrudService<MerchClass> merchClassCrudService, CrudService<MerchDeps> merchDepsCrudService, CrudService<MerchSubclass> merchSubclassCrudService, CrudService<Country> countryCrudService, CrudService<Product> productCrudService, CrudService<SupplierAccountProduct> supplierAccountProductCrudService, CrudService<LocationState> locationStateCrudService, CrudService<Location> locationCrudService, CrudService<LocationSetCtl> locationSetCtlCrudService, CrudService<LocationSetDtl> locationSetDtlCrudService, CrudService<SupplierAccount> supplierAccountCrudService, CrudService<MerchUdaHierDefault> merchUdaHierDefaultCrudService, CrudService<ProductVolumetrics> productVolumetricsCrudService, CrudService<PosItemRollup> posItemRollupCrudService, CrudService<ProductBarcode> productBarcodeCrudService, CrudService<StockInfo> stockInfoCrudService, CrudService<LocationStateMapping> locationStateMappingCrudService, CrudService<StoreInfo> storeInfoCrudService, CrudService<ProductUdaMap> productUdaMapCrudService, CrudService<ProductUdaDate> productUdaDateCrudService) {
        this.brandCrudService = brandCrudService;
        this.merchUdaCrudService = merchUdaCrudService;
        this.merchUdaValueCrudService = merchUdaValueCrudService;
        this.merchClassCrudService = merchClassCrudService;
        this.merchDepsCrudService = merchDepsCrudService;
        this.merchSubclassCrudService = merchSubclassCrudService;
        this.countryCrudService = countryCrudService;
        this.productCrudService = productCrudService;
        this.supplierAccountProductCrudService = supplierAccountProductCrudService;
        this.locationStateCrudService = locationStateCrudService;
        this.locationCrudService = locationCrudService;
        this.locationSetCtlCrudService = locationSetCtlCrudService;
        this.locationSetDtlCrudService = locationSetDtlCrudService;
        this.supplierAccountCrudService = supplierAccountCrudService;
        this.merchUdaHierDefaultCrudService = merchUdaHierDefaultCrudService;
        this.productVolumetricsCrudService = productVolumetricsCrudService;
        this.posItemRollupCrudService = posItemRollupCrudService;
        this.productBarcodeCrudService = productBarcodeCrudService;
        this.stockInfoCrudService = stockInfoCrudService;
        this.locationStateMappingCrudService = locationStateMappingCrudService;
        this.storeInfoCrudService = storeInfoCrudService;
        this.productUdaMapCrudService = productUdaMapCrudService;
        this.productUdaDateCrudService = productUdaDateCrudService;
    }

    @SneakyThrows
    public Mono<String> serviceBusProcessor(String request) {
        ObjectMapper objectMapper = new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        ResponseDTO responseDTO = processJsonPayload(request);
        //cases for retry
        if (!responseDTO.getStatus().is2xxSuccessful()) {
            LOGGER.info("Function:CsodrCrudFuncServiceBus failed due to : " + request);
            ServiceBusSender.sendScheduledMessage(System.getenv("failedMsgServiceBusTopic"), request);
        }
        return Mono.just(objectMapper.writeValueAsString(responseDTO));
    }


    @Override
    public ResponseDTO processJsonPayload(String request) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(request);
        Integer executeCount = Integer.valueOf(responseDTO.getNodeValueInOperationObject(FoundationUtil.JSON_NODE_EXECUTE_COUNT));
        String entityName = responseDTO.getNodeValueInOperationObject(FoundationUtil.JSON_NODE_TABLE_NAME);
        String action = responseDTO.getNodeValueInOperationObject(FoundationUtil.JSON_NODE_ACTION);
        responseDTO.setNodeValueInOperationObject(FoundationUtil.JSON_NODE_EXECUTE_COUNT, ++executeCount);
        if (executeCount > 10) {
            responseDTO.setMessage(entityName + " process stop, message will be discarded, because " + action + " process more than 10 times");
            responseDTO.setStatus(HttpStatus.BAD_REQUEST);
            return responseDTO;
        }
        try {
            /*if (!request.isEmpty() && action.equalsIgnoreCase(FoundationUtil.CRUD_ACTION_INSERT)) {
                responseDTO = insertPayload(entityName, request);
                LOGGER.info(responseDTO.getMessage());
                return responseDTO;
            } else */
            if (!request.isEmpty() && (action.equalsIgnoreCase(FoundationUtil.CRUD_ACTION_UPDATE) || action.equalsIgnoreCase(FoundationUtil.CRUD_ACTION_INSERT))) {
                responseDTO = updatePayload(entityName, request);
                LOGGER.info(responseDTO.getMessage());
                return responseDTO;
            } else if (!request.isEmpty() && action.equalsIgnoreCase(FoundationUtil.CRUD_ACTION_DELETE)) {
                responseDTO = deletePayload(entityName, request);
                LOGGER.info(responseDTO.getMessage());
                return responseDTO;
            } else {
                LOGGER.error(responseDTO.getMessage());
                return new ResponseDTO("Exception: this payload has no action name", HttpStatus.INTERNAL_SERVER_ERROR, request);
            }
        } catch (Exception ex) {
            responseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            responseDTO.setMessage("fail exception happen during process message,  exception detail is: " + ex + " - " + ex.getStackTrace()[0]);
            responseDTO.setNodeValueInOperationObject(FoundationUtil.JSON_NODE_FAIL_INFO, responseDTO.getMessage());
            ex.printStackTrace();
            LOGGER.error("Exception happen : " + ex);
            return responseDTO;
        }
    }

    @Override
    public ResponseDTO updatePayload(String entityName, String request) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_MERCH_UDA)) {
            MerchUda merchUda = objectMapper.readValue(request, MerchUda.class);
            return merchUdaCrudService.update(merchUda);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_MERCH_UDA_VALUE)) {
            MerchUdaValue merchUdaValue = objectMapper.readValue(request, MerchUdaValue.class);
            return merchUdaValueCrudService.update(merchUdaValue);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_MERCH_DEPS)) {
            MerchDeps merchDeps = objectMapper.readValue(request, MerchDeps.class);
            return merchDepsCrudService.update(merchDeps);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_MERCH_CLASS)) {
            MerchClass merchClass = objectMapper.readValue(request, MerchClass.class);
            return merchClassCrudService.update(merchClass);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_MERCH_SUBCLASS)) {
            MerchSubclass merchSubclass = objectMapper.readValue(request, MerchSubclass.class);
            return merchSubclassCrudService.update(merchSubclass);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_PRODUCT)) {
            Product product = objectMapper.readValue(request, Product.class);
            return productCrudService.update(product);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_SUPPLIER_ACCOUNT_PRODUCT)) {
            SupplierAccountProduct supplierAccountProduct = objectMapper.readValue(request, SupplierAccountProduct.class);
            return supplierAccountProductCrudService.update(supplierAccountProduct);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_STOCK_INFO)) {
            StockInfo stockInfo = objectMapper.readValue(request, StockInfo.class);
            return stockInfoCrudService.update(stockInfo);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_COUNTRY)) {
            Country country = objectMapper.readValue(request, Country.class);
            return countryCrudService.update(country);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_LOCATION_STATE)) {
            LocationState locationState = objectMapper.readValue(request, LocationState.class);
            return locationStateCrudService.update(locationState);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_LOCATION_STATE_MAPPING)) {
            LocationStateMapping locationStateMapping = objectMapper.readValue(request, LocationStateMapping.class);
            return locationStateMappingCrudService.update(locationStateMapping);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_LOCATION)) {
            Location location = objectMapper.readValue(request, Location.class);
            return locationCrudService.update(location);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_STORE_INFO)) {
            StoreInfo storeInfo = objectMapper.readValue(request, StoreInfo.class);
            return storeInfoCrudService.update(storeInfo);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_LOCATION_SET_CTL)) {
            LocationSetCtl locationSetCtl = objectMapper.readValue(request, LocationSetCtl.class);
            return locationSetCtlCrudService.update(locationSetCtl);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_LOCATION_SET_DTL)) {
            LocationSetDtl locationSetDtl = objectMapper.readValue(request, LocationSetDtl.class);
            return locationSetDtlCrudService.update(locationSetDtl);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_SUPPLIER_ACCOUNT)) {
            SupplierAccount supplierAccount = objectMapper.readValue(request, SupplierAccount.class);
            return supplierAccountCrudService.update(supplierAccount);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_MERCH_UDA_HIER_DEFAULT)) {
            MerchUdaHierDefault merchUdaHierDefault = objectMapper.readValue(request, MerchUdaHierDefault.class);
            return merchUdaHierDefaultCrudService.update(merchUdaHierDefault);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_PRODUCT_VOLUMETRICS)) {
            ProductVolumetrics productVolumetrics = objectMapper.readValue(request, ProductVolumetrics.class);
            return productVolumetricsCrudService.update(productVolumetrics);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_POS_ITEM_ROLLUP)) {
            PosItemRollup posItemRollup = objectMapper.readValue(request, PosItemRollup.class);
            return posItemRollupCrudService.update(posItemRollup);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_PRODUCT_BARCODE)) {
            ProductBarcode productBarcode = objectMapper.readValue(request, ProductBarcode.class);
            return productBarcodeCrudService.update(productBarcode);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_PRODUCT_UDA_MAP)) {
            ProductUdaMap productUdaMap = objectMapper.readValue(request, ProductUdaMap.class);
            return productUdaMapCrudService.update(productUdaMap);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_PRODUCT_UDA_DATE)) {
            ProductUdaDate productUdaDate = objectMapper.readValue(request, ProductUdaDate.class);
            return productUdaDateCrudService.update(productUdaDate);
        } else {
            return new ResponseDTO("MsgException: Update message was not processed", HttpStatus.INTERNAL_SERVER_ERROR, request);
        }
    }

    @Override
    public ResponseDTO deletePayload(String entityName, String request) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_MERCH_UDA)) {
            MerchUda merchUda = objectMapper.readValue(request, MerchUda.class);
            return merchUdaCrudService.delete(merchUda);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_MERCH_UDA_VALUE)) {
            MerchUdaValue merchUdaValue = objectMapper.readValue(request, MerchUdaValue.class);
            return merchUdaValueCrudService.delete(merchUdaValue);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_MERCH_CLASS)) {
            MerchClass merchClass = objectMapper.readValue(request, MerchClass.class);
            return merchClassCrudService.delete(merchClass);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_MERCH_DEPS)) {
            MerchDeps merchDeps = objectMapper.readValue(request, MerchDeps.class);
            return merchDepsCrudService.delete(merchDeps);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_MERCH_SUBCLASS)) {
            MerchSubclass merchSubclass = objectMapper.readValue(request, MerchSubclass.class);
            return merchSubclassCrudService.delete(merchSubclass);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_PRODUCT)) {
            Product product = objectMapper.readValue(request, Product.class);
            return productCrudService.delete(product);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_SUPPLIER_ACCOUNT_PRODUCT)) {
            SupplierAccountProduct supplierAccountProduct = objectMapper.readValue(request, SupplierAccountProduct.class);
            return supplierAccountProductCrudService.delete(supplierAccountProduct);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_COUNTRY)) {
            Country country = objectMapper.readValue(request, Country.class);
            return countryCrudService.delete(country);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_LOCATION_STATE)) {
            LocationState locationState = objectMapper.readValue(request, LocationState.class);
            return locationStateCrudService.delete(locationState);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_LOCATION_STATE_MAPPING)) {
            LocationStateMapping locationStateMapping = objectMapper.readValue(request, LocationStateMapping.class);
            return locationStateMappingCrudService.delete(locationStateMapping);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_LOCATION)) {
            Location location = objectMapper.readValue(request, Location.class);
            return locationCrudService.delete(location);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_LOCATION_SET_CTL)) {
            LocationSetCtl locationSetCtl = objectMapper.readValue(request, LocationSetCtl.class);
            return locationSetCtlCrudService.delete(locationSetCtl);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_LOCATION_SET_DTL)) {
            LocationSetDtl locationSetDtl = objectMapper.readValue(request, LocationSetDtl.class);
            return locationSetDtlCrudService.delete(locationSetDtl);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_SUPPLIER_ACCOUNT)) {
            SupplierAccount supplierAccount = objectMapper.readValue(request, SupplierAccount.class);
            return supplierAccountCrudService.delete(supplierAccount);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_MERCH_UDA_HIER_DEFAULT)) {
            MerchUdaHierDefault merchUdaHierDefault = objectMapper.readValue(request, MerchUdaHierDefault.class);
            return merchUdaHierDefaultCrudService.delete(merchUdaHierDefault);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_PRODUCT_VOLUMETRICS)) {
            ProductVolumetrics productVolumetrics = objectMapper.readValue(request, ProductVolumetrics.class);
            return productVolumetricsCrudService.delete(productVolumetrics);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_POS_ITEM_ROLLUP)) {
            PosItemRollup posItemRollup = objectMapper.readValue(request, PosItemRollup.class);
            return posItemRollupCrudService.delete(posItemRollup);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_PRODUCT_BARCODE)) {
            ProductBarcode productBarcode = objectMapper.readValue(request, ProductBarcode.class);
            return productBarcodeCrudService.delete(productBarcode);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_PRODUCT_UDA_MAP)) {
            ProductUdaMap productUdaMap = objectMapper.readValue(request, ProductUdaMap.class);
            return productUdaMapCrudService.delete(productUdaMap);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_PRODUCT_UDA_DATE)) {
            ProductUdaDate productUdaDate = objectMapper.readValue(request, ProductUdaDate.class);
            return productUdaDateCrudService.delete(productUdaDate);
        } else {
            return new ResponseDTO("MsgException: Delete message was not processed", HttpStatus.INTERNAL_SERVER_ERROR, request);
        }
    }

        /*
    @Override
    public ResponseDTO insertPayload(String entityName, String request) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_MERCH_UDA)) {
            MerchUda merchUda = objectMapper.readValue(request,
                    MerchUda.class);
            return merchUdaCrudService.insert(merchUda);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_MERCH_UDA_VALUE)) {
            MerchUdaValue merchUdaValue = objectMapper.readValue(request,
                    MerchUdaValue.class);
            return merchUdaValueCrudService.insert(merchUdaValue);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_MERCH_CLASS)) {
            MerchClass merchClass = objectMapper.readValue(request,
                    MerchClass.class);
            return merchClassCrudService.insert(merchClass);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_MERCH_DEPS)) {
            MerchDeps merchDeps = objectMapper.readValue(request,
                    MerchDeps.class);
            return merchDepsCrudService.insert(merchDeps);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_MERCH_SUBCLASS)) {
            MerchSubclass merchSubclass = objectMapper.readValue(request,
                    MerchSubclass.class);
            return merchSubclassCrudService.insert(merchSubclass);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_PRODUCT)) {
            Product product = objectMapper.readValue(request,
                    Product.class);
            return productCrudService.insert(product);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_SUPPLIER_ACCOUNT_PRODUCT)) {
            SupplierAccountProduct supplierAccountProduct = objectMapper.readValue(request,
                    SupplierAccountProduct.class);
            return supplierAccountProductCrudService.insert(supplierAccountProduct);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_COUNTRY)) {
            Country country = objectMapper.readValue(request,
                    Country.class);
            return countryCrudService.insert(country);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_LOCATION_STATE)) {
            LocationState locationState = objectMapper.readValue(request,
                    LocationState.class);
            return locationStateCrudService.insert(locationState);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_LOCATION_STATE_MAPPING)) {
            LocationStateMapping locationStateMapping = objectMapper.readValue(request,
                    LocationStateMapping.class);
            return locationStateMappingCrudService.insert(locationStateMapping);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_LOCATION)) {
            Location location = objectMapper.readValue(request,
                    Location.class);
            return locationCrudService.insert(location);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_LOCATION_SET_CTL)) {
            LocationSetCtl locationSetCtl = objectMapper.readValue(request,
                    LocationSetCtl.class);
            return locationSetCtlCrudService.insert(locationSetCtl);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_LOCATION_SET_DTL)) {
            LocationSetDtl locationSetDtl = objectMapper.readValue(request,
                    LocationSetDtl.class);
            return locationSetDtlCrudService.insert(locationSetDtl);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_BRAND)) {
            Brand brand = objectMapper.readValue(request,
                    Brand.class);
            return brandCrudService.insert(brand);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_SUPPLIER_ACCOUNT)) {
            SupplierAccount supplierAccount = objectMapper.readValue(request,
                    SupplierAccount.class);
            return supplierAccountCrudService.insert(supplierAccount);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_MERCH_UDA_HIER_DEFAULT)) {
            MerchUdaHierDefault merchUdaHierDefault = objectMapper.readValue(request,
                    MerchUdaHierDefault.class);
            return merchUdaHierDefaultCrudService.insert(merchUdaHierDefault);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_PRODUCT_VOLUMETRICS)) {
            ProductVolumetrics productVolumetrics = objectMapper.readValue(request, ProductVolumetrics.class);
            return productVolumetricsCrudService.insert(productVolumetrics);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_POS_ITEM_ROLLUP)) {
            PosItemRollup posItemRollup = objectMapper.readValue(request,
                    PosItemRollup.class);
            return posItemRollupCrudService.insert(posItemRollup);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_PRODUCT_BARCODE)) {
            ProductBarcode productBarcode = objectMapper.readValue(request,
                    ProductBarcode.class);
            return productBarcodeCrudService.insert(productBarcode);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_PRODUCT_UDA_MAP)) {
            ProductUdaMap productUdaMap = objectMapper.readValue(request, ProductUdaMap.class);
            return productUdaMapCrudService.insert(productUdaMap);
        } else if (entityName.equalsIgnoreCase(FoundationUtil.JSON_TABLE_NAME_PRODUCT_UDA_DATE)) {
            ProductUdaDate productUdaDate = objectMapper.readValue(request, ProductUdaDate.class);
            return productUdaDateCrudService.update(productUdaDate);
        } else {
            return new ResponseDTO("MsgException: Insert message was not processed", HttpStatus.INTERNAL_SERVER_ERROR, request);
        }
    }
*/

}

package au.com.tgg.apps.foundation.model;

public enum MerchUdaFieldMap {
    EXT_WTY_TYPE("extWtyType", "EXTENDED_WARRANTY_AUS"),
    PROD_TYPE("prodType", "PRODUCT_TYPE"),
    WTY_PRD_MTHS("wtyPrdMths", "MANUFACTURERS_WARRANTY_AUS"),
    TGG_EXCLUSIVE_IND("tggExclusiveInd", "TGG_EXCLUSIVE"),
    SERVICE_GROUP("serviceGroup", "SERVICE_GROUP"),
    CONCIERGE("concierge", "CONCIERGE"),
    PROD_CORE_RANGE("prodCoreRange", "RANGING_FLAG_AUS"),
    PRD_POWER_SKU_IND("prodPwrSkuInd","AU_POWER_SKU");

    private String fieldName;
    private String uda_code_name;

    MerchUdaFieldMap(String fieldName, String uda_code_name) {
        this.fieldName = fieldName;
        this.uda_code_name = uda_code_name;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getUda_code_name() {
        return uda_code_name;
    }

    public void setUda_code_name(String uda_code_name) {
        this.uda_code_name = uda_code_name;
    }
}

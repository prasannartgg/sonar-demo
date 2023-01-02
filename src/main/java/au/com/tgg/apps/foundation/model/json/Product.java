package au.com.tgg.apps.foundation.model.json;

import com.fasterxml.jackson.annotation.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Product
 * <p>
 * This is product
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "inv_name",
        "prod_nbr",
        "supplier_id",
        "sup_prod_nbr",
        "group_id",
        "sup_prod_descr",
        "product_heading",
        "prod_core_range",
        "prod_active_ind",
        "prod_purch_active_ind",
        "prod_web_ready_ind",
        "cost_ex_price",
        "created_user",
        "last_update_date",
        "last_update_user",
        "msku_prod_nbr",
        "product_callout",
        "consumer_prod_nbr",
        "short_prod_desc",
        "long_prod_desc",
        "uom_selling",
        "uom_purchasing",
        "ext_wty_type",
        "prod_type",
        "wty_prd_mths",
        "max_wty_prd_mths",
        "gtin",
        "prod_pwr_sku_ind",
        "tgg_exclusive_ind",
        "service_group",
        "concierge",
        "gst_rate",
        "supplier_account_id"
})
public class Product extends JsonHeader {


    /**
     * product field
     */
    @JsonProperty("inv_name")
    @JsonPropertyDescription("product field")
    private String invName;

    @JsonProperty("lead_time")
    @JsonPropertyDescription("lead time field")
    private BigInteger leadTime;
    /**
     * product field
     * (Required)
     */
    @JsonProperty("prod_nbr")
    @JsonPropertyDescription("product field")
    private String prodNbr;
    /**
     * product field
     */
    @JsonProperty("supplier_id")
    @JsonPropertyDescription("product field")
    private BigInteger supplierId;
    /**
     * product field
     * (Required)
     */
    @JsonProperty("sup_prod_nbr")
    @JsonPropertyDescription("product field")
    private String supProdNbr;
    /**
     * product field
     */
    @JsonProperty("brand_id")
    @JsonPropertyDescription("product field")
    private BigInteger brand_id;
    /**
     * product field
     */
    @JsonProperty("brand_code")
    @JsonPropertyDescription("product field")
    private String brandCode;

    @JsonProperty("primary_supp_ind")
    @JsonPropertyDescription("primary supplier indicator field")
    private String primarySuppInd;
    /**
     * product field
     */
    @JsonProperty("group_id")
    @JsonPropertyDescription("product field")
    private BigInteger groupId;

    @JsonProperty("group_xx")
    @JsonPropertyDescription("product field")
    private String groupCode;
    /**
     * product field
     */
    @JsonProperty("sup_prod_descr")
    @JsonPropertyDescription("product field")
    private String supProdDescr;
    /**
     * product field
     */
    @JsonProperty("product_heading")
    @JsonPropertyDescription("product field")
    private String productHeading;
    /**
     * product field
     */
    @JsonProperty("prod_core_range")
    @JsonPropertyDescription("product field")
    private String prodCoreRange;
    /**
     * product field
     * (Required)
     */
    @JsonProperty("prod_active_ind")
    @JsonPropertyDescription("product field")
    private String prodActiveInd;
    /**
     * product field
     * (Required)
     */
    @JsonProperty("prod_purch_active_ind")
    @JsonPropertyDescription("product field")
    private String prodPurchActiveInd;
    /**
     * product field
     */
    @JsonProperty("prod_web_ready_ind")
    @JsonPropertyDescription("product field")
    private String prodWebReadyInd;
    /**
     * product field
     */
    @JsonProperty("cost_ex_price")
    @JsonPropertyDescription("product field")
    private Double costExPrice = new Double("0");
    /**
     * product field
     */
    @JsonProperty("created_user")
    @JsonPropertyDescription("product field")
    private String createdUser;
    /**
     * product field
     */
    @JsonProperty("last_update_date")
    @JsonPropertyDescription("product field")
    private LocalDate lastUpdateDate;
    /**
     * product field
     */
    @JsonProperty("last_update_user")
    @JsonPropertyDescription("product field")
    private String lastUpdateUser;
    /**
     * product field
     */
    @JsonProperty("msku_prod_nbr")
    @JsonPropertyDescription("product field")
    private String mskuProdNbr;
    /**
     * product field
     */
    @JsonProperty("product_callout")
    @JsonPropertyDescription("product field")
    private String productCallout;
    /**
     * product field
     */
    @JsonProperty("consumer_prod_nbr")
    @JsonPropertyDescription("product field")
    private String consumerProdNbr;
    /**
     * product field
     */
    @JsonProperty("short_prod_desc")
    @JsonPropertyDescription("product field")
    private String shortProdDesc;
    /**
     * product field
     */
    @JsonProperty("long_prod_desc")
    @JsonPropertyDescription("product field")
    private String longProdDesc;
    /**
     * product field
     */
    @JsonProperty("uom_selling")
    @JsonPropertyDescription("product field")
    private String uomSelling;
    /**
     * product field
     */
    @JsonProperty("uom_purchasing")
    @JsonPropertyDescription("product field")
    private String uomPurchasing;
    /**
     * product field
     */
    @JsonProperty("ext_wty_type")
    @JsonPropertyDescription("product field")
    private String extWtyType;
    /**
     * product field
     */
    @JsonProperty("prod_type")
    @JsonPropertyDescription("product field")
    private String prodType;
    /**
     * product field
     */
    @JsonProperty("wty_prd_mths")
    @JsonPropertyDescription("product field")
    private Integer wtyPrdMths;
    /**
     * product field
     */
    @JsonProperty("max_wty_prd_mths")
    @JsonPropertyDescription("product field")
    private Integer maxWtyPrdMths;
    /**
     * product field
     */
    @JsonProperty("gtin")
    @JsonPropertyDescription("product field")
    private String gtin;
    /**
     * product field
     */
    @JsonProperty("prod_pwr_sku_ind")
    @JsonPropertyDescription("product field")
    private String prodPwrSkuInd;
    /**
     * product field
     * (Required)
     */
    @JsonProperty("tgg_exclusive_ind")
    @JsonPropertyDescription("product field")
    private String tggExclusiveInd;
    /**
     * product field
     */
    @JsonProperty("service_group")
    @JsonPropertyDescription("product field")
    private String serviceGroup;
    /**
     * product field
     * (Required)
     */
    @JsonProperty("concierge")
    @JsonPropertyDescription("product field")
    private String concierge;
    /**
     * product field
     */
    @JsonProperty("gst_rate")
    @JsonPropertyDescription("product field")
    private BigInteger gstRate;
    /**
     * product field
     */
    @JsonProperty("subclass_id")
    @JsonPropertyDescription("product field")
    private BigInteger subclassId;
    /**
     * product field
     */
    @JsonProperty("subclass")
    @JsonPropertyDescription("product field")
    private short subclass = 0;


    /**
     * product field
     */
    @JsonProperty("clazz")
    @JsonPropertyDescription("product field")
    private short clazz = 0;
    /**
     * product field
     */
    @JsonProperty("account_number")
    @JsonPropertyDescription("account_number field")
    private String account_number;
    /**
     * product field
     */
    @JsonProperty("supplier_account_id")
    @JsonPropertyDescription("product field")
    private BigInteger supplierAccountId;


    @JsonProperty("UDAs")
    @JsonPropertyDescription("tgg uda list field")
    private List<TggUDA> tggUDAList;

    @JsonIgnore
    private final Map<String, String> additionalProperties = new HashMap<String, String>();


    public short getClazz() {
        return clazz;
    }

    public void setClazz(short clazz) {
        this.clazz = clazz;
    }

    public List<TggUDA> getTggUDAList() {
        return tggUDAList;
    }

    public void setTggUDAList(List<TggUDA> tggUDAList) {
        this.tggUDAList = tggUDAList;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }


    public short getSubclass() {
        return subclass;
    }

    public void setSubclass(short subclass) {
        this.subclass = subclass;
    }

    public BigInteger getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(BigInteger leadTime) {
        this.leadTime = leadTime;
    }


    /**
     * product field
     */

    public String getInvName() {
        return invName;
    }

    /**
     * product field
     */

    public void setInvName(String invName) {
        this.invName = invName;
    }

    /**
     * product field
     * (Required)
     */

    public String getProdNbr() {
        return prodNbr;
    }

    /**
     * product field
     * (Required)
     */

    public void setProdNbr(String prodNbr) {
        this.prodNbr = prodNbr;
    }

    /**
     * product field
     */

    public BigInteger getSupplierId() {
        return supplierId;
    }

    /**
     * product field
     */

    public void setSupplierId(BigInteger supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * product field
     * (Required)
     */

    public String getSupProdNbr() {
        return supProdNbr;
    }

    /**
     * product field
     * (Required)
     */

    public void setSupProdNbr(String supProdNbr) {
        this.supProdNbr = supProdNbr;
    }


    public BigInteger getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(BigInteger brand_id) {
        this.brand_id = brand_id;
    }

    /**
     * product field
     */

    public BigInteger getGroupId() {
        return groupId;
    }

    /**
     * product field
     */

    public void setGroupId(BigInteger groupId) {
        this.groupId = groupId;
    }

    /**
     * product field
     */

    public String getSupProdDescr() {
        return supProdDescr;
    }

    /**
     * product field
     */

    public void setSupProdDescr(String supProdDescr) {
        this.supProdDescr = supProdDescr;
    }

    /**
     * product field
     */

    public String getProductHeading() {
        return productHeading;
    }

    /**
     * product field
     */

    public void setProductHeading(String productHeading) {
        this.productHeading = productHeading;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getPrimarySuppInd() {
        return primarySuppInd;
    }

    public void setPrimarySuppInd(String primarySuppInd) {
        this.primarySuppInd = primarySuppInd;
    }

    /**
     * product field
     */


    public String getProdCoreRange() {
        return prodCoreRange;
    }

    /**
     * product field
     */

    public void setProdCoreRange(String prodCoreRange) {
        this.prodCoreRange = prodCoreRange;
    }

    /**
     * product field
     * (Required)
     */

    public String getProdActiveInd() {
        return prodActiveInd;
    }

    /**
     * product field
     * (Required)
     */

    public void setProdActiveInd(String prodActiveInd) {
        this.prodActiveInd = prodActiveInd;
    }

    /**
     * product field
     * (Required)
     */

    public String getProdPurchActiveInd() {
        return prodPurchActiveInd;
    }

    /**
     * product field
     * (Required)
     */

    public void setProdPurchActiveInd(String prodPurchActiveInd) {
        this.prodPurchActiveInd = prodPurchActiveInd;
    }

    /**
     * product field
     */

    public String getProdWebReadyInd() {
        return prodWebReadyInd;
    }

    /**
     * product field
     */

    public void setProdWebReadyInd(String prodWebReadyInd) {
        this.prodWebReadyInd = prodWebReadyInd;
    }

    /**
     * product field
     */

    public Double getCostExPrice() {
        return costExPrice;
    }

    /**
     * product field
     */

    public void setCostExPrice(Double costExPrice) {
        this.costExPrice = costExPrice;
    }

    /**
     * product field
     */

    public String getCreatedUser() {
        return createdUser;
    }

    /**
     * product field
     */

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * product field
     */

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * product field
     */

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * product field
     */

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    /**
     * product field
     */

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    /**
     * product field
     */

    public String getMskuProdNbr() {
        return mskuProdNbr;
    }

    /**
     * product field
     */

    public void setMskuProdNbr(String mskuProdNbr) {
        this.mskuProdNbr = mskuProdNbr;
    }

    /**
     * product field
     */

    public String getProductCallout() {
        return productCallout;
    }

    /**
     * product field
     */

    public void setProductCallout(String productCallout) {
        this.productCallout = productCallout;
    }

    /**
     * product field
     */

    public String getConsumerProdNbr() {
        return consumerProdNbr;
    }

    /**
     * product field
     */

    public void setConsumerProdNbr(String consumerProdNbr) {
        this.consumerProdNbr = consumerProdNbr;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    /**
     * product field
     */


    public String getShortProdDesc() {
        return shortProdDesc;
    }

    /**
     * product field
     */

    public void setShortProdDesc(String shortProdDesc) {
        this.shortProdDesc = shortProdDesc;
    }

    /**
     * product field
     */

    public String getLongProdDesc() {
        return longProdDesc;
    }

    /**
     * product field
     */

    public void setLongProdDesc(String longProdDesc) {
        this.longProdDesc = longProdDesc;
    }

    /**
     * product field
     */

    public String getUomSelling() {
        return uomSelling;
    }

    /**
     * product field
     */

    public void setUomSelling(String uomSelling) {
        this.uomSelling = uomSelling;
    }

    /**
     * product field
     */

    public String getUomPurchasing() {
        return uomPurchasing;
    }

    /**
     * product field
     */

    public void setUomPurchasing(String uomPurchasing) {
        this.uomPurchasing = uomPurchasing;
    }

    /**
     * product field
     */

    public String getExtWtyType() {
        return extWtyType;
    }

    /**
     * product field
     */

    public void setExtWtyType(String extWtyType) {
        this.extWtyType = extWtyType;
    }

    /**
     * product field
     */

    public String getProdType() {
        return prodType;
    }

    /**
     * product field
     */

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    /**
     * product field
     */

    public Integer getWtyPrdMths() {
        return wtyPrdMths;
    }

    /**
     * product field
     */

    public void setWtyPrdMths(Integer wtyPrdMths) {
        this.wtyPrdMths = wtyPrdMths;
    }

    /**
     * product field
     */

    public Integer getMaxWtyPrdMths() {
        return maxWtyPrdMths;
    }

    /**
     * product field
     */

    public void setMaxWtyPrdMths(Integer maxWtyPrdMths) {
        this.maxWtyPrdMths = maxWtyPrdMths;
    }

    /**
     * product field
     */

    public String getGtin() {
        return gtin;
    }

    /**
     * product field
     */

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    /**
     * product field
     */

    public String getProdPwrSkuInd() {
        return prodPwrSkuInd;
    }

    /**
     * product field
     */

    public void setProdPwrSkuInd(String prodPwrSkuInd) {
        this.prodPwrSkuInd = prodPwrSkuInd;
    }

    /**
     * product field
     * (Required)
     */

    public String getTggExclusiveInd() {
        return tggExclusiveInd;
    }

    /**
     * product field
     * (Required)
     */

    public void setTggExclusiveInd(String tggExclusiveInd) {
        this.tggExclusiveInd = tggExclusiveInd;
    }

    /**
     * product field
     */

    public String getServiceGroup() {
        return serviceGroup;
    }

    /**
     * product field
     */

    public void setServiceGroup(String serviceGroup) {
        this.serviceGroup = serviceGroup;
    }

    /**
     * product field
     * (Required)
     */

    public String getConcierge() {
        return concierge;
    }

    /**
     * product field
     * (Required)
     */

    public void setConcierge(String concierge) {
        this.concierge = concierge;
    }

    /**
     * product field
     */

    public BigInteger getGstRate() {
        return gstRate;
    }

    /**
     * product field
     */

    public void setGstRate(BigInteger gstRate) {
        this.gstRate = gstRate;
    }

    /**
     * product field
     */

    public BigInteger getSubclassId() {
        return subclassId;
    }

    /**
     * product field
     */

    public void setSubclassId(BigInteger subclassId) {
        this.subclassId = subclassId;
    }

    /**
     * product field
     */

    public BigInteger getSupplierAccountId() {
        return supplierAccountId;
    }

    /**
     * product field
     */

    public void setSupplierAccountId(BigInteger supplierAccountId) {
        this.supplierAccountId = supplierAccountId;
    }

    @JsonAnyGetter
    public Map<String, String> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, String value) {
        this.additionalProperties.put(name, value);
    }

}

package au.com.tgg.apps.foundation.model.json;

import au.com.tgg.apps.foundation.util.JsonDateDeserializer;
import au.com.tgg.apps.foundation.util.JsonDateTimeSerializer;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


/**
 * SUPPLIER_ACCOUNT_PRODUCT
 * <p>
 * This is SUPPLIER_ACCOUNT_PRODUCT
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "inv_name",
        "prod_nbr",
        "supplier_account_id",
        "sup_prod_nbr",
        "cost_ex_price",
        "created_date",
        "created_user",
        "last_update_date",
        "last_update_user",
        "primary_supp_ind"
})
public class SupplierAccountProduct extends JsonHeader {

    @JsonProperty("inv_name")
    private String invName;
    @JsonProperty("prod_nbr")
    private String prodNbr;
    /**
     * (Required)
     */
    @JsonProperty("supplier_account_xx")
    private String supplier_account_xx;
    @JsonProperty("supplier_account_id")
    private BigInteger supplierAccountId;
    @JsonProperty("sup_prod_nbr")
    private String supProdNbr;
    @JsonProperty("cost_ex_price")
    private String costExPrice;
    @JsonProperty("created_date")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private LocalDate createdDate;
    @JsonProperty("created_user")
    private String createdUser;
    @JsonProperty("last_update_date")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private LocalDate lastUpdateDate;
    @JsonProperty("last_update_user")
    private String lastUpdateUser;
    @JsonProperty("primary_supp_ind")
    private String primarySuppInd;
    @JsonProperty("supp_label")
    private String suppLabel;
    @JsonIgnore
    private final Map<String, String> additionalProperties = new HashMap<String, String>();

    public String getSupplier_account_xx() {
        return supplier_account_xx;
    }

    public void setSupplier_account_xx(String supplier_account_xx) {
        this.supplier_account_xx = supplier_account_xx;
    }

    public String getInvName() {
        return invName;
    }

    public void setInvName(String invName) {
        this.invName = invName;
    }

    public String getProdNbr() {
        return prodNbr;
    }

    public void setProdNbr(String prodNbr) {
        this.prodNbr = prodNbr;
    }

    /**
     * (Required)
     */
    public BigInteger getSupplierAccountId() {
        return supplierAccountId;
    }

    /**
     * (Required)
     */
    public void setSupplierAccountId(BigInteger supplierAccountId) {
        this.supplierAccountId = supplierAccountId;
    }

    public String getSupProdNbr() {
        return supProdNbr;
    }

    public void setSupProdNbr(String supProdNbr) {
        this.supProdNbr = supProdNbr;
    }

    public String getCostExPrice() {
        return costExPrice;
    }

    public void setCostExPrice(String costExPrice) {
        this.costExPrice = costExPrice;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public String getPrimarySuppInd() {
        return primarySuppInd;
    }

    public void setPrimarySuppInd(String primarySuppInd) {
        this.primarySuppInd = primarySuppInd;
    }

    public String getSuppLabel() {
        return suppLabel;
    }

    public void setSuppLabel(String suppLabel) {
        this.suppLabel = suppLabel;
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

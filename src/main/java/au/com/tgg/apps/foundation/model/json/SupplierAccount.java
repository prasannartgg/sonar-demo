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
 * SUPPLIER_ACCOUNT
 * <p>
 * This is SUPPLIER_ACCOUNT
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "supplier_account_id",
        "account_INT",
        "account_name",
        "pp_deal_parity_ind",
        "pp_age_of_stock",
        "sup_ldg_code",
        "sup_acc_active_ind",
        "created_date",
        "created_user",
        "last_update_date",
        "last_update_user",
        "country_code",
        "tgg_url"
})
public class SupplierAccount  extends JsonHeader{

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("supplier_account_id")
    private BigInteger supplierAccountId;
    @JsonProperty("account_number")
    private String accountNumber;
    @JsonProperty("account_name")
    private String accountName;
    @JsonProperty("pp_deal_parity_ind")
    private String ppDealParityInd;
    @JsonProperty("pp_age_of_stock")
    private BigInteger ppAgeOfStock;
    @JsonProperty("sup_ldg_code")
    private String supLdgCode;
    @JsonProperty("sup_status")
    private String supStatus;
    @JsonProperty("sup_acc_active_ind")
    private String supAccActiveInd;
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
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("tgg_url")
    private String tggUrl;
    @JsonIgnore
    private final Map<String, String> additionalProperties = new HashMap<String, String>();

    /**
     *
     * (Required)
     *
     */
    public BigInteger getSupplierAccountId() {
        return supplierAccountId;
    }

    public String getSupStatus() {
        return supStatus;
    }

    public void setSupStatus(String supStatus) {
        this.supStatus = supStatus;
    }

    /**
     *
     * (Required)
     *
     */


    public void setSupplierAccountId(BigInteger supplierAccountId) {
        this.supplierAccountId = supplierAccountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPpDealParityInd() {
        return ppDealParityInd;
    }

    public void setPpDealParityInd(String ppDealParityInd) {
        this.ppDealParityInd = ppDealParityInd;
    }

    public BigInteger getPpAgeOfStock() {
        return ppAgeOfStock;
    }

    public void setPpAgeOfStock(BigInteger ppAgeOfStock) {
        this.ppAgeOfStock = ppAgeOfStock;
    }

    public String getSupLdgCode() {
        return supLdgCode;
    }

    public void setSupLdgCode(String supLdgCode) {
        this.supLdgCode = supLdgCode;
    }

    public String getSupAccActiveInd() {
        return supAccActiveInd;
    }

    public void setSupAccActiveInd(String supAccActiveInd) {
        this.supAccActiveInd = supAccActiveInd;
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTggUrl() {
        return tggUrl;
    }

    public void setTggUrl(String tggUrl) {
        this.tggUrl = tggUrl;
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

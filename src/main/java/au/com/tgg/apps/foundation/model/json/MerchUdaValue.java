package au.com.tgg.apps.foundation.model.json;

import com.fasterxml.jackson.annotation.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


/**
 * MERCH_UDA_VALUE
 * <p>
 * This is MERCH_UDA_VALUE
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "uda_value_id",
        "source_uda_value_id",
        "uda_id",
        "uda_value_code",
        "uda_value_desc",
        "isdefault",
        "deleted",
        "created_by",
        "created_date",
        "last_modified_by",
        "last_modified_date"
})
public class MerchUdaValue extends JsonHeader {

    @JsonProperty("uda_value_id")
    private BigInteger udaValueId;
    @JsonProperty("source_uda_value_id")
    private BigInteger sourceUdaValueId;
    @JsonProperty("uda_id")
    private BigInteger udaId;
    @JsonProperty("uda_value_code")
    private String udaValueCode;
    @JsonProperty("uda_value_desc")
    private String udaValueDesc;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("isdefault")
    private String isdefault;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("deleted")
    private String deleted;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("created_by")
    private String createdBy;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("created_date")
    private LocalDate createdDate;
    @JsonProperty("last_modified_by")
    private String lastModifiedBy;
    @JsonProperty("last_modified_date")
    private LocalDate lastModifiedDate;
    @JsonIgnore
    private final Map<String, String> additionalProperties = new HashMap<String, String>();

    public BigInteger getUdaValueId() {
        return udaValueId;
    }

    public void setUdaValueId(BigInteger udaValueId) {
        this.udaValueId = udaValueId;
    }

    public BigInteger getSourceUdaValueId() {
        return sourceUdaValueId;
    }

    public void setSourceUdaValueId(BigInteger sourceUdaValueId) {
        this.sourceUdaValueId = sourceUdaValueId;
    }

    public BigInteger getUdaId() {
        return udaId;
    }

    public void setUdaId(BigInteger udaId) {
        this.udaId = udaId;
    }

    public String getUdaValueCode() {
        return udaValueCode;
    }

    public void setUdaValueCode(String udaValueCode) {
        this.udaValueCode = udaValueCode;
    }

    public String getUdaValueDesc() {
        return udaValueDesc;
    }

    public void setUdaValueDesc(String udaValueDesc) {
        this.udaValueDesc = udaValueDesc;
    }

    /**
     *
     * (Required)
     *
     */
    public String getIsdefault() {
        return isdefault;
    }

    /**
     *
     * (Required)
     *
     */
    public void setIsdefault(String isdefault) {
        this.isdefault = isdefault;
    }

    /**
     *
     * (Required)
     *
     */
    public String getDeleted() {
        return deleted;
    }

    /**
     *
     * (Required)
     *
     */
    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    /**
     *
     * (Required)
     *
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     *
     * (Required)
     *
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     *
     * (Required)
     *
     */
    public LocalDate getCreatedDate() {
        return createdDate;
    }

    /**
     *
     * (Required)
     *
     */
    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
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

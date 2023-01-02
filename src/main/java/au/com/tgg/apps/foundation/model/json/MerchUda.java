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
 * MERCH_UDA
 * <p>
 * This is MERCH_UDA
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "uda_id",
        "source_uda_id",
        "source_system",
        "uda_code",
        "uda_desc",
        "data_type",
        "data_length",
        "manually_maintained",
        "deleted",
        "created_by",
        "created_date",
        "last_modified_by",
        "last_modified_date"
})
public class MerchUda extends JsonHeader{

    @JsonProperty("uda_id")
    private BigInteger udaId;
    @JsonProperty("source_uda_id")
    private BigInteger sourceUdaId;
    @JsonProperty("source_system")
    private String sourceSystem;
    @JsonProperty("uda_code")
    private String udaCode;
    @JsonProperty("uda_desc")
    private String udaDesc;
    @JsonProperty("data_type")
    private String dataType;
    @JsonProperty("data_length")
    private BigInteger dataLength;
    @JsonProperty("manually_maintained")
    private String manuallyMaintained;
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
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private LocalDate createdDate;
    @JsonProperty("last_modified_by")
    private String lastModifiedBy;
    @JsonProperty("last_modified_date")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private LocalDate lastModifiedDate;
    @JsonIgnore
    private final Map<String, String> additionalProperties = new HashMap<String, String>();

    public BigInteger getUdaId() {
        return udaId;
    }

    public void setUdaId(BigInteger udaId) {
        this.udaId = udaId;
    }

    public BigInteger getSourceUdaId() {
        return sourceUdaId;
    }

    public void setSourceUdaId(BigInteger sourceUdaId) {
        this.sourceUdaId = sourceUdaId;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getUdaCode() {
        return udaCode;
    }

    public void setUdaCode(String udaCode) {
        this.udaCode = udaCode;
    }

    public String getUdaDesc() {
        return udaDesc;
    }

    public void setUdaDesc(String udaDesc) {
        this.udaDesc = udaDesc;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public BigInteger getDataLength() {
        return dataLength;
    }

    public void setDataLength(BigInteger dataLength) {
        this.dataLength = dataLength;
    }

    public String getManuallyMaintained() {
        return manuallyMaintained;
    }

    public void setManuallyMaintained(String manuallyMaintained) {
        this.manuallyMaintained = manuallyMaintained;
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
    public Object getCreatedBy() {
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

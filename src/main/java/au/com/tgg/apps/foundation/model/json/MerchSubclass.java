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
 * MERCH_SUBCLASS
 * <p>
 * This is MERCH_SUBCLASS
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "subclass_id",
        "class_id",
        "subclass",
        "subclass_name",
        "deleted",
        "created_by",
        "created_date",
        "last_modified_by",
        "last_modified_date"
})
public class MerchSubclass extends JsonHeader {

    @JsonProperty("subclass_id")
    private BigInteger subclassId;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("class_id")
    private BigInteger classId;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("class_XX")
    private BigInteger classXX;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("subclass")
    private BigInteger subclass;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("subclass_name")
    private String subclassName;
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

    public BigInteger getSubclassId() {
        return subclassId;
    }

    public void setSubclassId(BigInteger subclassId) {
        this.subclassId = subclassId;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getClassId() {
        return classId;
    }

    /**
     *
     * (Required)
     *
     */
    public void setClassXX(BigInteger classXX) {
        this.classXX = classXX;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getClassXX() {
        return classXX;
    }

    /**
     *
     * (Required)
     *
     */
    public void setClassId(BigInteger classId) {
        this.classId = classId;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getSubclass() {
        return subclass;
    }

    /**
     *
     * (Required)
     *
     */
    public void setSubclass(BigInteger subclass) {
        this.subclass = subclass;
    }

    /**
     *
     * (Required)
     *
     */
    public String getSubclassName() {
        return subclassName;
    }

    /**
     *
     * (Required)
     *
     */
    public void setSubclassName(String subclassName) {
        this.subclassName = subclassName;
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

package au.com.tgg.apps.foundation.model.json;

import com.fasterxml.jackson.annotation.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


/**
 * MERCH_UDA_HIER_DEFAULT
 * <p>
 * This is MERCH_UDA_HIER_DEFAULT
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "uda_hier_def_id",
        "uda_value_id",
        "dep_id",
        "class_id",
        "subclass_id",
        "merch_level",
        "deleted",
        "created_by",
        "created_date",
        "last_modified_by",
        "last_modified_date"
})
public class MerchUdaHierDefault extends JsonHeader {

    @JsonProperty("uda_hier_def_id")
    private BigInteger udaHierDefId;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("uda_value_id")
    private BigInteger udaValueId;
    @JsonProperty("dep_id")
    private BigInteger depId;
    @JsonProperty("class_id")
    private BigInteger classId;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("subclass_id")
    private BigInteger subclassId;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("merch_level")
    private BigInteger merchLevel;
    @JsonProperty("deleted")
    private String deleted;
    @JsonProperty("created_by")
    private String createdBy;
    @JsonProperty("created_date")
    private LocalDate createdDate;
    @JsonProperty("last_modified_by")
    private String lastModifiedBy;
    @JsonProperty("last_modified_date")
    private LocalDate lastModifiedDate;
    @JsonIgnore
    private final Map<String, String> additionalProperties = new HashMap<String, String>();

    public BigInteger getUdaHierDefId() {
        return udaHierDefId;
    }

    public void setUdaHierDefId(BigInteger udaHierDefId) {
        this.udaHierDefId = udaHierDefId;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("uda_value_id")
    public BigInteger getUdaValueId() {
        return udaValueId;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("uda_value_id")
    public void setUdaValueId(BigInteger udaValueId) {
        this.udaValueId = udaValueId;
    }

    @JsonProperty("dep_id")
    public BigInteger getDepId() {
        return depId;
    }

    @JsonProperty("dep_id")
    public void setDepId(BigInteger depId) {
        this.depId = depId;
    }

    @JsonProperty("class_id")
    public BigInteger getClassId() {
        return classId;
    }

    @JsonProperty("class_id")
    public void setClassId(BigInteger classId) {
        this.classId = classId;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("subclass_id")
    public BigInteger getSubclassId() {
        return subclassId;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("subclass_id")
    public void setSubclassId(BigInteger subclassId) {
        this.subclassId = subclassId;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("merch_level")
    public BigInteger getMerchLevel() {
        return merchLevel;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("merch_level")
    public void setMerchLevel(BigInteger merchLevel) {
        this.merchLevel = merchLevel;
    }

    @JsonProperty("deleted")
    public String getDeleted() {
        return deleted;
    }

    @JsonProperty("deleted")
    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @JsonProperty("created_by")
    public String getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("created_by")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("created_date")
    public LocalDate getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("created_date")
    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("last_modified_by")
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    @JsonProperty("last_modified_by")
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @JsonProperty("last_modified_date")
    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    @JsonProperty("last_modified_date")
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

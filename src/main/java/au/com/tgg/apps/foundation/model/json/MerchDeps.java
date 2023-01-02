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
 * Merch_Deps
 * <p>
 * This is Merch_Deps
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "dep_id",
        "dept",
        "dept_name",
        "deleted",
        "created_by",
        "created_date",
        "last_modified_by",
        "last_modified_date"
})
public class MerchDeps extends JsonHeader {

    @JsonProperty("dep_id")
    private BigInteger depId;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("dept")
    private BigInteger dept;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("dept_name")
    private String deptName;
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

    public Object getDepId() {
        return depId;
    }

    public void setDepId(BigInteger depId) {
        this.depId = depId;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getDept() {
        return dept;
    }

    /**
     *
     * (Required)
     *
     */
    public void setDept(BigInteger dept) {
        this.dept = dept;
    }

    /**
     *
     * (Required)
     *
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     *
     * (Required)
     *
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
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

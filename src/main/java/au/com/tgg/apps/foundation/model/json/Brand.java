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
 * Brand
 * <p>
 * This is brand
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "operations",
        "brand_id",
        "brand_code",
        "brand_name",
        "brand_descr",
        "created_date",
        "created_user",
        "last_update_date",
        "last_update_user"
})
public class Brand extends JsonHeader {

    /**
     * brand id
     * (Required)
     *
     */
    @JsonProperty("BRAND_ID")
    @JsonPropertyDescription("brand id")
    private BigInteger brandId;
    /**
     * brand code
     * (Required)
     *
     */
    @JsonProperty("BRAND_CODE")
    @JsonPropertyDescription("brand code")
    private String brandCode;
    /**
     * brand name
     *
     */
    @JsonProperty("BRAND_NAME")
    @JsonPropertyDescription("brand name")
    private String brandName;
    /**
     * brand description
     *
     */
    @JsonProperty("BRAND_DESCRIPTION")
    @JsonPropertyDescription("brand description")
    private String brandDescr;
    /**
     * created date
     *
     */
    @JsonProperty("CREATE_DATETIME")
    @JsonPropertyDescription("created date")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private LocalDate createdDate;
    /**
     * created user
     *
     */
    @JsonProperty("CREATE_ID")
    @JsonPropertyDescription("created user")
    private String createdUser;
    /**
     * last updated date
     *
     */
    @JsonProperty("LAST_UPDATE_DATETIME")
    @JsonPropertyDescription("last updated date")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private LocalDate lastUpdateDate;
    /**
     * last update user
     *
     */
    @JsonProperty("LAST_UPDATE_ID")
    @JsonPropertyDescription("last update user")
    private String lastUpdateUser;
    @JsonIgnore
    private final Map<String, String> additionalProperties = new HashMap<String, String>();



    /**
     * brand id
     * (Required)
     *
     */
    public BigInteger getBrandId() {
        return brandId;
    }

    /**
     * brand id
     * (Required)
     *
     */
    public void setBrandId(BigInteger brandId) {
        this.brandId = brandId;
    }

    /**
     * brand code
     * (Required)
     *
     */
    public String getBrandCode() {
        return brandCode;
    }

    /**
     * brand code
     * (Required)
     *
     */
    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    /**
     * brand name
     *
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * brand name
     *
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * brand description
     *
     */
    public String getBrandDescr() {
        return brandDescr;
    }

    /**
     * brand description
     *
     */
    public void setBrandDescr(String brandDescr) {
        this.brandDescr = brandDescr;
    }

    /**
     * created date
     *
     */
    public LocalDate getCreatedDate() {
        return createdDate;
    }

    /**
     * created date
     *
     */
    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * created user
     *
     */
    public String getCreatedUser() {
        return createdUser;
    }

    /**
     * created user
     *
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * last updated date
     *
     */
    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * last updated date
     *
     */
    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * last update user
     *
     */
    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    /**
     * last update user
     *
     */
    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
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

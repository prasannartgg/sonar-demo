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
 * Location_Set_Ctl
 * <p>
 * This is Location_Set_Ctl
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "location_set_id",
        "inv_name",
        "locn_set_name",
        "locn_set_descr",
        "locn_set_long_descr",
        "created_date",
        "created_user",
        "last_update_date",
        "last_update_user"
})
public class LocationSetCtl extends JsonHeader {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("location_set_id")
    private BigInteger locationSetId;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("inv_name")
    private String invName;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("locn_set_name")
    private String locnSetName;
    @JsonProperty("locn_set_descr")
    private String locnSetDescr;
    @JsonProperty("locn_set_long_descr")
    private String locnSetLongDescr;
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
    @JsonIgnore
    private final Map<String, String> additionalProperties = new HashMap<String, String>();

    /**
     *
     * (Required)
     *
     */
    public BigInteger getLocationSetId() {
        return locationSetId;
    }

    /**
     *
     * (Required)
     *
     */
    public void setLocationSetId(BigInteger locationSetId) {
        this.locationSetId = locationSetId;
    }

    /**
     *
     * (Required)
     *
     */
    public String getInvName() {
        return invName;
    }

    /**
     *
     * (Required)
     *
     */
    public void setInvName(String invName) {
        this.invName = invName;
    }

    /**
     *
     * (Required)
     *
     */
    public String getLocnSetName() {
        return locnSetName;
    }

    /**
     *
     * (Required)
     *
     */
    public void setLocnSetName(String locnSetName) {
        this.locnSetName = locnSetName;
    }

    public String getLocnSetDescr() {
        return locnSetDescr;
    }

    public void setLocnSetDescr(String locnSetDescr) {
        this.locnSetDescr = locnSetDescr;
    }

    public String getLocnSetLongDescr() {
        return locnSetLongDescr;
    }

    public void setLocnSetLongDescr(String locnSetLongDescr) {
        this.locnSetLongDescr = locnSetLongDescr;
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

    @JsonAnyGetter
    public Map<String, String> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, String value) {
        this.additionalProperties.put(name, value);
    }

}

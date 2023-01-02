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
 * Location_State_Mapping
 * <p>
 * This is Location_state_mapping
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "location_state_mapping_id",
        "location_id",
        "location_state_id",
        "created_date",
        "created_user",
        "last_update_date",
        "last_update_user"
})
public class LocationStateMapping extends JsonHeader {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("location_state_mapping_id")
    private BigInteger locationStateMappingId;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("location_id")
    private BigInteger locationId;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("locn_XX")
    private String locnXX;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("location_state_id")
    private BigInteger locationStateId;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("state_XX")
    private String stateXX;
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
    public BigInteger getLocationStateMappingId() {
        return locationStateMappingId;
    }

    /**
     *
     * (Required)
     *
     */
    public void setLocationStateMappingId(BigInteger locationStateMappingId) {
        this.locationStateMappingId = locationStateMappingId;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getLocationId() {
        return locationId;
    }

    /**
     *
     * (Required)
     *
     */
    public void setLocationId(BigInteger locationId) {
        this.locationId = locationId;
    }

    /**
     *
     * (Required)
     *
     */
    public String getLocationXX() {
        return locnXX;
    }

    /**
     *
     * (Required)
     *
     */
    public void setLocationXX(String locnXX) {
        this.locnXX = locnXX;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getLocationStateId() {
        return locationStateId;
    }

    /**
     *
     * (Required)
     *
     */
    public void setStateXX(String stateXX) {
        this.stateXX = stateXX;
    }

    /**
     *
     * (Required)
     *
     */
    public String getStateXX() {
        return stateXX;
    }

    /**
     *
     * (Required)
     *
     */
    public void setLocationStateId(BigInteger locationStateId) {
        this.locationStateId = locationStateId;
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

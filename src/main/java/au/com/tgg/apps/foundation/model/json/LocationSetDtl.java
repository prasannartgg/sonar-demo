package au.com.tgg.apps.foundation.model.json;

import com.fasterxml.jackson.annotation.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;


/**
 * Location_Set_Dtl
 * <p>
 * This is Location_Set_Dtl
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "location_set_dtl_id",
        "location_set_id",
        "locn_set_XX",
        "location_id",
        "locn_name"
})
public class LocationSetDtl extends JsonHeader {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("location_set_dtl_id")
    private BigInteger locationSetDtlId;
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
    @JsonProperty("locn_set_XX")
    private String locationSetXX;
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
    private String locnName;
    @JsonIgnore
    private final Map<String, String> additionalProperties = new HashMap<String, String>();

    /**
     *
     * (Required)
     *
     */
    public BigInteger getLocationSetDtlId() {
        return locationSetDtlId;
    }

    /**
     *
     * (Required)
     *
     */
    public void setLocationSetDtlId(BigInteger locationSetDtlId) {
        this.locationSetDtlId = locationSetDtlId;
    }

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
    public String getLocationSetXX() {
        return locationSetXX;
    }

    /**
     *
     * (Required)
     *
     */
    public void setLocationSetXX(String locationSetXX) {
        this.locationSetXX = locationSetXX;
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
    public String getLocnName() {
        return locnName;
    }

    /**
     *
     * (Required)
     *
     */
    public void setLocnName(String locnName) {
        this.locnName = locnName;
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

package au.com.tgg.apps.foundation.model.json;

import com.fasterxml.jackson.annotation.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;


/**
 * Country
 * <p>
 * This is Country
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "operations",
        "country_description",
        "gst_rate",
        "gst_ratio",
        "inv_name",
        "clg_code",
        "currency_code",
        "automaton_country_id"
})
public class Country extends JsonHeader {

    /**
     * country Code
     * (Required)
     *
     */
    @JsonProperty("country_code")
    @JsonPropertyDescription("country Code")
    private String countryCode;
    /**
     * country description
     *
     */
    @JsonProperty("country_description")
    @JsonPropertyDescription("country description")
    private String countryDescription;
    /**
     * gst rate
     *
     */
    @JsonProperty("gst_rate")
    @JsonPropertyDescription("gst rate")
    private Double gstRate;
    /**
     * gst ratio
     *
     */
    @JsonProperty("gst_ratio")
    @JsonPropertyDescription("gst ratio")
    private Double gstRatio;
    /**
     * inventory name
     *
     */
    @JsonProperty("inv_name")
    @JsonPropertyDescription("inventory name")
    private String invName;
    /**
     * clg code
     *
     */
    @JsonProperty("clg_code")
    @JsonPropertyDescription("clg code")
    private String clgCode;
    /**
     * currency code
     *
     */
    @JsonProperty("currency_code")
    @JsonPropertyDescription("currency code")
    private String currencyCode;
    /**
     * automaton country id
     *
     */
    @JsonProperty("automaton_country_id")
    @JsonPropertyDescription("automaton country id")
    private BigInteger automatonCountryId;
    @JsonIgnore
    private final Map<String, String> additionalProperties = new HashMap<String, String>();


    /**
     * country Code
     * (Required)
     *
     */
    public String getCountryCode() {
        return countryCode;
    }
    /**
     * country Code
     * (Required)
     *
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    /**
     * country description
     *
     */
    public String getCountryDescription() {
        return countryDescription;
    }

    /**
     * country description
     *
     */
    public void setCountryDescription(String countryDescription) {
        this.countryDescription = countryDescription;
    }

    /**
     * gst rate
     *
     * @return
     */
    public Double getGstRate() {
        return gstRate;
    }

    /**
     * gst rate
     *
     */
    public void setGstRate(Double gstRate) {
        this.gstRate = gstRate;
    }

    /**
     * gst ratio
     *
     * @return
     */
    public Double getGstRatio() {
        return gstRatio;
    }

    /**
     * gst ratio
     *
     */
    public void setGstRatio(Double gstRatio) {
        this.gstRatio = gstRatio;
    }

    /**
     * inventory name
     *
     */
    public String getInvName() {
        return invName;
    }

    /**
     * inventory name
     *
     */
    public void setInvName(String invName) {
        this.invName = invName;
    }

    /**
     * clg code
     *
     */
    public String  getClgCode() {
        return clgCode;
    }

    /**
     * clg code
     *
     */
    public void setClgCode(String clgCode) {
        this.clgCode = clgCode;
    }

    /**
     * currency code
     *
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * currency code
     *
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * automaton country id
     *
     * @return
     */
    public BigInteger getAutomatonCountryId() {
        return automatonCountryId;
    }

    /**
     * automaton country id
     *
     */
    public void setAutomatonCountryId(BigInteger automatonCountryId) {
        this.automatonCountryId = automatonCountryId;
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

package au.com.tgg.apps.foundation.model.json;

import com.fasterxml.jackson.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


/**
 * PRODUCT_CORE_RANGE
 * <p>
 * This is PRODUCT_CORE_RANGE
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "prod_core_range",
        "description",
        "last_update_date",
        "last_update_user"
})
public class ProductCoreRange extends JsonHeader {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("prod_core_range")
    private String prodCoreRange;
    @JsonProperty("prod_nbr")
    private String prod_nbr;
    @JsonProperty("description")
    private String description;
    @JsonProperty("last_update_date")
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
    public String getProdCoreRange() {
        return prodCoreRange;
    }

    public String getProd_nbr() {
        return prod_nbr;
    }

    public void setProd_nbr(String prod_nbr) {
        this.prod_nbr = prod_nbr;
    }

    /**
     *
     * (Required)
     *
     */

    public void setProdCoreRange(String prodCoreRange) {
        this.prodCoreRange = prodCoreRange;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

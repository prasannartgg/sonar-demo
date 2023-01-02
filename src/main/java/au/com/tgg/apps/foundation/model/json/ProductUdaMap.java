package au.com.tgg.apps.foundation.model.json;

import com.fasterxml.jackson.annotation.*;

import java.math.BigInteger;
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
        "prod_nbr",
        "uda_id",
        "uda_value"
})
public class ProductUdaMap extends JsonHeader {

    /**
     *
     * (Required)
     *
     */

    @JsonProperty("prod_nbr")
    private String prodNbr;
    @JsonProperty("uda_id")
    private BigInteger udaId;
    @JsonProperty("uda_value")
    private BigInteger udaValueId;

    @JsonIgnore
    private final Map<String, String> additionalProperties = new HashMap<String, String>();

    /**
     *
     * (Required)
     *
     */
    public BigInteger getUdaValueId() {
        return udaValueId;
    }

    public String getProdNbr() {
        return prodNbr;
    }

    public void setProdNbr(String prodNbr) {
        this.prodNbr = prodNbr;
    }

    /**
     *
     * (Required)
     *
     */

    public void setUdaValueId(BigInteger udaValueId) {
        this.udaValueId = udaValueId;
    }

    public BigInteger getUdaId() {
        return udaId;
    }

    public void setUdaId(BigInteger udaId) {
        this.udaId = udaId;
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

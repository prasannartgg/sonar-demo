package au.com.tgg.apps.foundation.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.math.BigInteger;

public class TggUDA {


    @JsonProperty("uda_id_xx")
    @JsonPropertyDescription("uda_id_xx")
    private BigInteger uda_id_xx;

    @JsonProperty("uda_value_xx")
    @JsonPropertyDescription("uda_value_xx")
    private BigInteger uda_value_xx;

    public TggUDA(BigInteger uda_id_xx, BigInteger uda_value_xx) {
        this.uda_id_xx = uda_id_xx;
        this.uda_value_xx = uda_value_xx;
    }

    public TggUDA() {

    }

    public BigInteger getUda_id_xx() {
        return uda_id_xx;
    }

    public void setUda_id_xx(BigInteger uda_id_xx) {
        this.uda_id_xx = uda_id_xx;
    }

    public BigInteger getUda_value_xx() {
        return uda_value_xx;
    }

    public void setUda_value_xx(BigInteger uda_value_xx) {
        this.uda_value_xx = uda_value_xx;
    }
}

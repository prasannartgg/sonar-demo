package au.com.tgg.apps.foundation.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class ProductUdaDate extends JsonHeader {
    @JsonProperty("prodNbr")
    public String prodNbr;
    @JsonProperty("udaId")
    public BigInteger udaId;
    @JsonProperty("udaDate")
    public String udaDate;

    public String getProdNbr() {
        return prodNbr;
    }

    public void setProdNbr(String prodNbr) {
        this.prodNbr = prodNbr;
    }

    public BigInteger getUdaId() {
        return udaId;
    }

    public void setUdaId(BigInteger udaId) {
        this.udaId = udaId;
    }

    public String getUdaDate() {
        return udaDate;
    }

    public void setUdaDate(String udaDate) {
        this.udaDate = udaDate;
    }


}

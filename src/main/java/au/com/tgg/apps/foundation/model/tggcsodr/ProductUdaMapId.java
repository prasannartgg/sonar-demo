package au.com.tgg.apps.foundation.model.tggcsodr;

import java.io.Serializable;
import java.math.BigInteger;

public class ProductUdaMapId implements Serializable {
    private String prodNbr;
    private BigInteger udaId;
    private BigInteger udaValue;

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

    public BigInteger getUdaValue() {
        return udaValue;
    }

    public void setUdaValue(BigInteger udaValue) {
        this.udaValue = udaValue;
    }
}

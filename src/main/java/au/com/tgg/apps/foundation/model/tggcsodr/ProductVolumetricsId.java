package au.com.tgg.apps.foundation.model.tggcsodr;

import java.io.Serializable;
import java.util.Objects;


public class ProductVolumetricsId implements Serializable {

    private String prodNbr;

    private String invName;

    public ProductVolumetricsId(String prodNbr, String invName) {
        this.prodNbr = prodNbr;
        this.invName = invName;
    }

    public ProductVolumetricsId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductVolumetricsId that = (ProductVolumetricsId) o;
        return Objects.equals(prodNbr, that.prodNbr) &&
                Objects.equals(invName, that.invName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodNbr, invName);
    }

    public String getProdNbr() {
        return prodNbr;
    }

    public void setProdNbr(String prodNbr) {
        this.prodNbr = prodNbr;
    }

    public String getInvName() {
        return invName;
    }

    public void setInvName(String invName) {
        this.invName = invName;
    }
}

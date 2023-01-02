package au.com.tgg.apps.foundation.model.tggcsodr;

import java.io.Serializable;
import java.util.Objects;

public class ProductId implements Serializable {

    private String prodNbr;

    private String invName;

    public ProductId() {
    }

    public ProductId(String prodNbr, String invName) {
        this.prodNbr = prodNbr;
        this.invName = invName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductId productId = (ProductId) o;
        return Objects.equals(prodNbr, productId.prodNbr) &&
                Objects.equals(invName, productId.invName);
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

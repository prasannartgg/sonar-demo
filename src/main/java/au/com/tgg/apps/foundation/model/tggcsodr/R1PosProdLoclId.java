package au.com.tgg.apps.foundation.model.tggcsodr;

import java.io.Serializable;
import java.util.Objects;

public class R1PosProdLoclId implements Serializable {
    private String prodNbr;
    private Long locnNbr;

    public String getProdNbr() {
        return prodNbr;
    }

    public void setProdNbr(String prodNbr) {
        this.prodNbr = prodNbr;
    }

    public Long getLocnNbr() {
        return locnNbr;
    }

    public void setLocnNbr(Long locnNbr) {
        this.locnNbr = locnNbr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        R1PosProdLoclId that = (R1PosProdLoclId) o;
        return Objects.equals(prodNbr, that.prodNbr) &&
                Objects.equals(locnNbr, that.locnNbr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodNbr, locnNbr);
    }
}

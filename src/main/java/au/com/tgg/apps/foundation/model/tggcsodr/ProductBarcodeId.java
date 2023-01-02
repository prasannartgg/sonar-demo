package au.com.tgg.apps.foundation.model.tggcsodr;

import java.io.Serializable;
import java.util.Objects;

public class ProductBarcodeId implements Serializable {

    private String barcode;

    private String prodNbr;

    public ProductBarcodeId() {
    }

    public ProductBarcodeId(String barcode, String prodNbr) {
        this.barcode = barcode;
        this.prodNbr = prodNbr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBarcodeId that = (ProductBarcodeId) o;
        return Objects.equals(barcode, that.barcode) &&
                Objects.equals(prodNbr, that.prodNbr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode, prodNbr);
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getProdNbr() {
        return prodNbr;
    }

    public void setProdNbr(String prodNbr) {
        this.prodNbr = prodNbr;
    }
}

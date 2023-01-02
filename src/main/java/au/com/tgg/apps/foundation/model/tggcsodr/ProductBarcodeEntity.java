package au.com.tgg.apps.foundation.model.tggcsodr;

import au.com.tgg.apps.foundation.util.FoundationUtil;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "product_barcode")
@SuppressWarnings("ALL")
@DynamicUpdate
@IdClass(ProductBarcodeId.class)
public class ProductBarcodeEntity {

    @Id
    @Column(name = "prod_nbr")
    private String prodNbr;

    @Id
    @Column(name = "barcode")
    private String barcode;

    @Id
    @Column(name = "product_id")
    private BigInteger productId;

    @Basic
    @Column(name = "barcode_type")
    private String barcodeType;

    @Basic
    @Column(name = "primary_ind")
    private String primaryInd;

    @Basic
    @Column(name = "deleted")
    private String deleted;

    @Basic
    @Column(name = "inv_name")
    private String invName = FoundationUtil.INV_NAME;

    @Basic
    @Column(name = "created_by")
    private String createdBy;

    @Basic
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Basic
    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Basic
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;


    public String getInvName() {
        return invName;
    }

    public void setInvName(String invName) {
        this.invName = invName;
    }

    public String getProdNbr() {
        return prodNbr;
    }

    public void setProdNbr(String prodNbr) {
        this.prodNbr = prodNbr;
    }

    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }


    public String getBarcodeType() {
        return barcodeType;
    }

    public void setBarcodeType(String barcodeType) {
        this.barcodeType = barcodeType;
    }


    public String getPrimaryInd() {
        return primaryInd;
    }

    public void setPrimaryInd(String primaryInd) {
        this.primaryInd = primaryInd;
    }


    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }


    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }


    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBarcodeEntity that = (ProductBarcodeEntity) o;
        return Objects.equals(prodNbr, that.prodNbr) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(barcode, that.barcode) &&
                Objects.equals(barcodeType, that.barcodeType) &&
                Objects.equals(primaryInd, that.primaryInd) &&
                Objects.equals(deleted, that.deleted) &&
                Objects.equals(invName, that.invName) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(lastModifiedBy, that.lastModifiedBy) &&
                Objects.equals(lastModifiedDate, that.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodNbr, productId, barcode, barcodeType, primaryInd, deleted, invName, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
    }
}

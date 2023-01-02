package au.com.tgg.apps.foundation.model.tggcsodr;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_uda_map", schema = "tggcsodr", catalog = "postgres")
@IdClass(ProductUdaMapId.class)
@DynamicUpdate
public class ProductUdaMapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger productUdaMapId;
    private String prodNbr;
    private BigInteger udaId;
    private BigInteger udaValue;
    private String deleted;
    private String createdBy;
    private LocalDateTime createdDate;
    private String modifiedBy;
    private LocalDateTime modifiedDate;

    @Basic
    @Column(name = "product_uda_map_id")
    public BigInteger getProductUdaMapId() {
        return productUdaMapId;
    }

    public void setProductUdaMapId(BigInteger productUdaMapId) {
        this.productUdaMapId = productUdaMapId;
    }

    @Basic
    @Column(name = "prod_nbr")
    public String getProdNbr() {
        return prodNbr;
    }

    public void setProdNbr(String prodNbr) {
        this.prodNbr = prodNbr;
    }

    @Basic
    @Column(name = "uda_id")
    public BigInteger getUdaId() {
        return udaId;
    }

    public void setUdaId(BigInteger udaId) {
        this.udaId = udaId;
    }

    @Basic
    @Column(name = "uda_value")
    public BigInteger getUdaValue() {
        return udaValue;
    }

    public void setUdaValue(BigInteger udaValue) {
        this.udaValue = udaValue;
    }

    @Basic
    @Column(name = "deleted")
    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @Basic
    @Column(name = "created_by")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "created_date")
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "modified_by")
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Basic
    @Column(name = "modified_date")
    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductUdaMapEntity that = (ProductUdaMapEntity) o;

        if (prodNbr != null ? !prodNbr.equals(that.prodNbr) : that.prodNbr != null) return false;
        if (udaId != null ? !udaId.equals(that.udaId) : that.udaId != null) return false;
        if (udaValue != null ? !udaValue.equals(that.udaValue) : that.udaValue != null) return false;
        if (deleted != null ? !deleted.equals(that.deleted) : that.deleted != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        return modifiedDate != null ? modifiedDate.equals(that.modifiedDate) : that.modifiedDate == null;
    }

    @Override
    public int hashCode() {
        int result = prodNbr != null ? prodNbr.hashCode() : 0;
        result = 31 * result + (udaId != null ? udaId.hashCode() : 0);
        result = 31 * result + (udaValue != null ? udaValue.hashCode() : 0);
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        return result;
    }
}

package au.com.tgg.apps.foundation.model.tggcsodr;

import au.com.tgg.apps.foundation.util.FoundationUtil;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "product_volumetrics")
@DynamicUpdate
@SuppressWarnings("ALL")
@IdClass(ProductVolumetricsId.class)
public class ProductVolumetricsEntity {

    @Id
    @Column(name = "prod_nbr")
    private String prodNbr;

    @Basic
    @Column(name = "length")
    private Double length = new Double(String.valueOf(0));

    @Basic
    @Column(name = "width")
    private Double width = new Double(String.valueOf(0));

    @Basic
    @Column(name = "height")
    private Double height = new Double(String.valueOf(0));

    @Basic
    @Column(name = "vm_weight")
    private Double vmWeight = new Double(String.valueOf(0));

    @Basic
    @Column(name = "lwh_uom")
    private String lwhUom = new String("");

    @Basic
    @Column(name = "weight")
    private Double weight = new Double(String.valueOf(0));


    @Basic
    @Column(name = "net_weight")
    private Double netWeight = new Double(String.valueOf(0));

    @Basic
    @Column(name = "weight_uom")
    private String weightUom = new String("");

    @Basic
    @Column(name = "product_id")
    private BigInteger productId;

    @Basic
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Basic
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @Id
    @Column(name = "inv_name")
    private String invName = FoundationUtil.INV_NAME;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductVolumetricsEntity that = (ProductVolumetricsEntity) o;
        return Objects.equals(prodNbr, that.prodNbr) &&
                Objects.equals(length, that.length) &&
                Objects.equals(width, that.width) &&
                Objects.equals(height, that.height) &&
                Objects.equals(vmWeight, that.vmWeight) &&
                Objects.equals(lwhUom, that.lwhUom) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(netWeight, that.netWeight) &&
                Objects.equals(weightUom, that.weightUom) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(lastModifiedDate, that.lastModifiedDate) &&
                Objects.equals(invName, that.invName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodNbr, length, width, height, vmWeight, lwhUom, weight, netWeight, weightUom, productId, createDate, lastModifiedDate, invName);
    }

    public ProductVolumetricsEntity(String prodNbr, Double length, Double width, Double height, Double vmWeight, String lwhUom, Double weight, Double netWeight, String weightUom, BigInteger productId, LocalDateTime createDate, LocalDateTime lastModifiedDate, String invName) {
        this.prodNbr = prodNbr;
        this.length = length;
        this.width = width;
        this.height = height;
        this.vmWeight = vmWeight;
        this.lwhUom = lwhUom;
        this.weight = weight;
        this.netWeight = netWeight;
        this.weightUom = weightUom;
        this.productId = productId;
        this.createDate = createDate;
        this.lastModifiedDate = lastModifiedDate;
        this.invName = invName;
    }

    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    public ProductVolumetricsEntity() {
    }

    public String getProdNbr() {
        return prodNbr;
    }

    public void setProdNbr(String prodNbr) {
        this.prodNbr = prodNbr;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getVmWeight() {
        return vmWeight;
    }

    public void setVmWeight(Double vmWeight) {
        this.vmWeight = vmWeight;
    }

    public String getLwhUom() {
        return lwhUom;
    }

    public void setLwhUom(String lwhUom) {
        this.lwhUom = lwhUom;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
    }

    public String getWeightUom() {
        return weightUom;
    }

    public void setWeightUom(String weightUom) {
        this.weightUom = weightUom;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getInvName() {
        return invName;
    }

    public void setInvName(String invName) {
        this.invName = invName;
    }

    public ProductVolumetricsEntity(String prodNbr, Double length, Double width, Double height, Double vmWeight, String lwhUom, Double weight, Double netWeight, String weightUom, LocalDateTime createDate, LocalDateTime lastModifiedDate, String invName) {
        this.prodNbr = prodNbr;
        this.length = length;
        this.width = width;
        this.height = height;
        this.vmWeight = vmWeight;
        this.lwhUom = lwhUom;
        this.weight = weight;
        this.netWeight = netWeight;
        this.weightUom = weightUom;
        this.createDate = createDate;
        this.lastModifiedDate = lastModifiedDate;
        this.invName = invName;
    }
}

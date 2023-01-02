package au.com.tgg.apps.foundation.model.tggcsodr;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "supplier_account_product")
@DynamicUpdate
@SuppressWarnings("ALL")
public class SupplierAccountProductEntity {

    @Id
    @Column(name = "supplier_account_product_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_supplier_account_prod_id")
    @SequenceGenerator(name="seq_supplier_account_prod_id", sequenceName="seq_supplier_account_prod_id",allocationSize=1)
    private BigInteger supplierAccountProductId;

    @Basic
    @Column(name = "inv_name")
    private String invName;

    @Basic
    @Column(name = "prod_nbr")
    private String prodNbr;         //RMS PK

    @Basic
    @Column(name = "sup_prod_nbr")
    private String supProdNbr;

    @Basic
    @Column(name = "sup_prod_descr")
    private String supProdDescr;

    @Basic
    @Column(name = "product_heading")
    private String productHeading;

    @Basic
    @Column(name = "prod_core_range")
    private String prodCoreRange;       //FK

    @Basic
    @Column(name = "prod_active_ind")
    private String prodActiveInd;

    @Basic
    @Column(name = "prod_purch_active_ind")
    private String prodPurchActiveInd;

    @Basic
    @Column(name = "prod_web_ready_ind")
    private String prodWebReadyInd;

    @Basic
    @Column(name = "cost_ex_price")
    private Double costExPrice;

    @Basic
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Basic
    @Column(name = "created_user")
    private String createdUser;

    @Basic
    @Column(name = "last_update_date")
    private LocalDateTime lastUpdateDate;

    @Basic
    @Column(name = "last_update_user")
    private String lastUpdateUser;

    @Basic
    @Column(name = "msku_prod_nbr")
    private String mskuProdNbr;

    @Basic
    @Column(name = "prod_pwr_sku_ind")
    private String prodPwrSkuInd;

    @Basic
    @Column(name = "product_callout")
    private String productCallout;

    @Basic
    @Column(name = "group_code")
    private String groupCode;

    @Basic
    @Column(name = "consumer_prod_nbr")
    private String consumerProdNbr;

    @Basic
    @Column(name = "short_copy")
    private String shortCopy;

    @Basic
    @Column(name = "short_prod_desc")
    private String shortProdDesc;

    @Basic
    @Column(name = "long_prod_desc")
    private String longProdDesc;

    @Basic
    @Column(name = "uom_selling")
    private String uomSelling;

    @Basic
    @Column(name = "uom_purchasing")
    private String uomPurchasing;

    @Basic
    @Column(name = "ext_wty_type")
    private String extWtyType;

    @Basic
    @Column(name = "prod_type")
    private String prodType;

    @Basic
    @Column(name = "wty_prd_mths")
    private Integer wtyPrdMths;

    @Basic
    @Column(name = "max_wty_prd_mths")
    private Integer maxWtyPrdMths;

    @Basic
    @Column(name = "gtin")
    private String gtin;


    @Basic
    @Column(name = "tgg_exclusive_ind")
    private String tggExclusiveInd;

    @Basic
    @Column(name = "service_group")
    private String serviceGroup;

    @Basic
    @Column(name = "concierge")
    private String concierge;

    @Basic
    @Column(name = "gst_rate")
    private BigInteger gstRate;

    @Basic
    @Column(name = "primary_supp_ind")
    private String primarySuppInd;

    @Basic
    @Column(name = "supp_label")
    private String suppLabel;

    @Basic
    @Column(name = "lead_time")
    private BigInteger leadTime;

    @Basic
    @Column(name = "supplier_account_id")
    private BigInteger supplierAccountId;

    @Basic
    @Column(name = "brand_code")
    private String brandCode;         //FK

    @Basic
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id",referencedColumnName="brand_id")
    private BrandEntity brandEntity;       //FK

    @Basic
    @Column(name = "group_id")
    private BigInteger groupId;         //FK

    @Basic
    @Column(name = "subclass_id")
    private BigInteger subclassId;

    @Basic
    @Column(name = "subclass")
    private BigInteger subclass;

    @Basic
    @Column(name = "embargo_date")
    private Date embargoDate;


    public BrandEntity getBrandEntity() {
        return brandEntity;
    }

    public void setBrandEntity(BrandEntity brandEntity) {
        this.brandEntity = brandEntity;
    }

    public BigInteger getSupplierAccountProductId() {
        return supplierAccountProductId;
    }

    public void setSupplierAccountProductId(BigInteger supplierAccountProductId) {
        this.supplierAccountProductId = supplierAccountProductId;
    }

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


    public String getSupProdNbr() {
        return supProdNbr;
    }

    public void setSupProdNbr(String supProdNbr) {
        this.supProdNbr = supProdNbr;
    }


    public String getSupProdDescr() {
        return supProdDescr;
    }

    public void setSupProdDescr(String supProdDescr) {
        this.supProdDescr = supProdDescr;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getProductHeading() {
        return productHeading;
    }

    public void setProductHeading(String productHeading) {
        this.productHeading = productHeading;
    }


    public String getProdCoreRange() {
        return prodCoreRange;
    }

    public void setProdCoreRange(String prodCoreRange) {
        this.prodCoreRange = prodCoreRange;
    }


    public String getProdActiveInd() {
        return prodActiveInd;
    }

    public void setProdActiveInd(String prodActiveInd) {
        this.prodActiveInd = prodActiveInd;
    }


    public String getProdPurchActiveInd() {
        return prodPurchActiveInd;
    }

    public void setProdPurchActiveInd(String prodPurchActiveInd) {
        this.prodPurchActiveInd = prodPurchActiveInd;
    }


    public String getProdWebReadyInd() {
        return prodWebReadyInd;
    }

    public void setProdWebReadyInd(String prodWebReadyInd) {
        this.prodWebReadyInd = prodWebReadyInd;
    }


    public Double getCostExPrice() {
        return costExPrice;
    }

    public void setCostExPrice(Double costExPrice) {
        this.costExPrice = costExPrice;
    }


    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }


    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }


    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }


    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }


    public String getMskuProdNbr() {
        return mskuProdNbr;
    }

    public void setMskuProdNbr(String mskuProdNbr) {
        this.mskuProdNbr = mskuProdNbr;
    }


    public String getProductCallout() {
        return productCallout;
    }

    public void setProductCallout(String productCallout) {
        this.productCallout = productCallout;
    }


    public String getConsumerProdNbr() {
        return consumerProdNbr;
    }

    public void setConsumerProdNbr(String consumerProdNbr) {
        this.consumerProdNbr = consumerProdNbr;
    }


    public String getShortCopy() {
        return shortCopy;
    }

    public void setShortCopy(String shortCopy) {
        this.shortCopy = shortCopy;
    }


    public String getShortProdDesc() {
        return shortProdDesc;
    }

    public void setShortProdDesc(String shortProdDesc) {
        this.shortProdDesc = shortProdDesc;
    }


    public String getLongProdDesc() {
        return longProdDesc;
    }

    public void setLongProdDesc(String longProdDesc) {
        this.longProdDesc = longProdDesc;
    }


    public String getUomSelling() {
        return uomSelling;
    }

    public void setUomSelling(String uomSelling) {
        this.uomSelling = uomSelling;
    }


    public String getUomPurchasing() {
        return uomPurchasing;
    }

    public void setUomPurchasing(String uomPurchasing) {
        this.uomPurchasing = uomPurchasing;
    }


    public String getExtWtyType() {
        return extWtyType;
    }

    public void setExtWtyType(String extWtyType) {
        this.extWtyType = extWtyType;
    }


    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }


    public Integer getWtyPrdMths() {
        return wtyPrdMths;
    }

    public void setWtyPrdMths(Integer wtyPrdMths) {
        this.wtyPrdMths = wtyPrdMths;
    }


    public Integer getMaxWtyPrdMths() {
        return maxWtyPrdMths;
    }

    public void setMaxWtyPrdMths(Integer maxWtyPrdMths) {
        this.maxWtyPrdMths = maxWtyPrdMths;
    }


    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }


    public String getProdPwrSkuInd() {
        return prodPwrSkuInd;
    }

    public void setProdPwrSkuInd(String prodPwrSkuInd) {
        this.prodPwrSkuInd = prodPwrSkuInd;
    }


    public String getTggExclusiveInd() {
        return tggExclusiveInd;
    }

    public void setTggExclusiveInd(String tggExclusiveInd) {
        this.tggExclusiveInd = tggExclusiveInd;
    }


    public String getServiceGroup() {
        return serviceGroup;
    }

    public void setServiceGroup(String serviceGroup) {
        this.serviceGroup = serviceGroup;
    }


    public String getConcierge() {
        return concierge;
    }

    public void setConcierge(String concierge) {
        this.concierge = concierge;
    }


    public BigInteger getGstRate() {
        return gstRate;
    }

    public void setGstRate(BigInteger gstRate) {
        this.gstRate = gstRate;
    }


    public String getPrimarySuppInd() {
        return primarySuppInd;
    }

    public void setPrimarySuppInd(String primarySuppInd) {
        this.primarySuppInd = primarySuppInd;
    }


    public String getSuppLabel() {
        return suppLabel;
    }

    public void setSuppLabel(String suppLabel) {
        this.suppLabel = suppLabel;
    }


    public BigInteger getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(BigInteger leadTime) {
        this.leadTime = leadTime;
    }

    public BigInteger getGroupId() {
        return groupId;
    }

    public void setGroupId(BigInteger groupId) {
        this.groupId = groupId;
    }


    public BigInteger getSubclassId() {
        return subclassId;
    }

    public void setSubclassId(BigInteger subclassId) {
        this.subclassId = subclassId;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brand_code) {
        this.brandCode = brand_code;
    }

    public BigInteger getSubclass() {
        return subclass;
    }

    public void setSubclass(BigInteger subclass) {
        this.subclass = subclass;
    }

    public BigInteger getSupplierAccountId() {
        return supplierAccountId;
    }

    public void setSupplierAccountId(BigInteger supplier_account_id) {
        this.supplierAccountId = supplier_account_id;
    }

    public Date getEmbargoDate() {
        return embargoDate;
    }

    public void setEmbargoDate(Date embargoDate) {
        this.embargoDate = embargoDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierAccountProductEntity that = (SupplierAccountProductEntity) o;
        return Objects.equals(supplierAccountProductId, that.supplierAccountProductId) &&
                Objects.equals(invName, that.invName) &&
                Objects.equals(prodNbr, that.prodNbr) &&
                Objects.equals(supProdNbr, that.supProdNbr) &&
                Objects.equals(supProdDescr, that.supProdDescr) &&
                Objects.equals(productHeading, that.productHeading) &&
                Objects.equals(prodCoreRange, that.prodCoreRange) &&
                Objects.equals(prodActiveInd, that.prodActiveInd) &&
                Objects.equals(prodPurchActiveInd, that.prodPurchActiveInd) &&
                Objects.equals(prodWebReadyInd, that.prodWebReadyInd) &&
                Objects.equals(costExPrice, that.costExPrice) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(createdUser, that.createdUser) &&
                Objects.equals(lastUpdateDate, that.lastUpdateDate) &&
                Objects.equals(lastUpdateUser, that.lastUpdateUser) &&
                Objects.equals(mskuProdNbr, that.mskuProdNbr) &&
                Objects.equals(prodPwrSkuInd, that.prodPwrSkuInd) &&
                Objects.equals(productCallout, that.productCallout) &&
                Objects.equals(groupCode, that.groupCode) &&
                Objects.equals(consumerProdNbr, that.consumerProdNbr) &&
                Objects.equals(shortCopy, that.shortCopy) &&
                Objects.equals(shortProdDesc, that.shortProdDesc) &&
                Objects.equals(longProdDesc, that.longProdDesc) &&
                Objects.equals(uomSelling, that.uomSelling) &&
                Objects.equals(uomPurchasing, that.uomPurchasing) &&
                Objects.equals(extWtyType, that.extWtyType) &&
                Objects.equals(prodType, that.prodType) &&
                Objects.equals(wtyPrdMths, that.wtyPrdMths) &&
                Objects.equals(maxWtyPrdMths, that.maxWtyPrdMths) &&
                Objects.equals(gtin, that.gtin) &&
                Objects.equals(tggExclusiveInd, that.tggExclusiveInd) &&
                Objects.equals(serviceGroup, that.serviceGroup) &&
                Objects.equals(concierge, that.concierge) &&
                Objects.equals(gstRate, that.gstRate) &&
                Objects.equals(primarySuppInd, that.primarySuppInd) &&
                Objects.equals(suppLabel, that.suppLabel) &&
                Objects.equals(leadTime, that.leadTime) &&
                Objects.equals(supplierAccountId, that.supplierAccountId) &&
                Objects.equals(brandCode, that.brandCode) &&
                Objects.equals(brandEntity, that.brandEntity) &&
                Objects.equals(groupId, that.groupId) &&
                Objects.equals(subclassId, that.subclassId) &&
                Objects.equals(subclass, that.subclass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierAccountProductId, invName, prodNbr, supProdNbr, supProdDescr, productHeading, prodCoreRange, prodActiveInd, prodPurchActiveInd, prodWebReadyInd, costExPrice, createdDate, createdUser, lastUpdateDate, lastUpdateUser, mskuProdNbr, prodPwrSkuInd, productCallout, groupCode, consumerProdNbr, shortCopy, shortProdDesc, longProdDesc, uomSelling, uomPurchasing, extWtyType, prodType, wtyPrdMths, maxWtyPrdMths, gtin, tggExclusiveInd, serviceGroup, concierge, gstRate, primarySuppInd, suppLabel, leadTime, supplierAccountId, brandCode, brandEntity, groupId, subclassId, subclass);
    }
}

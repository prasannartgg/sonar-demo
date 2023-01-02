package au.com.tgg.apps.foundation.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "SUPPLIER_ACCOUNT_PRODUCT", schema = "TGGCSODR", catalog = "")
public class SupplierAccountProduct {
    private Long supplierAccountProductId;
    private String invName;
    private String prodNbr;
    private Long supplierAccountId;
    private String supProdNbr;
    private Long brandId;
    private Long groupId;
    private String supProdDescr;
    private String productHeading;
    private String prodCoreRange;
    private String prodActiveInd;
    private String prodPurchActiveInd;
    private String prodWebReadyInd;
    private Long costExPrice;
    private Time createdDate;
    private String createdUser;
    private Time lastUpdateDate;
    private String lastUpdateUser;
    private String mskuProdNbr;
    private String productCallout;
    private String consumerProdNbr;
    private String shortCopy;
    private String shortProdDesc;
    private String longProdDesc;
    private String uomSelling;
    private String uomPurchasing;
    private String extWtyType;
    private String prodType;
    private Long wtyPrdMths;
    private Long maxWtyPrdMths;
    private String gtin;
    private String prodPwrSkuInd;
    private String tggExclusiveInd;
    private String serviceGroup;
    private String concierge;
    private Long gstRate;
    private Long subclassId;
    private String primarySuppInd;
    private String suppLabel;
    private Long leadTime;

    @Id
    @Column(name = "SUPPLIER_ACCOUNT_PRODUCT_ID")
    public Long getSupplierAccountProductId() {
        return supplierAccountProductId;
    }

    public void setSupplierAccountProductId(Long supplierAccountProductId) {
        this.supplierAccountProductId = supplierAccountProductId;
    }

    @Basic
    @Column(name = "INV_NAME")
    public String getInvName() {
        return invName;
    }

    public void setInvName(String invName) {
        this.invName = invName;
    }

    @Basic
    @Column(name = "PROD_NBR")
    public String getProdNbr() {
        return prodNbr;
    }

    public void setProdNbr(String prodNbr) {
        this.prodNbr = prodNbr;
    }

    @Basic
    @Column(name = "SUPPLIER_ACCOUNT_ID")
    public Long getSupplierAccountId() {
        return supplierAccountId;
    }

    public void setSupplierAccountId(Long supplierAccountId) {
        this.supplierAccountId = supplierAccountId;
    }

    @Basic
    @Column(name = "SUP_PROD_NBR")
    public String getSupProdNbr() {
        return supProdNbr;
    }

    public void setSupProdNbr(String supProdNbr) {
        this.supProdNbr = supProdNbr;
    }

    @Basic
    @Column(name = "BRAND_ID")
    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    @Basic
    @Column(name = "GROUP_ID")
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "SUP_PROD_DESCR")
    public String getSupProdDescr() {
        return supProdDescr;
    }

    public void setSupProdDescr(String supProdDescr) {
        this.supProdDescr = supProdDescr;
    }

    @Basic
    @Column(name = "PRODUCT_HEADING")
    public String getProductHeading() {
        return productHeading;
    }

    public void setProductHeading(String productHeading) {
        this.productHeading = productHeading;
    }

    @Basic
    @Column(name = "PROD_CORE_RANGE")
    public String getProdCoreRange() {
        return prodCoreRange;
    }

    public void setProdCoreRange(String prodCoreRange) {
        this.prodCoreRange = prodCoreRange;
    }

    @Basic
    @Column(name = "PROD_ACTIVE_IND")
    public String getProdActiveInd() {
        return prodActiveInd;
    }

    public void setProdActiveInd(String prodActiveInd) {
        this.prodActiveInd = prodActiveInd;
    }

    @Basic
    @Column(name = "PROD_PURCH_ACTIVE_IND")
    public String getProdPurchActiveInd() {
        return prodPurchActiveInd;
    }

    public void setProdPurchActiveInd(String prodPurchActiveInd) {
        this.prodPurchActiveInd = prodPurchActiveInd;
    }

    @Basic
    @Column(name = "PROD_WEB_READY_IND")
    public String getProdWebReadyInd() {
        return prodWebReadyInd;
    }

    public void setProdWebReadyInd(String prodWebReadyInd) {
        this.prodWebReadyInd = prodWebReadyInd;
    }

    @Basic
    @Column(name = "COST_EX_PRICE")
    public Long getCostExPrice() {
        return costExPrice;
    }

    public void setCostExPrice(Long costExPrice) {
        this.costExPrice = costExPrice;
    }

    @Basic
    @Column(name = "CREATED_DATE")
    public Time getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Time createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "CREATED_USER")
    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    @Basic
    @Column(name = "LAST_UPDATE_DATE")
    public Time getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Time lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Basic
    @Column(name = "LAST_UPDATE_USER")
    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    @Basic
    @Column(name = "MSKU_PROD_NBR")
    public String getMskuProdNbr() {
        return mskuProdNbr;
    }

    public void setMskuProdNbr(String mskuProdNbr) {
        this.mskuProdNbr = mskuProdNbr;
    }

    @Basic
    @Column(name = "PRODUCT_CALLOUT")
    public String getProductCallout() {
        return productCallout;
    }

    public void setProductCallout(String productCallout) {
        this.productCallout = productCallout;
    }

    @Basic
    @Column(name = "CONSUMER_PROD_NBR")
    public String getConsumerProdNbr() {
        return consumerProdNbr;
    }

    public void setConsumerProdNbr(String consumerProdNbr) {
        this.consumerProdNbr = consumerProdNbr;
    }

    @Basic
    @Column(name = "SHORT_COPY")
    public String getShortCopy() {
        return shortCopy;
    }

    public void setShortCopy(String shortCopy) {
        this.shortCopy = shortCopy;
    }

    @Basic
    @Column(name = "SHORT_PROD_DESC")
    public String getShortProdDesc() {
        return shortProdDesc;
    }

    public void setShortProdDesc(String shortProdDesc) {
        this.shortProdDesc = shortProdDesc;
    }

    @Basic
    @Column(name = "LONG_PROD_DESC")
    public String getLongProdDesc() {
        return longProdDesc;
    }

    public void setLongProdDesc(String longProdDesc) {
        this.longProdDesc = longProdDesc;
    }

    @Basic
    @Column(name = "UOM_SELLING")
    public String getUomSelling() {
        return uomSelling;
    }

    public void setUomSelling(String uomSelling) {
        this.uomSelling = uomSelling;
    }

    @Basic
    @Column(name = "UOM_PURCHASING")
    public String getUomPurchasing() {
        return uomPurchasing;
    }

    public void setUomPurchasing(String uomPurchasing) {
        this.uomPurchasing = uomPurchasing;
    }

    @Basic
    @Column(name = "EXT_WTY_TYPE")
    public String getExtWtyType() {
        return extWtyType;
    }

    public void setExtWtyType(String extWtyType) {
        this.extWtyType = extWtyType;
    }

    @Basic
    @Column(name = "PROD_TYPE")
    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    @Basic
    @Column(name = "WTY_PRD_MTHS")
    public Long getWtyPrdMths() {
        return wtyPrdMths;
    }

    public void setWtyPrdMths(Long wtyPrdMths) {
        this.wtyPrdMths = wtyPrdMths;
    }

    @Basic
    @Column(name = "MAX_WTY_PRD_MTHS")
    public Long getMaxWtyPrdMths() {
        return maxWtyPrdMths;
    }

    public void setMaxWtyPrdMths(Long maxWtyPrdMths) {
        this.maxWtyPrdMths = maxWtyPrdMths;
    }

    @Basic
    @Column(name = "GTIN")
    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    @Basic
    @Column(name = "PROD_PWR_SKU_IND")
    public String getProdPwrSkuInd() {
        return prodPwrSkuInd;
    }

    public void setProdPwrSkuInd(String prodPwrSkuInd) {
        this.prodPwrSkuInd = prodPwrSkuInd;
    }

    @Basic
    @Column(name = "TGG_EXCLUSIVE_IND")
    public String getTggExclusiveInd() {
        return tggExclusiveInd;
    }

    public void setTggExclusiveInd(String tggExclusiveInd) {
        this.tggExclusiveInd = tggExclusiveInd;
    }

    @Basic
    @Column(name = "SERVICE_GROUP")
    public String getServiceGroup() {
        return serviceGroup;
    }

    public void setServiceGroup(String serviceGroup) {
        this.serviceGroup = serviceGroup;
    }

    @Basic
    @Column(name = "CONCIERGE")
    public String getConcierge() {
        return concierge;
    }

    public void setConcierge(String concierge) {
        this.concierge = concierge;
    }

    @Basic
    @Column(name = "GST_RATE")
    public Long getGstRate() {
        return gstRate;
    }

    public void setGstRate(Long gstRate) {
        this.gstRate = gstRate;
    }

    @Basic
    @Column(name = "SUBCLASS_ID")
    public Long getSubclassId() {
        return subclassId;
    }

    public void setSubclassId(Long subclassId) {
        this.subclassId = subclassId;
    }

    @Basic
    @Column(name = "PRIMARY_SUPP_IND")
    public String getPrimarySuppInd() {
        return primarySuppInd;
    }

    public void setPrimarySuppInd(String primarySuppInd) {
        this.primarySuppInd = primarySuppInd;
    }

    @Basic
    @Column(name = "SUPP_LABEL")
    public String getSuppLabel() {
        return suppLabel;
    }

    public void setSuppLabel(String suppLabel) {
        this.suppLabel = suppLabel;
    }

    @Basic
    @Column(name = "LEAD_TIME")
    public Long getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(Long leadTime) {
        this.leadTime = leadTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierAccountProduct that = (SupplierAccountProduct) o;
        return Objects.equals(supplierAccountProductId, that.supplierAccountProductId) &&
                Objects.equals(invName, that.invName) &&
                Objects.equals(prodNbr, that.prodNbr) &&
                Objects.equals(supplierAccountId, that.supplierAccountId) &&
                Objects.equals(supProdNbr, that.supProdNbr) &&
                Objects.equals(brandId, that.brandId) &&
                Objects.equals(groupId, that.groupId) &&
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
                Objects.equals(productCallout, that.productCallout) &&
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
                Objects.equals(prodPwrSkuInd, that.prodPwrSkuInd) &&
                Objects.equals(tggExclusiveInd, that.tggExclusiveInd) &&
                Objects.equals(serviceGroup, that.serviceGroup) &&
                Objects.equals(concierge, that.concierge) &&
                Objects.equals(gstRate, that.gstRate) &&
                Objects.equals(subclassId, that.subclassId) &&
                Objects.equals(primarySuppInd, that.primarySuppInd) &&
                Objects.equals(suppLabel, that.suppLabel) &&
                Objects.equals(leadTime, that.leadTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierAccountProductId, invName, prodNbr, supplierAccountId, supProdNbr, brandId, groupId, supProdDescr, productHeading, prodCoreRange, prodActiveInd, prodPurchActiveInd, prodWebReadyInd, costExPrice, createdDate, createdUser, lastUpdateDate, lastUpdateUser, mskuProdNbr, productCallout, consumerProdNbr, shortCopy, shortProdDesc, longProdDesc, uomSelling, uomPurchasing, extWtyType, prodType, wtyPrdMths, maxWtyPrdMths, gtin, prodPwrSkuInd, tggExclusiveInd, serviceGroup, concierge, gstRate, subclassId, primarySuppInd, suppLabel, leadTime);
    }
}

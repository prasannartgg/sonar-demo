package au.com.tgg.apps.foundation.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "CASE_ITEM", schema = "TGG_RLO_APP", catalog = "")
public class CaseItem {
    private Long caseItemId;
    private Long supplierAccountProductId;
    private Long locationId;
    private Long typeId;
    private Long solvupCaseNbr;
    private Long caseReasonCodeId;
    private String mfrSerialNo;
    private Long caseStatusCodeId;
    private String comments;
    private String dktNbr;
    private Long dktLneNbr;
    private String preProcessed;
    private String createdBy;
    private Time createdDate;
    private String modifiedBy;
    private Time modifiedDate;

    @Id
    @Column(name = "CASE_ITEM_ID")
    public Long getCaseItemId() {
        return caseItemId;
    }

    public void setCaseItemId(Long caseItemId) {
        this.caseItemId = caseItemId;
    }

    @Basic
    @Column(name = "SUPPLIER_ACCOUNT_PRODUCT_ID")
    public Long getSupplierAccountProductId() {
        return supplierAccountProductId;
    }

    public void setSupplierAccountProductId(Long supplierAccountProductId) {
        this.supplierAccountProductId = supplierAccountProductId;
    }

    @Basic
    @Column(name = "LOCATION_ID")
    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Basic
    @Column(name = "TYPE_ID")
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "SOLVUP_CASE_NBR")
    public Long getSolvupCaseNbr() {
        return solvupCaseNbr;
    }

    public void setSolvupCaseNbr(Long solvupCaseNbr) {
        this.solvupCaseNbr = solvupCaseNbr;
    }

    @Basic
    @Column(name = "CASE_REASON_CODE_ID")
    public Long getCaseReasonCodeId() {
        return caseReasonCodeId;
    }

    public void setCaseReasonCodeId(Long caseReasonCodeId) {
        this.caseReasonCodeId = caseReasonCodeId;
    }

    @Basic
    @Column(name = "MFR_SERIAL_NO")
    public String getMfrSerialNo() {
        return mfrSerialNo;
    }

    public void setMfrSerialNo(String mfrSerialNo) {
        this.mfrSerialNo = mfrSerialNo;
    }

    @Basic
    @Column(name = "CASE_STATUS_CODE_ID")
    public Long getCaseStatusCodeId() {
        return caseStatusCodeId;
    }

    public void setCaseStatusCodeId(Long caseStatusCodeId) {
        this.caseStatusCodeId = caseStatusCodeId;
    }

    @Basic
    @Column(name = "COMMENTS")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "DKT_NBR")
    public String getDktNbr() {
        return dktNbr;
    }

    public void setDktNbr(String dktNbr) {
        this.dktNbr = dktNbr;
    }

    @Basic
    @Column(name = "DKT_LNE_NBR")
    public Long getDktLneNbr() {
        return dktLneNbr;
    }

    public void setDktLneNbr(Long dktLneNbr) {
        this.dktLneNbr = dktLneNbr;
    }

    @Basic
    @Column(name = "PRE_PROCESSED")
    public String getPreProcessed() {
        return preProcessed;
    }

    public void setPreProcessed(String preProcessed) {
        this.preProcessed = preProcessed;
    }

    @Basic
    @Column(name = "CREATED_BY")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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
    @Column(name = "MODIFIED_BY")
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Basic
    @Column(name = "MODIFIED_DATE")
    public Time getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Time modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaseItem caseItem = (CaseItem) o;
        return Objects.equals(caseItemId, caseItem.caseItemId) &&
                Objects.equals(supplierAccountProductId, caseItem.supplierAccountProductId) &&
                Objects.equals(locationId, caseItem.locationId) &&
                Objects.equals(typeId, caseItem.typeId) &&
                Objects.equals(solvupCaseNbr, caseItem.solvupCaseNbr) &&
                Objects.equals(caseReasonCodeId, caseItem.caseReasonCodeId) &&
                Objects.equals(mfrSerialNo, caseItem.mfrSerialNo) &&
                Objects.equals(caseStatusCodeId, caseItem.caseStatusCodeId) &&
                Objects.equals(comments, caseItem.comments) &&
                Objects.equals(dktNbr, caseItem.dktNbr) &&
                Objects.equals(dktLneNbr, caseItem.dktLneNbr) &&
                Objects.equals(preProcessed, caseItem.preProcessed) &&
                Objects.equals(createdBy, caseItem.createdBy) &&
                Objects.equals(createdDate, caseItem.createdDate) &&
                Objects.equals(modifiedBy, caseItem.modifiedBy) &&
                Objects.equals(modifiedDate, caseItem.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseItemId, supplierAccountProductId, locationId, typeId, solvupCaseNbr, caseReasonCodeId, mfrSerialNo, caseStatusCodeId, comments, dktNbr, dktLneNbr, preProcessed, createdBy, createdDate, modifiedBy, modifiedDate);
    }
}

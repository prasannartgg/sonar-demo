package au.com.tgg.apps.foundation.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "CODE_DETAIL", schema = "TGG_RLO_APP", catalog = "")
public class CodeDetail {
    private Long codeId;
    private Long codeHeadId;
    private String code;
    private String codeDesc;
    private String codeLabel;
    private String active;
    private String createdBy;
    private Time createdDate;
    private String modifiedBy;
    private Time modifiedDate;

    @Id
    @Column(name = "CODE_ID")
    public Long getCodeId() {
        return codeId;
    }

    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    @Basic
    @Column(name = "CODE_HEAD_ID")
    public Long getCodeHeadId() {
        return codeHeadId;
    }

    public void setCodeHeadId(Long codeHeadId) {
        this.codeHeadId = codeHeadId;
    }

    @Basic
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "CODE_DESC")
    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }

    @Basic
    @Column(name = "CODE_LABEL")
    public String getCodeLabel() {
        return codeLabel;
    }

    public void setCodeLabel(String codeLabel) {
        this.codeLabel = codeLabel;
    }

    @Basic
    @Column(name = "ACTIVE")
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
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
        CodeDetail that = (CodeDetail) o;
        return Objects.equals(codeId, that.codeId) &&
                Objects.equals(codeHeadId, that.codeHeadId) &&
                Objects.equals(code, that.code) &&
                Objects.equals(codeDesc, that.codeDesc) &&
                Objects.equals(codeLabel, that.codeLabel) &&
                Objects.equals(active, that.active) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(modifiedBy, that.modifiedBy) &&
                Objects.equals(modifiedDate, that.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeId, codeHeadId, code, codeDesc, codeLabel, active, createdBy, createdDate, modifiedBy, modifiedDate);
    }
}

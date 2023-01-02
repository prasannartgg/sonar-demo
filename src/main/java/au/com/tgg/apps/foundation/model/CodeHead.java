package au.com.tgg.apps.foundation.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "CODE_HEAD", schema = "TGG_RLO_APP", catalog = "")
public class CodeHead {
    private Long codeHeadId;
    private String codeHead;
    private String codeHeadDesc;
    private String codeHeadLabel;
    private String active;
    private String createdBy;
    private Time createdDate;
    private String modifiedBy;
    private Time modifiedDate;

    @Id
    @Column(name = "CODE_HEAD_ID")
    public Long getCodeHeadId() {
        return codeHeadId;
    }

    public void setCodeHeadId(Long codeHeadId) {
        this.codeHeadId = codeHeadId;
    }

    @Basic
    @Column(name = "CODE_HEAD")
    public String getCodeHead() {
        return codeHead;
    }

    public void setCodeHead(String codeHead) {
        this.codeHead = codeHead;
    }

    @Basic
    @Column(name = "CODE_HEAD_DESC")
    public String getCodeHeadDesc() {
        return codeHeadDesc;
    }

    public void setCodeHeadDesc(String codeHeadDesc) {
        this.codeHeadDesc = codeHeadDesc;
    }

    @Basic
    @Column(name = "CODE_HEAD_LABEL")
    public String getCodeHeadLabel() {
        return codeHeadLabel;
    }

    public void setCodeHeadLabel(String codeHeadLabel) {
        this.codeHeadLabel = codeHeadLabel;
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
        CodeHead codeHead1 = (CodeHead) o;
        return Objects.equals(codeHeadId, codeHead1.codeHeadId) &&
                Objects.equals(codeHead, codeHead1.codeHead) &&
                Objects.equals(codeHeadDesc, codeHead1.codeHeadDesc) &&
                Objects.equals(codeHeadLabel, codeHead1.codeHeadLabel) &&
                Objects.equals(active, codeHead1.active) &&
                Objects.equals(createdBy, codeHead1.createdBy) &&
                Objects.equals(createdDate, codeHead1.createdDate) &&
                Objects.equals(modifiedBy, codeHead1.modifiedBy) &&
                Objects.equals(modifiedDate, codeHead1.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeHeadId, codeHead, codeHeadDesc, codeHeadLabel, active, createdBy, createdDate, modifiedBy, modifiedDate);
    }
}

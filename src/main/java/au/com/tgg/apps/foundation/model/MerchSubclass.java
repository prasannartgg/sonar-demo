package au.com.tgg.apps.foundation.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "MERCH_SUBCLASS", schema = "TGGCSODR", catalog = "")
public class MerchSubclass {
    private Long subclassId;
    private Long classId;
    private Long subclass;
    private String subclassName;
    private String deleted;
    private String createdBy;
    private Time createdDate;
    private String lastModifiedBy;
    private Time lastModifiedDate;

    @Id
    @Column(name = "SUBCLASS_ID")
    public Long getSubclassId() {
        return subclassId;
    }

    public void setSubclassId(Long subclassId) {
        this.subclassId = subclassId;
    }

    @Basic
    @Column(name = "CLASS_ID")
    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "SUBCLASS")
    public Long getSubclass() {
        return subclass;
    }

    public void setSubclass(Long subclass) {
        this.subclass = subclass;
    }

    @Basic
    @Column(name = "SUBCLASS_NAME")
    public String getSubclassName() {
        return subclassName;
    }

    public void setSubclassName(String subclassName) {
        this.subclassName = subclassName;
    }

    @Basic
    @Column(name = "DELETED")
    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
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
    @Column(name = "LAST_MODIFIED_BY")
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Basic
    @Column(name = "LAST_MODIFIED_DATE")
    public Time getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Time lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MerchSubclass that = (MerchSubclass) o;
        return Objects.equals(subclassId, that.subclassId) &&
                Objects.equals(classId, that.classId) &&
                Objects.equals(subclass, that.subclass) &&
                Objects.equals(subclassName, that.subclassName) &&
                Objects.equals(deleted, that.deleted) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(lastModifiedBy, that.lastModifiedBy) &&
                Objects.equals(lastModifiedDate, that.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subclassId, classId, subclass, subclassName, deleted, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
    }
}

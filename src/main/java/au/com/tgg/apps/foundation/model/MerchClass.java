package au.com.tgg.apps.foundation.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "MERCH_CLASS", schema = "TGGCSODR", catalog = "")
public class MerchClass {
    private Long classId;
    private Long depId;
    private Long clazz;
    private String className;
    private String deleted;
    private String createdBy;
    private Time createdDate;
    private String lastModifiedBy;
    private Time lastModifiedDate;

    @Id
    @Column(name = "CLASS_ID")
    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "DEP_ID")
    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    @Basic
    @Column(name = "CLASS")
    public Long getClazz() {
        return clazz;
    }

    public void setClazz(Long clazz) {
        this.clazz = clazz;
    }

    @Basic
    @Column(name = "CLASS_NAME")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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
        MerchClass that = (MerchClass) o;
        return Objects.equals(classId, that.classId) &&
                Objects.equals(depId, that.depId) &&
                Objects.equals(clazz, that.clazz) &&
                Objects.equals(className, that.className) &&
                Objects.equals(deleted, that.deleted) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(lastModifiedBy, that.lastModifiedBy) &&
                Objects.equals(lastModifiedDate, that.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, depId, clazz, className, deleted, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
    }
}

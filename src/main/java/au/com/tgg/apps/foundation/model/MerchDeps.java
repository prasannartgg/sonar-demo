package au.com.tgg.apps.foundation.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "MERCH_DEPS", schema = "TGGCSODR", catalog = "")
public class MerchDeps {
    private Long depId;
    private Long dept;
    private String deptName;
    private String deleted;
    private String createdBy;
    private Time createdDate;
    private String lastModifiedBy;
    private Time lastModifiedDate;

    @Id
    @Column(name = "DEP_ID")
    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    @Basic
    @Column(name = "DEPT")
    public Long getDept() {
        return dept;
    }

    public void setDept(Long dept) {
        this.dept = dept;
    }

    @Basic
    @Column(name = "DEPT_NAME")
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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
        MerchDeps merchDeps = (MerchDeps) o;
        return Objects.equals(depId, merchDeps.depId) &&
                Objects.equals(dept, merchDeps.dept) &&
                Objects.equals(deptName, merchDeps.deptName) &&
                Objects.equals(deleted, merchDeps.deleted) &&
                Objects.equals(createdBy, merchDeps.createdBy) &&
                Objects.equals(createdDate, merchDeps.createdDate) &&
                Objects.equals(lastModifiedBy, merchDeps.lastModifiedBy) &&
                Objects.equals(lastModifiedDate, merchDeps.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depId, dept, deptName, deleted, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
    }
}

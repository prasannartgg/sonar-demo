package au.com.tgg.apps.foundation.model.tggcsodr;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "merch_deps", schema = "tggcsodr", catalog = "postgres")
@DynamicUpdate
@SuppressWarnings("ALL")
public class MerchDepsEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_merch_deps")
    @SequenceGenerator(name="seq_merch_deps", sequenceName="seq_merch_deps",allocationSize=1)
    @Column(name = "dep_id")
    private BigInteger depId;
    @Basic
    @Column(name = "dept")
    private BigInteger dept;         //RMS PK
    @Basic
    @Column(name = "dept_name")
    private String deptName;
    @Basic
    @Column(name = "deleted")
    private String deleted;
    @Basic
    @Column(name = "created_by")
    private String createdBy;
    @Basic
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Basic
    @Column(name = "last_modified_by")
    private String lastModifiedBy;
    @Basic
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;
    @OneToMany(mappedBy = "merchDepsEntity")
    private List<MerchClassEntity> merchClassEntityList;


    public BigInteger getDepId() {
        return depId;
    }

    public void setDepId(BigInteger depId) {
        this.depId = depId;
    }


    public BigInteger getDept() {
        return dept;
    }

    public void setDept(BigInteger dept) {
        this.dept = dept;
    }


    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }


    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }


    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }


    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MerchDepsEntity that = (MerchDepsEntity) o;
        return dept == that.dept &&
                Objects.equals(depId, that.depId) &&
                Objects.equals(deptName, that.deptName) &&
                Objects.equals(deleted, that.deleted) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(lastModifiedBy, that.lastModifiedBy) &&
                Objects.equals(lastModifiedDate, that.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depId, dept, deptName, deleted, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
    }

    public List<MerchClassEntity> getMerchClassEntityList() {
        return merchClassEntityList;
    }

    public void setMerchClassEntityList(List<MerchClassEntity> merchClassEntityList) {
        this.merchClassEntityList = merchClassEntityList;
    }
}

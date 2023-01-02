package au.com.tgg.apps.foundation.model.tggcsodr;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "merch_class", schema = "tggcsodr", catalog = "postgres")
@DynamicUpdate
@SuppressWarnings("ALL")
public class MerchClassEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_merch_class")
    @SequenceGenerator(name="seq_merch_class", sequenceName="seq_merch_class", allocationSize=1)
    @Column(name = "class_id")
    private BigInteger classId;

    @Basic
    @Column(name = "class")
    private BigInteger clazz;        //RMS PK
    @Basic
    @Column(name = "class_name")
    private String className;
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
    @Basic
    @ManyToOne()
    @JoinColumn(name = "dep_id")
    private MerchDepsEntity merchDepsEntity;           //FK
    @Basic
    @Column(name = "dept")
    private BigInteger dept;

    @OneToMany(mappedBy = "merchClassEntity")
    private List<MerchSubclassEntity> merchSubclassEntities;

//    @Basic
//    @Column(name = "dep_id")
//    private BigInteger depId;           //FK

    public BigInteger getClassId() {
        return classId;
    }

    public void setClassId(BigInteger classId) {
        this.classId = classId;
    }


    public BigInteger getclazz() {
        return clazz;
    }

    public void setclazz(BigInteger clazz) {
        this.clazz = clazz;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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


//    public BigInteger getDepId() {
//        return depId;
//    }
//
//    public void setDepId(BigInteger depId) {
//        this.depId = depId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MerchClassEntity that = (MerchClassEntity) o;
        return clazz == that.clazz &&
                Objects.equals(classId, that.classId) &&
                Objects.equals(className, that.className) &&
                Objects.equals(deleted, that.deleted) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(lastModifiedBy, that.lastModifiedBy) &&
                Objects.equals(lastModifiedDate, that.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, clazz, className, deleted, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
    }

    public MerchDepsEntity getMerchDeps() {
        return merchDepsEntity;
    }

    public void setMerchDeps(MerchDepsEntity merchDepsEntity) {
        this.merchDepsEntity = merchDepsEntity;
    }


    public BigInteger getDept() {
        return dept;
    }

    public void setDept(BigInteger dept) {
        this.dept = dept;
    }

    public List<MerchSubclassEntity> getMerchSubclassEntities() {
        return merchSubclassEntities;
    }

    public void setMerchSubclassEntities(List<MerchSubclassEntity> merchSubclassEntities) {
        this.merchSubclassEntities = merchSubclassEntities;
    }
}

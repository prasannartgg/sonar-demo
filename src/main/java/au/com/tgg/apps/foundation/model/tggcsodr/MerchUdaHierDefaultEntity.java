package au.com.tgg.apps.foundation.model.tggcsodr;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "merch_uda_hier_default")
public class MerchUdaHierDefaultEntity {

    @Id
    @Column(name = "uda_hier_def_id")
    private BigInteger udaHierDefId;

    @Basic
    @Column(name = "merch_level")
    private short merchLevel;

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
    @Column(name = "uda_value_id")
    private BigInteger udaValueId;      //RMS PK    FK

    @Basic
    @Column(name = "dep_id")
    private BigInteger depId;           //RMS PK    FK

    @Basic
    @Column(name = "class_id")
    private BigInteger classId;         //RMS PK    FK

    @Basic
    @Column(name = "subclass_id")
    private BigInteger subclassId;      //RMS PK    FK


    public BigInteger getUdaHierDefId() {
        return udaHierDefId;
    }

    public void setUdaHierDefId(BigInteger udaHierDefId) {
        this.udaHierDefId = udaHierDefId;
    }


    public short getMerchLevel() {
        return merchLevel;
    }

    public void setMerchLevel(short merchLevel) {
        this.merchLevel = merchLevel;
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
        MerchUdaHierDefaultEntity that = (MerchUdaHierDefaultEntity) o;
        return merchLevel == that.merchLevel &&
                Objects.equals(udaHierDefId, that.udaHierDefId) &&
                Objects.equals(deleted, that.deleted) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(lastModifiedBy, that.lastModifiedBy) &&
                Objects.equals(lastModifiedDate, that.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(udaHierDefId, merchLevel, deleted, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
    }


    public BigInteger getUdaValueId() {
        return udaValueId;
    }

    public void setUdaValueId(BigInteger udaValueId) {
        this.udaValueId = udaValueId;
    }


    public BigInteger getDepId() {
        return depId;
    }

    public void setDepId(BigInteger depId) {
        this.depId = depId;
    }


    public BigInteger getClassId() {
        return classId;
    }

    public void setClassId(BigInteger classId) {
        this.classId = classId;
    }


    public BigInteger getSubclassId() {
        return subclassId;
    }

    public void setSubclassId(BigInteger subclassId) {
        this.subclassId = subclassId;
    }
}

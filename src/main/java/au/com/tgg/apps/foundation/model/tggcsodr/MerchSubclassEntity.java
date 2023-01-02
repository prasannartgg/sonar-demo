package au.com.tgg.apps.foundation.model.tggcsodr;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "merch_subclass", schema = "tggcsodr", catalog = "postgres")
@DynamicUpdate
@SuppressWarnings("ALL")
public class MerchSubclassEntity implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_merch_subclass")
    @SequenceGenerator(name="seq_merch_subclass", sequenceName="seq_merch_subclass", allocationSize=1)
    @Column(name = "subclass_id")
    private BigInteger subclassId;

    @Basic
    @Column(name = "subclass")
    private BigInteger subclass;     //RMS PK

    @Basic
    @Column(name = "subclass_name")
    private String subclassName;
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
    @ManyToOne()
    @JoinColumn(name = "class_id")
    private MerchClassEntity merchClassEntity;     //FK
    @Basic
    @Column(name = "class")
    private BigInteger clazz;


    public BigInteger getSubclass() {
        return subclass;
    }

    public void setSubclass(BigInteger subclass) {
        this.subclass = subclass;
    }


    public String getSubclassName() {
        return subclassName;
    }

    public void setSubclassName(String subclassName) {
        this.subclassName = subclassName;
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

    public BigInteger getSubclassId() {
        return subclassId;
    }

    public void setSubclassId(BigInteger subclassId) {
        this.subclassId = subclassId;
    }

    public MerchClassEntity getMerchClassEntity() {
        return merchClassEntity;
    }

    public void setMerchClassEntity(MerchClassEntity merchClassEntity) {
        this.merchClassEntity = merchClassEntity;
    }

    public MerchClassEntity getMerchClass() {
        return merchClassEntity;
    }

    public void setMerchClass(MerchClassEntity merchClassEntity) {
        this.merchClassEntity = merchClassEntity;
    }

    public BigInteger getClazz() {
        return clazz;
    }

    public void setClazz(BigInteger clazz) {
        this.clazz = clazz;
    }
}

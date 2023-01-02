package au.com.tgg.apps.foundation.model.tggcsodr;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "merch_uda_value")
@SuppressWarnings("ALL")
@DynamicUpdate
public class MerchUdaValueEntity {

    @Id
    @Column(name = "uda_value_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_merch_uda_value")
    @SequenceGenerator(name="seq_merch_uda_value", sequenceName="seq_merch_uda_value",allocationSize=1)
    private BigInteger udaValueId;

    @Basic
    @Column(name = "source_uda_value_id")
    private BigInteger sourceUdaValueId;  //RMS PK

    @Basic
    @Column(name = "source_uda_id")
    private BigInteger sourceUdaId;  //RMS PK

    @Basic
    @Column(name = "uda_value_code")
    private String udaValueCode;            //RMS PK

    @Basic
    @Column(name = "uda_value_desc")
    private String udaValueDesc;

    @Basic
    @Column(name = "isdefault")
    private String isdefault;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="uda_id", nullable=false)
    private MerchUdaEntity merchUdaEntity;               //FK


    public MerchUdaEntity getMerchUdaEntity() {
        return merchUdaEntity;
    }

    public void setMerchUdaEntity(MerchUdaEntity merchUdaEntity) {
        this.merchUdaEntity = merchUdaEntity;
    }

    public BigInteger getUdaValueId() {
        return udaValueId;
    }

    public void setUdaValueId(BigInteger udaValueId) {
        this.udaValueId = udaValueId;
    }


    public BigInteger getSourceUdaValueId() {
        return sourceUdaValueId;
    }

    public void setSourceUdaValueId(BigInteger sourceUdaValueId) {
        this.sourceUdaValueId = sourceUdaValueId;
    }

    public BigInteger getSourceUdaId() {
        return sourceUdaId;
    }

    public void setSourceUdaId(BigInteger sourceUdaId) {
        this.sourceUdaId = sourceUdaId;
    }

    public String getUdaValueCode() {
        return udaValueCode;
    }

    public void setUdaValueCode(String udaValueCode) {
        this.udaValueCode = udaValueCode;
    }


    public String getUdaValueDesc() {
        return udaValueDesc;
    }

    public void setUdaValueDesc(String udaValueDesc) {
        this.udaValueDesc = udaValueDesc;
    }


    public String getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(String isdefault) {
        this.isdefault = isdefault;
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
        MerchUdaValueEntity that = (MerchUdaValueEntity) o;
        return Objects.equals(udaValueId, that.udaValueId) &&
                Objects.equals(sourceUdaValueId, that.sourceUdaValueId) &&
                Objects.equals(udaValueCode, that.udaValueCode) &&
                Objects.equals(udaValueDesc, that.udaValueDesc) &&
                Objects.equals(isdefault, that.isdefault) &&
                Objects.equals(deleted, that.deleted) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(lastModifiedBy, that.lastModifiedBy) &&
                Objects.equals(lastModifiedDate, that.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(udaValueId, sourceUdaValueId, udaValueCode, udaValueDesc, isdefault, deleted, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
    }
}

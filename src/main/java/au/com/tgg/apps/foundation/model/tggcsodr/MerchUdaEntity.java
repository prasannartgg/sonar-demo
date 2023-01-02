package au.com.tgg.apps.foundation.model.tggcsodr;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "merch_uda")
@DynamicUpdate
@SuppressWarnings("ALL")
public class MerchUdaEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_merch_uda")
    @SequenceGenerator(name="seq_merch_uda", sequenceName="seq_merch_uda", allocationSize=1)
    @Column(name = "uda_id")
    private BigInteger udaId;

    @Basic
    @Column(name = "source_uda_id")
    private BigInteger sourceUdaId;

    @Basic
    @Column(name = "source_system")
    private String sourceSystem;

    @Basic
    @Column(name = "uda_code")
    private String udaCode;     //RMS PK

    @Basic
    @Column(name = "uda_desc")
    private String udaDesc;

    @Basic
    @Column(name = "data_type")
    private String dataType;

    @Basic
    @Column(name = "data_length")
    private BigInteger dataLength;

    @Basic
    @Column(name = "manually_maintained")
    private String manuallyMaintained;

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
    @Column(name = "date")
    private LocalDateTime date;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="merchUdaEntity")
    private List<MerchUdaValueEntity> merchUdaValueEntityList;


    public List<MerchUdaValueEntity> getMerchUdaValueEntityList() {
        return merchUdaValueEntityList;
    }

    public void setMerchUdaValueEntityList(List<MerchUdaValueEntity> merchUdaValueEntityList) {
        this.merchUdaValueEntityList = merchUdaValueEntityList;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigInteger getUdaId() {
        return udaId;
    }

    public void setUdaId(BigInteger udaId) {
        this.udaId = udaId;
    }


    public BigInteger getSourceUdaId() {
        return sourceUdaId;
    }

    public void setSourceUdaId(BigInteger sourceUdaId) {
        this.sourceUdaId = sourceUdaId;
    }


    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }


    public String getUdaCode() {
        return udaCode;
    }

    public void setUdaCode(String udaCode) {
        this.udaCode = udaCode;
    }


    public String getUdaDesc() {
        return udaDesc;
    }

    public void setUdaDesc(String udaDesc) {
        this.udaDesc = udaDesc;
    }


    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }


    public BigInteger getDataLength() {
        return dataLength;
    }

    public void setDataLength(BigInteger dataLength) {
        this.dataLength = dataLength;
    }


    public String getManuallyMaintained() {
        return manuallyMaintained;
    }

    public void setManuallyMaintained(String manuallyMaintained) {
        this.manuallyMaintained = manuallyMaintained;
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
        MerchUdaEntity that = (MerchUdaEntity) o;
        return Objects.equals(udaId, that.udaId) &&
                Objects.equals(sourceUdaId, that.sourceUdaId) &&
                Objects.equals(sourceSystem, that.sourceSystem) &&
                Objects.equals(udaCode, that.udaCode) &&
                Objects.equals(udaDesc, that.udaDesc) &&
                Objects.equals(dataType, that.dataType) &&
                Objects.equals(dataLength, that.dataLength) &&
                Objects.equals(manuallyMaintained, that.manuallyMaintained) &&
                Objects.equals(deleted, that.deleted) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(lastModifiedBy, that.lastModifiedBy) &&
                Objects.equals(lastModifiedDate, that.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(udaId, sourceUdaId, sourceSystem, udaCode, udaDesc, dataType, dataLength, manuallyMaintained, deleted, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
    }
}

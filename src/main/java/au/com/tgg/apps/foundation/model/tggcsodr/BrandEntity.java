package au.com.tgg.apps.foundation.model.tggcsodr;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "brand")
@DynamicUpdate
@SuppressWarnings("ALL")
public class BrandEntity implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_brand_id")
    @SequenceGenerator(name="seq_brand_id", sequenceName="seq_brand_id",allocationSize=1)
    @Basic
    @Column(name = "brand_id",unique=true)
    private BigInteger brandId;

    @Basic
    @Column(name = "brand_code",unique=true)
    private String brandCode;
    @Basic
    @Column(name = "brand_name")
    private String brandName;
    @Basic
    @Column(name = "brand_descr")
    private String brandDescr;
    @Basic
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Basic
    @Column(name = "create_id")
    private String createdId;
    @Basic
    @Column(name = "created_user")
    private String createdUser;
    @Basic
    @Column(name = "last_update_date",columnDefinition = "TIMESTAMP")
    private LocalDateTime lastUpdateDate;
    @Basic
    @Column(name = "last_update_user")
    private String lastUpdateUser;


    public String getCreatedId() {
        return createdId;
    }

    public void setCreatedId(String createdId) {
        this.createdId = createdId;
    }


    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }


    public String getBrandDescr() {
        return brandDescr;
    }

    public void setBrandDescr(String brandDescr) {
        this.brandDescr = brandDescr;
    }

    public BigInteger getBrandId() {
        return brandId;
    }

    public void setBrandId(BigInteger brandId) {
        this.brandId = brandId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }


    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }


    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }


    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandEntity that = (BrandEntity) o;
        return Objects.equals(brandCode, that.brandCode) &&
                Objects.equals(brandName, that.brandName) &&
                Objects.equals(brandDescr, that.brandDescr) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(createdId, that.createdId) &&
                Objects.equals(createdUser, that.createdUser) &&
                Objects.equals(lastUpdateDate, that.lastUpdateDate) &&
                Objects.equals(lastUpdateUser, that.lastUpdateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandCode, brandName, brandDescr, createdDate, createdId, createdUser, lastUpdateDate, lastUpdateUser);
    }
}

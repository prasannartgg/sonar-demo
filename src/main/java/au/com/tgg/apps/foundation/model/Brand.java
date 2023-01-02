package au.com.tgg.apps.foundation.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name="BRAND", schema = "TGGCSODR")
public class Brand {
    private Long brandId;
    private String brandCode;
    private String brandName;
    private String brandDescr;
    private Time createdDate;
    private String createdUser;
    private Time lastUpdateDate;
    private String lastUpdateUser;

    @Id
    @Column(name = "BRAND_ID")
    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    @Basic
    @Column(name = "BRAND_CODE")
    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    @Basic
    @Column(name = "BRAND_NAME")
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Basic
    @Column(name = "BRAND_DESCR")
    public String getBrandDescr() {
        return brandDescr;
    }

    public void setBrandDescr(String brandDescr) {
        this.brandDescr = brandDescr;
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
    @Column(name = "CREATED_USER")
    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    @Basic
    @Column(name = "LAST_UPDATE_DATE")
    public Time getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Time lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Basic
    @Column(name = "LAST_UPDATE_USER")
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
        Brand brand = (Brand) o;
        return Objects.equals(brandId, brand.brandId) &&
                Objects.equals(brandCode, brand.brandCode) &&
                Objects.equals(brandName, brand.brandName) &&
                Objects.equals(brandDescr, brand.brandDescr) &&
                Objects.equals(createdDate, brand.createdDate) &&
                Objects.equals(createdUser, brand.createdUser) &&
                Objects.equals(lastUpdateDate, brand.lastUpdateDate) &&
                Objects.equals(lastUpdateUser, brand.lastUpdateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, brandCode, brandName, brandDescr, createdDate, createdUser, lastUpdateDate, lastUpdateUser);
    }
}

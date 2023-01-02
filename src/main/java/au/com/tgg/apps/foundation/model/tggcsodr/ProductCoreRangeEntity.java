package au.com.tgg.apps.foundation.model.tggcsodr;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "product_core_range")
@DynamicUpdate
@SuppressWarnings("ALL")
public class ProductCoreRangeEntity {
    @Id
    @Column(name = "prod_core_range")
    private String prodCoreRange;   //RMS PK

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "last_update_date")
    private LocalDateTime lastUpdateDate;

    @Basic
    @Column(name = "last_update_user")
    private String lastUpdateUser;


    public String getProdCoreRange() {
        return prodCoreRange;
    }

    public void setProdCoreRange(String prodCoreRange) {
        this.prodCoreRange = prodCoreRange;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        ProductCoreRangeEntity that = (ProductCoreRangeEntity) o;
        return Objects.equals(prodCoreRange, that.prodCoreRange) &&
                Objects.equals(description, that.description) &&
                Objects.equals(lastUpdateDate, that.lastUpdateDate) &&
                Objects.equals(lastUpdateUser, that.lastUpdateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodCoreRange, description, lastUpdateDate, lastUpdateUser);
    }
}

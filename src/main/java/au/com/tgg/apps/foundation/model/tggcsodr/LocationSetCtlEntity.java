package au.com.tgg.apps.foundation.model.tggcsodr;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "location_set_ctl")
@DynamicUpdate
public class LocationSetCtlEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_location_set_id")
    @SequenceGenerator(name="seq_location_set_id", sequenceName="seq_location_set_id",allocationSize=1)
    @Column(name = "location_set_id")
    private BigInteger locationSetId;

    @Basic
    @Column(name = "inv_name")
    private String invName;

    @Basic
    @Column(name = "locn_set_name")
    private String locnSetName;     //RMS PK

    @Basic
    @Column(name = "locn_set_descr")
    private String locnSetDescr;

    @Basic
    @Column(name = "locn_set_long_descr")
    private String locnSetLongDescr;

    @Basic
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Basic
    @Column(name = "created_user")
    private String createdUser;

    @Basic
    @Column(name = "last_update_date")
    private LocalDateTime lastUpdateDate;

    @Basic
    @Column(name = "last_update_user")
    private String lastUpdateUser;


    public BigInteger getLocationSetId() {
        return locationSetId;
    }

    public void setLocationSetId(BigInteger locationSetId) {
        this.locationSetId = locationSetId;
    }


    public String getInvName() {
        return invName;
    }

    public void setInvName(String invName) {
        this.invName = invName;
    }


    public String getLocnSetName() {
        return locnSetName;
    }

    public void setLocnSetName(String locnSetName) {
        this.locnSetName = locnSetName;
    }


    public String getLocnSetDescr() {
        return locnSetDescr;
    }

    public void setLocnSetDescr(String locnSetDescr) {
        this.locnSetDescr = locnSetDescr;
    }


    public String getLocnSetLongDescr() {
        return locnSetLongDescr;
    }

    public void setLocnSetLongDescr(String locnSetLongDescr) {
        this.locnSetLongDescr = locnSetLongDescr;
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
        LocationSetCtlEntity that = (LocationSetCtlEntity) o;
        return Objects.equals(locationSetId, that.locationSetId) &&
                Objects.equals(invName, that.invName) &&
                Objects.equals(locnSetName, that.locnSetName) &&
                Objects.equals(locnSetDescr, that.locnSetDescr) &&
                Objects.equals(locnSetLongDescr, that.locnSetLongDescr) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(createdUser, that.createdUser) &&
                Objects.equals(lastUpdateDate, that.lastUpdateDate) &&
                Objects.equals(lastUpdateUser, that.lastUpdateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationSetId, invName, locnSetName, locnSetDescr, locnSetLongDescr, createdDate, createdUser, lastUpdateDate, lastUpdateUser);
    }
}

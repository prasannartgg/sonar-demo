package au.com.tgg.apps.foundation.model.tggcsodr;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "location_state_mapping")
@DynamicUpdate
public class LocationStateMappingEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_location_state_mapping_id")
    @SequenceGenerator(name="seq_location_state_mapping_id", sequenceName="seq_location_state_mapping_id", allocationSize=1)
    @Column(name = "location_state_mapping_id")
    private BigInteger locationStateMappingId;

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
    @Basic
    @Column(name = "location_id")
    private BigInteger locationId;          //RMS PK    FK
    @Basic
    @Column(name = "location_state_id")
    private BigInteger locationStateId;     //RMS PK    FK
    private String locnName;


    public BigInteger getLocationStateMappingId() {
        return locationStateMappingId;
    }

    public void setLocationStateMappingId(BigInteger locationStateMappingId) {
        this.locationStateMappingId = locationStateMappingId;
    }

    @Basic
    @Column(name = "created_date")
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }


    @Basic
    @Column(name = "created_user")
    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }


    @Basic
    @Column(name = "last_update_date")
    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Basic
    @Column(name = "last_update_user")
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
        LocationStateMappingEntity that = (LocationStateMappingEntity) o;
        return Objects.equals(locationStateMappingId, that.locationStateMappingId) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(createdUser, that.createdUser) &&
                Objects.equals(lastUpdateDate, that.lastUpdateDate) &&
                Objects.equals(lastUpdateUser, that.lastUpdateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationStateMappingId, createdDate, createdUser, lastUpdateDate, lastUpdateUser);
    }

    @Basic
    @Column(name = "location_id")
    public BigInteger getLocationId() {
        return locationId;
    }

    public void setLocationId(BigInteger locationId) {
        this.locationId = locationId;
    }

    @Basic
    @Column(name = "location_state_id")
    public BigInteger getLocationStateId() {
        return locationStateId;
    }

    public void setLocationStateId(BigInteger locationStateId) {
        this.locationStateId = locationStateId;
    }

    @Basic
    @Column(name = "locn_name")
    public String getLocnName() {
        return locnName;
    }

    public void setLocnName(String locnName) {
        this.locnName = locnName;
    }
}

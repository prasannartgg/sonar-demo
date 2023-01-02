package au.com.tgg.apps.foundation.model.tggcsodr;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "location_state")
@DynamicUpdate
@SuppressWarnings("ALL")
public class LocationStateEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_location_id")
    @SequenceGenerator(name="seq_location_state_id", sequenceName="seq_location_state_id", allocationSize=1)
    @Column(name = "location_state_id")
    private BigInteger locationStateId;

    @Basic
    @Column(name = "state_code")
    private String stateCode;       //RMS PK

    @Basic
    @Column(name = "state_name")
    private String stateName;

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
    @ManyToOne()
    @JoinColumn(name = "country_code")
    private CountryEntity countryEntity;     //FK

    @OneToMany(mappedBy = "locationStateEntity", fetch = FetchType.LAZY)
    private List<LocationEntity> locationEntityList;


    public BigInteger getLocationStateId() {
        return locationStateId;
    }

    public void setLocationStateId(BigInteger locationStateId) {
        this.locationStateId = locationStateId;
    }


    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }


    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
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


    public CountryEntity getCountryEntity() {
        return countryEntity;
    }

    public void setCountryEntity(CountryEntity countryEntity) {
        this.countryEntity = countryEntity;
    }

    public List<LocationEntity> getLocationEntityList() {
        return locationEntityList;
    }

    public void setLocationEntityList(List<LocationEntity> locationEntityList) {
        this.locationEntityList = locationEntityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationStateEntity that = (LocationStateEntity) o;
        return Objects.equals(locationStateId, that.locationStateId) &&
                Objects.equals(stateCode, that.stateCode) &&
                Objects.equals(stateName, that.stateName) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(createdUser, that.createdUser) &&
                Objects.equals(lastUpdateDate, that.lastUpdateDate) &&
                Objects.equals(lastUpdateUser, that.lastUpdateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationStateId, stateCode, stateName, createdDate, createdUser, lastUpdateDate, lastUpdateUser);
    }
}

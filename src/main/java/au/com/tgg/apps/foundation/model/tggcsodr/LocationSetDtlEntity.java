package au.com.tgg.apps.foundation.model.tggcsodr;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "location_set_dtl")
@DynamicUpdate
public class LocationSetDtlEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_location_set_dtl_id")
    @SequenceGenerator(name="seq_location_set_dtl_id", sequenceName="seq_location_set_dtl_id",allocationSize=1)
    @Column(name = "location_set_dtl_id")
    private BigInteger locationSetDtlId;

    @Basic
    @Column(name = "location_set_id")
    private BigInteger locationSetId;   //RMS PK    FK

    @Basic
    @Column(name = "location_id")
    private BigInteger locationId;      //RMS PK    FK

    @Basic
    @Column(name = "locn_name")
    private String locnName;

    public BigInteger getLocationSetDtlId() {
        return locationSetDtlId;
    }

    public void setLocationSetDtlId(BigInteger locationSetDtlId) {
        this.locationSetDtlId = locationSetDtlId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationSetDtlEntity that = (LocationSetDtlEntity) o;
        return Objects.equals(locationSetDtlId, that.locationSetDtlId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationSetDtlId);
    }

    public BigInteger getLocationSetId() {
        return locationSetId;
    }

    public void setLocationSetId(BigInteger locationSetId) {
        this.locationSetId = locationSetId;
    }

    public BigInteger getLocationId() {
        return locationId;
    }

    public void setLocationId(BigInteger locationId) {
        this.locationId = locationId;
    }

    public String getLocnName() {
        return locnName;
    }

    public void setLocnName(String locnName) {
        this.locnName = locnName;
    }
}

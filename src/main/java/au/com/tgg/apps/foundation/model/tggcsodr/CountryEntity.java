package au.com.tgg.apps.foundation.model.tggcsodr;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "country")
@DynamicUpdate
public class CountryEntity {

    @Id
    @Column(name = "country_code")
    private String countryCode;     //RMS PK

    @Basic
    @Column(name = "country_description")
    private String countryDescription;

    @Basic
    @Column(name = "gst_rate")
    private Double gstRate;

    @Basic
    @Column(name = "gst_ratio")
    private Double gstRatio;

    @Basic
    @Column(name = "inv_name")
    private String invName;

    @Basic
    @Column(name = "clg_code")
    private String clgCode;

    @Basic
    @Column(name = "currency_code")
    private String currencyCode;

    @Basic
    @Column(name = "automaton_country_id")
    private BigInteger automatonCountryId;

    @OneToMany(mappedBy = "countryEntity")
    private List<LocationStateEntity> locationStateEntities;


    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


    public String getCountryDescription() {
        return countryDescription;
    }

    public void setCountryDescription(String countryDescription) {
        this.countryDescription = countryDescription;
    }


    public Double getGstRate() {
        return gstRate;
    }

    public void setGstRate(Double gstRate) {
        this.gstRate = gstRate;
    }


    public Double getGstRatio() {
        return gstRatio;
    }

    public void setGstRatio(Double gstRatio) {
        this.gstRatio = gstRatio;
    }


    public String getInvName() {
        return invName;
    }

    public void setInvName(String invName) {
        this.invName = invName;
    }


    public String getClgCode() {
        return clgCode;
    }

    public void setClgCode(String clgCode) {
        this.clgCode = clgCode;
    }


    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }


    public BigInteger getAutomatonCountryId() {
        return automatonCountryId;
    }

    public void setAutomatonCountryId(BigInteger automatonCountryId) {
        this.automatonCountryId = automatonCountryId;
    }

    public List<LocationStateEntity> getLocationStateEntities() {
        return locationStateEntities;
    }

    public void setLocationStateEntities(List<LocationStateEntity> locationStateEntities) {
        this.locationStateEntities = locationStateEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryEntity that = (CountryEntity) o;
        return Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(countryDescription, that.countryDescription) &&
                Objects.equals(gstRate, that.gstRate) &&
                Objects.equals(gstRatio, that.gstRatio) &&
                Objects.equals(invName, that.invName) &&
                Objects.equals(clgCode, that.clgCode) &&
                Objects.equals(currencyCode, that.currencyCode) &&
                Objects.equals(automatonCountryId, that.automatonCountryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, countryDescription, gstRate, gstRatio, invName, clgCode, currencyCode, automatonCountryId);
    }
}

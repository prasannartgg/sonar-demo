package au.com.tgg.apps.foundation.model.tggcsodr;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "location")
@DynamicUpdate
@SuppressWarnings("ALL")
public class LocationEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_location_id")
    @SequenceGenerator(name="seq_location_id", sequenceName="seq_location_id",allocationSize=1)
    @Column(name = "location_id")
    private BigInteger locationId;

    @Basic
    @Column(name = "inv_name")
    private String invName;

    @Basic
    @Column(name = "locn_name")
    private String locnName;        //RMS PK

    @Basic
    @ManyToOne()
    @JoinColumn(name = "location_state_id")
    private LocationStateEntity locationStateEntity;

    @Basic
    @Column(name = "legacy_catalogue_id")
    private BigInteger legacyCatalogueId;

    @Basic
    @Column(name = "location_latitude")
    private Double locationLatitude;

    @Basic
    @Column(name = "location_longitude")
    private Double locationLongitude;

    @Basic
    @Column(name = "locn_descr")
    private String locnDescr;

    @Basic
    @Column(name = "locn_acct_descr1")
    private String locnAcctDescr1;

    @Basic
    @Column(name = "locn_addr1")
    private String locnAddr1;

    @Basic
    @Column(name = "locn_addr2")
    private String locnAddr2;

    @Basic
    @Column(name = "locn_suburb")
    private String locnSuburb;

    @Basic
    @Column(name = "locn_post_code")
    private String locnPostCode;

    @Basic
    @Column(name = "locn_phone")
    private String locnPhone;

    @Basic
    @Column(name = "locn_fax")
    private String locnFax;

    @Basic
    @Column(name = "contact_title")
    private String contactTitle;

    @Basic
    @Column(name = "contact_first_name")
    private String contactFirstName;

    @Basic
    @Column(name = "contact_last_name")
    private String contactLastName;

    @Basic
    @Column(name = "contact_email_addr")
    private String contactEmailAddr;

    @Basic
    @Column(name = "web_contact_email_addr")
    private String webContactEmailAddr;

    @Basic
    @Column(name = "locn_active_ind")
    private String locnActiveInd;

    @Basic
    @Column(name = "locn_security_group")
    private String locnSecurityGroup;

    @Basic
    @Column(name = "locn_security_group_name")
    private String locnSecurityGroupName;

    @Basic
    @Column(name = "created_date")
    private Timestamp createdDate;

    @Basic
    @Column(name = "created_user")
    private String createdUser;

    @Basic
    @Column(name = "last_update_date")
    private Timestamp lastUpdateDate;

    @Basic
    @Column(name = "last_update_user")
    private String lastUpdateUser;

    @Basic
    @Column(name = "locn_company_nbr")
    private String locnCompanyNbr;

    @Basic
    @Column(name = "locn_business_nbr")
    private String locnBusinessNbr;

    @Basic
    @Column(name = "locn_seek_id")
    private BigInteger locnSeekId;


    @Basic
    @Column(name = "locn_company_name")
    private String locnCompanyName;

    @Basic
    @Column(name = "prop_email_addr")
    private String propEmailAddr;

    @Basic
    @Column(name = "wsc_status")
    private String wscStatus;

    @Basic
    @Column(name = "locn_nbr")
    private BigInteger locnNbr;

    @Basic
    @Column(name = "store_type")
    private String storeType;

    @Basic
    @Column(name = "map_url")
    private String mapUrl;

    @Basic
    @Column(name = "store_open_date")
    private java.sql.Date storeOpenDate;

    @Basic
    @Column(name = "store_close_date")
    private java.sql.Date storeCloseDate;

    @Basic
    @Column(name = "regional_manager_id")
    private BigInteger regionalManagerId;

    @Basic
    @Column(name = "crc_ind")
    private String crcInd;

    @Basic
    @Column(name = "timezone_name")
    private String timezoneName;

    @Basic
    @Column(name = "replacement_store")
    private String replacementStore;


    public BigInteger getLocationId() {
        return locationId;
    }

    public void setLocationId(BigInteger locationId) {
        this.locationId = locationId;
    }


    public String getInvName() {
        return invName;
    }

    public void setInvName(String invName) {
        this.invName = invName;
    }


    public String getLocnName() {
        return locnName;
    }

    public void setLocnName(String locnName) {
        this.locnName = locnName;
    }


    public LocationStateEntity getLocationStateEntity() {
        return locationStateEntity;
    }

    public void setLocationStateEntity(LocationStateEntity locationStateEntity) {
        this.locationStateEntity = locationStateEntity;
    }


    public BigInteger getLegacyCatalogueId() {
        return legacyCatalogueId;
    }

    public void setLegacyCatalogueId(BigInteger legacyCatalogueId) {
        this.legacyCatalogueId = legacyCatalogueId;
    }


    public Double getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(Double locationLatitude) {
        this.locationLatitude = locationLatitude;
    }


    public Double getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(Double locationLongitude) {
        this.locationLongitude = locationLongitude;
    }


    public String getLocnDescr() {
        return locnDescr;
    }

    public void setLocnDescr(String locnDescr) {
        this.locnDescr = locnDescr;
    }


    public String getLocnAcctDescr1() {
        return locnAcctDescr1;
    }

    public void setLocnAcctDescr1(String locnAcctDescr1) {
        this.locnAcctDescr1 = locnAcctDescr1;
    }


    public String getLocnAddr1() {
        return locnAddr1;
    }

    public void setLocnAddr1(String locnAddr1) {
        this.locnAddr1 = locnAddr1;
    }


    public String getLocnAddr2() {
        return locnAddr2;
    }

    public void setLocnAddr2(String locnAddr2) {
        this.locnAddr2 = locnAddr2;
    }


    public String getLocnSuburb() {
        return locnSuburb;
    }

    public void setLocnSuburb(String locnSuburb) {
        this.locnSuburb = locnSuburb;
    }


    public String getLocnPostCode() {
        return locnPostCode;
    }

    public void setLocnPostCode(String locnPostCode) {
        this.locnPostCode = locnPostCode;
    }


    public String getLocnPhone() {
        return locnPhone;
    }

    public void setLocnPhone(String locnPhone) {
        this.locnPhone = locnPhone;
    }


    public String getLocnFax() {
        return locnFax;
    }

    public void setLocnFax(String locnFax) {
        this.locnFax = locnFax;
    }


    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }


    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }


    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }


    public String getContactEmailAddr() {
        return contactEmailAddr;
    }

    public void setContactEmailAddr(String contactEmailAddr) {
        this.contactEmailAddr = contactEmailAddr;
    }


    public String getWebContactEmailAddr() {
        return webContactEmailAddr;
    }

    public void setWebContactEmailAddr(String webContactEmailAddr) {
        this.webContactEmailAddr = webContactEmailAddr;
    }


    public String getLocnActiveInd() {
        return locnActiveInd;
    }

    public void setLocnActiveInd(String locnActiveInd) {
        this.locnActiveInd = locnActiveInd;
    }


    public String getLocnSecurityGroup() {
        return locnSecurityGroup;
    }

    public void setLocnSecurityGroup(String locnSecurityGroup) {
        this.locnSecurityGroup = locnSecurityGroup;
    }


    public String getLocnSecurityGroupName() {
        return locnSecurityGroupName;
    }

    public void setLocnSecurityGroupName(String locnSecurityGroupName) {
        this.locnSecurityGroupName = locnSecurityGroupName;
    }


    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }


    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }


    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }


    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }


    public String getLocnCompanyNbr() {
        return locnCompanyNbr;
    }

    public void setLocnCompanyNbr(String locnCompanyNbr) {
        this.locnCompanyNbr = locnCompanyNbr;
    }


    public String getLocnBusinessNbr() {
        return locnBusinessNbr;
    }

    public void setLocnBusinessNbr(String locnBusinessNbr) {
        this.locnBusinessNbr = locnBusinessNbr;
    }


    public BigInteger getLocnSeekId() {
        return locnSeekId;
    }

    public void setLocnSeekId(BigInteger locnSeekId) {
        this.locnSeekId = locnSeekId;
    }


    public String getLocnCompanyName() {
        return locnCompanyName;
    }

    public void setLocnCompanyName(String locnCompanyName) {
        this.locnCompanyName = locnCompanyName;
    }


    public String getPropEmailAddr() {
        return propEmailAddr;
    }

    public void setPropEmailAddr(String propEmailAddr) {
        this.propEmailAddr = propEmailAddr;
    }


    public String getWscStatus() {
        return wscStatus;
    }

    public void setWscStatus(String wscStatus) {
        this.wscStatus = wscStatus;
    }


    public BigInteger getLocnNbr() {
        return locnNbr;
    }

    public void setLocnNbr(BigInteger locnNbr) {
        this.locnNbr = locnNbr;
    }


    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }


    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }


    public java.sql.Date getStoreOpenDate() {
        return storeOpenDate;
    }

    public void setStoreOpenDate(java.sql.Date storeOpenDate) {
        this.storeOpenDate = storeOpenDate;
    }


    public java.sql.Date getStoreCloseDate() {
        return storeCloseDate;
    }

    public void setStoreCloseDate(java.sql.Date storeCloseDate) {
        this.storeCloseDate = storeCloseDate;
    }


    public BigInteger getRegionalManagerId() {
        return regionalManagerId;
    }

    public void setRegionalManagerId(BigInteger regionalManagerId) {
        this.regionalManagerId = regionalManagerId;
    }


    public String getCrcInd() {
        return crcInd;
    }

    public void setCrcInd(String crcInd) {
        this.crcInd = crcInd;
    }


    public String getTimezoneName() {
        return timezoneName;
    }

    public void setTimezoneName(String timezoneName) {
        this.timezoneName = timezoneName;
    }


    public String getReplacementStore() {
        return replacementStore;
    }

    public void setReplacementStore(String replacementStore) {
        this.replacementStore = replacementStore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationEntity that = (LocationEntity) o;
        return Objects.equals(locationId, that.locationId) &&
                Objects.equals(invName, that.invName) &&
                Objects.equals(locnName, that.locnName) &&
//                Objects.equals(locationStateId, that.locationStateId) &&
                Objects.equals(legacyCatalogueId, that.legacyCatalogueId) &&
                Objects.equals(locationLatitude, that.locationLatitude) &&
                Objects.equals(locationLongitude, that.locationLongitude) &&
                Objects.equals(locnDescr, that.locnDescr) &&
                Objects.equals(locnAcctDescr1, that.locnAcctDescr1) &&
                Objects.equals(locnAddr1, that.locnAddr1) &&
                Objects.equals(locnAddr2, that.locnAddr2) &&
                Objects.equals(locnSuburb, that.locnSuburb) &&
                Objects.equals(locnPostCode, that.locnPostCode) &&
                Objects.equals(locnPhone, that.locnPhone) &&
                Objects.equals(locnFax, that.locnFax) &&
                Objects.equals(contactTitle, that.contactTitle) &&
                Objects.equals(contactFirstName, that.contactFirstName) &&
                Objects.equals(contactLastName, that.contactLastName) &&
                Objects.equals(contactEmailAddr, that.contactEmailAddr) &&
                Objects.equals(webContactEmailAddr, that.webContactEmailAddr) &&
                Objects.equals(locnActiveInd, that.locnActiveInd) &&
                Objects.equals(locnSecurityGroup, that.locnSecurityGroup) &&
                Objects.equals(locnSecurityGroupName, that.locnSecurityGroupName) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(createdUser, that.createdUser) &&
                Objects.equals(lastUpdateDate, that.lastUpdateDate) &&
                Objects.equals(lastUpdateUser, that.lastUpdateUser) &&
                Objects.equals(locnCompanyNbr, that.locnCompanyNbr) &&
                Objects.equals(locnBusinessNbr, that.locnBusinessNbr) &&
                Objects.equals(locnSeekId, that.locnSeekId) &&
                Objects.equals(locnCompanyName, that.locnCompanyName) &&
                Objects.equals(propEmailAddr, that.propEmailAddr) &&
                Objects.equals(wscStatus, that.wscStatus) &&
                Objects.equals(locnNbr, that.locnNbr) &&
                Objects.equals(storeType, that.storeType) &&
                Objects.equals(mapUrl, that.mapUrl) &&
                Objects.equals(storeOpenDate, that.storeOpenDate) &&
                Objects.equals(storeCloseDate, that.storeCloseDate) &&
                Objects.equals(regionalManagerId, that.regionalManagerId) &&
                Objects.equals(crcInd, that.crcInd) &&
                Objects.equals(timezoneName, that.timezoneName) &&
                Objects.equals(replacementStore, that.replacementStore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, invName, locnName, legacyCatalogueId, locationLatitude, locationLongitude, locnDescr, locnAcctDescr1, locnAddr1, locnAddr2, locnSuburb, locnPostCode, locnPhone, locnFax, contactTitle, contactFirstName, contactLastName, contactEmailAddr, webContactEmailAddr, locnActiveInd, locnSecurityGroup, locnSecurityGroupName, createdDate, createdUser, lastUpdateDate, lastUpdateUser, locnCompanyNbr, locnBusinessNbr, locnSeekId, locnCompanyName, propEmailAddr, wscStatus, locnNbr, storeType, mapUrl, storeOpenDate, storeCloseDate, regionalManagerId, crcInd, timezoneName, replacementStore);
    }
}

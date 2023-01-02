package au.com.tgg.apps.foundation.model.json;

import au.com.tgg.apps.foundation.util.JsonDateDeserializer;
import au.com.tgg.apps.foundation.util.JsonDateTimeSerializer;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Location
 * <p>
 * This is Location
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "operations",
        "location_id",
        "inv_name",
        "locn_name",
        "legacy_catalogue_id",
        "location_latitude",
        "location_longitude",
        "locn_descr",
        "locn_acct_descr1",
        "locn_fax",
        "contact_title",
        "contact_first_name",
        "contact_last_name",
        "web_contact_email_addr",
        "locn_active_ind",
        "locn_security_group",
        "locn_security_group_name",
        "created_date",
        "created_user",
        "last_update_date",
        "last_update_user",
        "locn_company_nbr",
        "locn_business_nbr",
        "locn_seek_id",
        "locn_company_name",
        "prop_email_addr",
        "wsc_status",
        "locn_nbr",
        "store_type",
        "map_url",
        "store_open_date",
        "store_close_date",
        "regional_manager_id",
        "crc_ind",
        "timezone_name",
        "replacement_store",
        "storeAddressList"
})
public class Location extends JsonHeader {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("location_id")
    private BigInteger locationId;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("inv_name")
    private String invName;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("locn_name")
    private String locnName;
//    @JsonProperty("location_state_name")
//    private String locationStateName;
//    @JsonProperty("location_state_id")
//    private BigInteger locationStateId;
//    @JsonProperty("legacy_catalogue_id")
    private BigInteger legacyCatalogueId;
    @JsonProperty("location_latitude")
    private BigInteger locationLatitude;
    @JsonProperty("location_longitude")
    private BigInteger locationLongitude;
    @JsonProperty("locn_descr")
    private String locnDescr;
    @JsonProperty("locn_acct_descr1")
    private String locnAcctDescr1;
//    @JsonProperty("locn_addr1")
//    private String locnAddr1;
//    @JsonProperty("locn_addr2")
//    private String locnAddr2;
//    @JsonProperty("locn_suburb")
//    private String locnSuburb;
//    @JsonProperty("locn_post_code")
//    private String locnPostCode;
//    @JsonProperty("locn_phone")
//    private String locnPhone;
    @JsonProperty("locn_fax")
    private String locnFax;
    @JsonProperty("contact_title")
    private String contactTitle;
    @JsonProperty("contact_first_name")
    private String contactFirstName;
    @JsonProperty("contact_last_name")
    private String contactLastName;
//    @JsonProperty("contact_email_addr")
//    private String contactEmailAddr;
    @JsonProperty("web_contact_email_addr")
    private String webContactEmailAddr;
    @JsonProperty("locn_active_ind")
    private String locnActiveInd;
    @JsonProperty("locn_security_group")
    private String locnSecurityGroup;
    @JsonProperty("locn_security_group_name")
    private String locnSecurityGroupName;
    @JsonProperty("created_date")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private LocalDate createdDate;
    @JsonProperty("created_user")
    private String createdUser;
    @JsonProperty("last_update_date")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private LocalDate lastUpdateDate;
    @JsonProperty("last_update_user")
    private String lastUpdateUser;
    @JsonProperty("locn_company_nbr")
    private BigInteger locnCompanyNbr;
    @JsonProperty("locn_business_nbr")
    private BigInteger locnBusinessNbr;
    @JsonProperty("locn_seek_id")
    private BigInteger locnSeekId;
    @JsonProperty("locn_company_name")
    private String locnCompanyName;
    @JsonProperty("prop_email_addr")
    private String propEmailAddr;
    @JsonProperty("wsc_status")
    private String wscStatus;
    @JsonProperty("locn_nbr")
    private BigInteger locnNbr;
    @JsonProperty("store_type")
    private String storeType;
    @JsonProperty("map_url")
    private String mapUrl;
    @JsonProperty("store_open_date")
    private Timestamp storeOpenDate;
    @JsonProperty("store_close_date")
    private Timestamp storeCloseDate;
    @JsonProperty("regional_manager_id")
    private BigInteger regionalManagerId;
    @JsonProperty("crc_ind")
    private String crcInd;
    @JsonProperty("timezone_name")
    private String timezoneName;
    @JsonProperty("replacement_store")
    private String replacementStore;
    @JsonProperty("storeAddressList")
    private List<StoreAddress> storeAddressList;
    @JsonIgnore
    private final Map<String, String> additionalProperties = new HashMap<String, String>();




    /**
     *
     * (Required)
     *
     */
    public BigInteger getLocationId() {
        return locationId;
    }

    /**
     *
     * (Required)
     *
     */
    public void setLocationId(BigInteger locationId) {
        this.locationId = locationId;
    }

    /**
     *
     * (Required)
     *
     */
    public String getInvName() {
        return invName;
    }

    /**
     *
     * (Required)
     *
     */
    public void setInvName(String invName) {
        this.invName = invName;
    }

    /**
     *
     * (Required)
     *
     */
    public String getLocnName() {
        return locnName;
    }

    /**
     *
     * (Required)
     *
     */
    public void setLocnName(String locnName) {
        this.locnName = locnName;
    }

//    public String getLocationStateName() {
//        return locationStateName;
//    }
//
//    public void setLocationStateName(String locationStateName) {
//        this.locationStateName = locationStateName;
//    }

//    public BigInteger getLocationStateId() {
//        return locationStateId;
//    }
//
//    public void setLocationStateId(BigInteger locationStateId) {
//        this.locationStateId = locationStateId;
//    }

    public BigInteger getLegacyCatalogueId() {
        return legacyCatalogueId;
    }

    public void setLegacyCatalogueId(BigInteger legacyCatalogueId) {
        this.legacyCatalogueId = legacyCatalogueId;
    }

    public BigInteger getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(BigInteger locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public BigInteger getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(BigInteger locationLongitude) {
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

//    public String getLocnAddr1() {
//        return locnAddr1;
//    }
//
//    public void setLocnAddr1(String locnAddr1) {
//        this.locnAddr1 = locnAddr1;
//    }
//
//    public String getLocnAddr2() {
//        return locnAddr2;
//    }
//
//    public void setLocnAddr2(String locnAddr2) {
//        this.locnAddr2 = locnAddr2;
//    }
//
//    public String getLocnSuburb() {
//        return locnSuburb;
//    }
//
//    public void setLocnSuburb(String locnSuburb) {
//        this.locnSuburb = locnSuburb;
//    }
//
//    public String getLocnPostCode() {
//        return locnPostCode;
//    }
//
//    public void setLocnPostCode(String locnPostCode) {
//        this.locnPostCode = locnPostCode;
//    }
//
//    public String getLocnPhone() {
//        return locnPhone;
//    }

//    public void setLocnPhone(String locnPhone) {
//        this.locnPhone = locnPhone;
//    }

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

//    public String getContactEmailAddr() {
//        return contactEmailAddr;
//    }
//
//    public void setContactEmailAddr(String contactEmailAddr) {
//        this.contactEmailAddr = contactEmailAddr;
//    }

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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public BigInteger getLocnCompanyNbr() {
        return locnCompanyNbr;
    }

    public void setLocnCompanyNbr(BigInteger locnCompanyNbr) {
        this.locnCompanyNbr = locnCompanyNbr;
    }

    public BigInteger getLocnBusinessNbr() {
        return locnBusinessNbr;
    }

    public void setLocnBusinessNbr(BigInteger locnBusinessNbr) {
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

    public Timestamp getStoreOpenDate() {
        return storeOpenDate;
    }

    public void setStoreOpenDate(Timestamp storeOpenDate) {
        this.storeOpenDate = storeOpenDate;
    }

    public Timestamp getStoreCloseDate() {
        return storeCloseDate;
    }

    public void setStoreCloseDate(Timestamp storeCloseDate) {
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

    public void setCrcInd(String  crcInd) {
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

    public List<StoreAddress> getStoreAddressList() {
        return storeAddressList;
    }

    public void setReplacementStore(List<StoreAddress> replacementStore) {
        this.storeAddressList = storeAddressList;
    }

    @JsonAnyGetter
    public Map<String, String> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, String value) {
        this.additionalProperties.put(name, value);
    }

}

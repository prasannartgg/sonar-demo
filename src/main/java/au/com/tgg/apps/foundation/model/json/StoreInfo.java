package au.com.tgg.apps.foundation.model.json;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Location
 * <p>
 * This is Location
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)

public class StoreInfo extends JsonHeader {
    @JsonProperty("TECHONE_FLD1")
    private String techoneFld1;
    @JsonProperty("LONG_DESCR")
    private String longDescr;
    @JsonProperty("TECHONE_FLD6")
    private Integer techoneFld6;
    @JsonProperty("TECHONE_FLD5")
    private Integer techoneFld5;
    @JsonProperty("EMAIL_ADDR_NAME")
    private String emailAddrName;
    @JsonProperty("TECHONE_FLD8")
    private Integer techoneFld8;
    @JsonProperty("STORE_CLOSE_DATEI")
    private String storeCloseDatei;
    @JsonProperty("TECHONE_FLD7")
    private String techoneFld7;
    @JsonProperty("SYSTID")
    private Integer systid;
    @JsonProperty("LAST_MOD_TIMEI")
    private Integer lastModTimei;
    @JsonProperty("ADDR_STATE")
    private String addrState;
    @JsonProperty("PRC_LEVEL")
    private Integer prcLevel;
    @JsonProperty("VERS")
    private Integer vers;
    @JsonProperty("POST_CODE")
    private String postCode;
    @JsonProperty("LAST_MOD_WINDOW")
    private String lastModWindow;
    @JsonProperty("EXTERN_REF1")
    private String externRef1;
    @JsonProperty("PRCBK_NAME")
    private String prcbkName;
    @JsonProperty("CRTERM")
    private String crterm;
    @JsonProperty("LOCN_CUST_ACCT_IND")
    private String locnCustAcctInd;
    @JsonProperty("LOCN_COMPANY_NBR")
    private String locnCompanyNbr;
    @JsonProperty("LOCN_LON")
    private Double locnLon;
    @JsonProperty("COMPANY_NAME")
    private String companyName;
    @JsonProperty("STORE_OPEN_DATEI")
    private String storeOpenDatei;
    @JsonProperty("WEB_READY")
    private String webReady;
    @JsonProperty("TIME_ZONE_IND")
    private String timeZoneInd;
    @JsonProperty("LOCN_BUSINESS_NBR")
    private String locnBusinessNbr;
    @JsonProperty("CRUSER")
    private String cruser;
    @JsonProperty("LOCN_NBR")
    private Integer locnNbr;
    @JsonProperty("TRADING_CUTOFF_TIMEI")
    private Integer tradingCutoffTimei;
    @JsonProperty("DESCR")
    private String descr;
    @JsonProperty("FAX_NBR")
    private String faxNbr;
    @JsonProperty("WHOUSE_LOCN_IND")
    private String whouseLocnInd;
    @JsonProperty("INV_NAME")
    private String invName;
    @JsonProperty("CUST_REG_NAME")
    private String custRegName;
    @JsonProperty("CLG_CODE")
    private String clgCode;
    @JsonProperty("CRDATEI")
    private String crdatei;
    @JsonProperty("LAST_MOD_USER")
    private String lastModUser;
    @JsonProperty("POS_SYS_NAME")
    private String posSysName;
    @JsonProperty("ADDR1")
    private String addr1;
    @JsonProperty("ADDR2")
    private String addr2;
    @JsonProperty("CRWINDOW")
    private String crwindow;
    @JsonProperty("operations")
    private JsonHeader operations;
    @JsonProperty("TIME_ZONE_INDEX")
    private Integer timeZoneIndex;
    @JsonProperty("ALLOW_PICKUP")
    private String allowPickup;
    @JsonProperty("LOCN_LAT")
    private Double locnLat;
    @JsonProperty("LAST_MOD_DATEI")
    private String lastModDatei;
    @JsonProperty("CONTACT_DETAILS")
    private String contactDetails;
    @JsonProperty("LAST_MOD_TERM")
    private String lastModTerm;
    @JsonProperty("ADDR_CITY")
    private String addrCity;
    @JsonProperty("LOCN_NAME")
    private String locnName;
    @JsonProperty("PHONE_NBR")
    private String phoneNbr;
    @JsonProperty("CRTIMEI")
    private Integer crtimei;
    @JsonProperty("ASSOC_LOCN_IND")
    private String assocLocnInd;
    @JsonProperty("CONTACT_FNAMES")
    private String contactFnames;
    @JsonProperty("CONTACT_NAME")
    private String contactName;
    @JsonProperty("CONTACT_TITLE")
    private String contactTitle;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("TECHONE_FLD1")
    public String getTechoneFld1() {
        return techoneFld1;
    }

    @JsonProperty("TECHONE_FLD1")
    public void setTechoneFld1(String techoneFld1) {
        this.techoneFld1 = techoneFld1;
    }

    @JsonProperty("LONG_DESCR")
    public String getLongDescr() {
        return longDescr;
    }

    @JsonProperty("LONG_DESCR")
    public void setLongDescr(String longDescr) {
        this.longDescr = longDescr;
    }

    @JsonProperty("TECHONE_FLD6")
    public Integer getTechoneFld6() {
        return techoneFld6;
    }

    @JsonProperty("TECHONE_FLD6")
    public void setTechoneFld6(Integer techoneFld6) {
        this.techoneFld6 = techoneFld6;
    }

    @JsonProperty("TECHONE_FLD5")
    public Integer getTechoneFld5() {
        return techoneFld5;
    }

    @JsonProperty("TECHONE_FLD5")
    public void setTechoneFld5(Integer techoneFld5) {
        this.techoneFld5 = techoneFld5;
    }

    @JsonProperty("EMAIL_ADDR_NAME")
    public String getEmailAddrName() {
        return emailAddrName;
    }

    @JsonProperty("EMAIL_ADDR_NAME")
    public void setEmailAddrName(String emailAddrName) {
        this.emailAddrName = emailAddrName;
    }

    @JsonProperty("TECHONE_FLD8")
    public Integer getTechoneFld8() {
        return techoneFld8;
    }

    @JsonProperty("TECHONE_FLD8")
    public void setTechoneFld8(Integer techoneFld8) {
        this.techoneFld8 = techoneFld8;
    }

    @JsonProperty("STORE_CLOSE_DATEI")
    public String getStoreCloseDatei() {
        return storeCloseDatei;
    }

    @JsonProperty("STORE_CLOSE_DATEI")
    public void setStoreCloseDatei(String storeCloseDatei) {
        this.storeCloseDatei = storeCloseDatei;
    }

    @JsonProperty("TECHONE_FLD7")
    public String getTechoneFld7() {
        return techoneFld7;
    }

    @JsonProperty("TECHONE_FLD7")
    public void setTechoneFld7(String techoneFld7) {
        this.techoneFld7 = techoneFld7;
    }

    @JsonProperty("SYSTID")
    public Integer getSystid() {
        return systid;
    }

    @JsonProperty("SYSTID")
    public void setSystid(Integer systid) {
        this.systid = systid;
    }

    @JsonProperty("LAST_MOD_TIMEI")
    public Integer getLastModTimei() {
        return lastModTimei;
    }

    @JsonProperty("LAST_MOD_TIMEI")
    public void setLastModTimei(Integer lastModTimei) {
        this.lastModTimei = lastModTimei;
    }

    @JsonProperty("ADDR_STATE")
    public String getAddrState() {
        return addrState;
    }

    @JsonProperty("ADDR_STATE")
    public void setAddrState(String addrState) {
        this.addrState = addrState;
    }

    @JsonProperty("PRC_LEVEL")
    public Integer getPrcLevel() {
        return prcLevel;
    }

    @JsonProperty("PRC_LEVEL")
    public void setPrcLevel(Integer prcLevel) {
        this.prcLevel = prcLevel;
    }

    @JsonProperty("VERS")
    public Integer getVers() {
        return vers;
    }

    @JsonProperty("VERS")
    public void setVers(Integer vers) {
        this.vers = vers;
    }

    @JsonProperty("POST_CODE")
    public String getPostCode() {
        return postCode;
    }

    @JsonProperty("POST_CODE")
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @JsonProperty("LAST_MOD_WINDOW")
    public String getLastModWindow() {
        return lastModWindow;
    }

    @JsonProperty("LAST_MOD_WINDOW")
    public void setLastModWindow(String lastModWindow) {
        this.lastModWindow = lastModWindow;
    }

    @JsonProperty("EXTERN_REF1")
    public String getExternRef1() {
        return externRef1;
    }

    @JsonProperty("EXTERN_REF1")
    public void setExternRef1(String externRef1) {
        this.externRef1 = externRef1;
    }

    @JsonProperty("PRCBK_NAME")
    public String getPrcbkName() {
        return prcbkName;
    }

    @JsonProperty("PRCBK_NAME")
    public void setPrcbkName(String prcbkName) {
        this.prcbkName = prcbkName;
    }

    @JsonProperty("CRTERM")
    public String getCrterm() {
        return crterm;
    }

    @JsonProperty("CRTERM")
    public void setCrterm(String crterm) {
        this.crterm = crterm;
    }

    @JsonProperty("LOCN_CUST_ACCT_IND")
    public String getLocnCustAcctInd() {
        return locnCustAcctInd;
    }

    @JsonProperty("LOCN_CUST_ACCT_IND")
    public void setLocnCustAcctInd(String locnCustAcctInd) {
        this.locnCustAcctInd = locnCustAcctInd;
    }

    @JsonProperty("LOCN_COMPANY_NBR")
    public String getLocnCompanyNbr() {
        return locnCompanyNbr;
    }

    @JsonProperty("LOCN_COMPANY_NBR")
    public void setLocnCompanyNbr(String locnCompanyNbr) {
        this.locnCompanyNbr = locnCompanyNbr;
    }

    @JsonProperty("LOCN_LON")
    public Double getLocnLon() {
        return locnLon;
    }

    @JsonProperty("LOCN_LON")
    public void setLocnLon(Double locnLon) {
        this.locnLon = locnLon;
    }

    @JsonProperty("COMPANY_NAME")
    public String getCompanyName() {
        return companyName;
    }

    @JsonProperty("COMPANY_NAME")
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @JsonProperty("STORE_OPEN_DATEI")
    public String getStoreOpenDatei() {
        return storeOpenDatei;
    }

    @JsonProperty("STORE_OPEN_DATEI")
    public void setStoreOpenDatei(String storeOpenDatei) {
        this.storeOpenDatei = storeOpenDatei;
    }

    @JsonProperty("WEB_READY")
    public String getWebReady() {
        return webReady;
    }

    @JsonProperty("WEB_READY")
    public void setWebReady(String webReady) {
        this.webReady = webReady;
    }

    @JsonProperty("TIME_ZONE_IND")
    public String getTimeZoneInd() {
        return timeZoneInd;
    }

    @JsonProperty("TIME_ZONE_IND")
    public void setTimeZoneInd(String timeZoneInd) {
        this.timeZoneInd = timeZoneInd;
    }

    @JsonProperty("LOCN_BUSINESS_NBR")
    public String getLocnBusinessNbr() {
        return locnBusinessNbr;
    }

    @JsonProperty("LOCN_BUSINESS_NBR")
    public void setLocnBusinessNbr(String locnBusinessNbr) {
        this.locnBusinessNbr = locnBusinessNbr;
    }

    @JsonProperty("CRUSER")
    public String getCruser() {
        return cruser;
    }

    @JsonProperty("CRUSER")
    public void setCruser(String cruser) {
        this.cruser = cruser;
    }

    @JsonProperty("LOCN_NBR")
    public Integer getLocnNbr() {
        return locnNbr;
    }

    @JsonProperty("LOCN_NBR")
    public void setLocnNbr(Integer locnNbr) {
        this.locnNbr = locnNbr;
    }

    @JsonProperty("TRADING_CUTOFF_TIMEI")
    public Integer getTradingCutoffTimei() {
        return tradingCutoffTimei;
    }

    @JsonProperty("TRADING_CUTOFF_TIMEI")
    public void setTradingCutoffTimei(Integer tradingCutoffTimei) {
        this.tradingCutoffTimei = tradingCutoffTimei;
    }

    @JsonProperty("DESCR")
    public String getDescr() {
        return descr;
    }

    @JsonProperty("DESCR")
    public void setDescr(String descr) {
        this.descr = descr;
    }

    @JsonProperty("FAX_NBR")
    public String getFaxNbr() {
        return faxNbr;
    }

    @JsonProperty("FAX_NBR")
    public void setFaxNbr(String faxNbr) {
        this.faxNbr = faxNbr;
    }

    @JsonProperty("WHOUSE_LOCN_IND")
    public String getWhouseLocnInd() {
        return whouseLocnInd;
    }

    @JsonProperty("WHOUSE_LOCN_IND")
    public void setWhouseLocnInd(String whouseLocnInd) {
        this.whouseLocnInd = whouseLocnInd;
    }

    @JsonProperty("INV_NAME")
    public String getInvName() {
        return invName;
    }

    @JsonProperty("INV_NAME")
    public void setInvName(String invName) {
        this.invName = invName;
    }

    @JsonProperty("CUST_REG_NAME")
    public String getCustRegName() {
        return custRegName;
    }

    @JsonProperty("CUST_REG_NAME")
    public void setCustRegName(String custRegName) {
        this.custRegName = custRegName;
    }

    @JsonProperty("CLG_CODE")
    public String getClgCode() {
        return clgCode;
    }

    @JsonProperty("CLG_CODE")
    public void setClgCode(String clgCode) {
        this.clgCode = clgCode;
    }

    @JsonProperty("CRDATEI")
    public String getCrdatei() {
        return crdatei;
    }

    @JsonProperty("CRDATEI")
    public void setCrdatei(String crdatei) {
        this.crdatei = crdatei;
    }

    @JsonProperty("LAST_MOD_USER")
    public String getLastModUser() {
        return lastModUser;
    }

    @JsonProperty("LAST_MOD_USER")
    public void setLastModUser(String lastModUser) {
        this.lastModUser = lastModUser;
    }

    @JsonProperty("POS_SYS_NAME")
    public String getPosSysName() {
        return posSysName;
    }

    @JsonProperty("POS_SYS_NAME")
    public void setPosSysName(String posSysName) {
        this.posSysName = posSysName;
    }

    @JsonProperty("ADDR1")
    public String getAddr1() {
        return addr1;
    }

    @JsonProperty("ADDR1")
    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    @JsonProperty("ADDR2")
    public String getAddr2() {
        return addr2;
    }

    @JsonProperty("ADDR2")
    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    @JsonProperty("CRWINDOW")
    public String getCrwindow() {
        return crwindow;
    }

    @JsonProperty("CRWINDOW")
    public void setCrwindow(String crwindow) {
        this.crwindow = crwindow;
    }

    @JsonProperty("operations")
    public JsonHeader getOperations() {
        return operations;
    }

    @JsonProperty("operations")
    public void setOperations(JsonHeader operations) {
        this.operations = operations;
    }

    @JsonProperty("TIME_ZONE_INDEX")
    public Integer getTimeZoneIndex() {
        return timeZoneIndex;
    }

    @JsonProperty("TIME_ZONE_INDEX")
    public void setTimeZoneIndex(Integer timeZoneIndex) {
        this.timeZoneIndex = timeZoneIndex;
    }

    @JsonProperty("ALLOW_PICKUP")
    public String getAllowPickup() {
        return allowPickup;
    }

    @JsonProperty("ALLOW_PICKUP")
    public void setAllowPickup(String allowPickup) {
        this.allowPickup = allowPickup;
    }

    @JsonProperty("LOCN_LAT")
    public Double getLocnLat() {
        return locnLat;
    }

    @JsonProperty("LOCN_LAT")
    public void setLocnLat(Double locnLat) {
        this.locnLat = locnLat;
    }

    @JsonProperty("LAST_MOD_DATEI")
    public String getLastModDatei() {
        return lastModDatei;
    }

    @JsonProperty("LAST_MOD_DATEI")
    public void setLastModDatei(String lastModDatei) {
        this.lastModDatei = lastModDatei;
    }

    @JsonProperty("CONTACT_DETAILS")
    public String getContactDetails() {
        return contactDetails;
    }

    @JsonProperty("CONTACT_DETAILS")
    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    @JsonProperty("LAST_MOD_TERM")
    public String getLastModTerm() {
        return lastModTerm;
    }

    @JsonProperty("LAST_MOD_TERM")
    public void setLastModTerm(String lastModTerm) {
        this.lastModTerm = lastModTerm;
    }

    @JsonProperty("ADDR_CITY")
    public String getAddrCity() {
        return addrCity;
    }

    @JsonProperty("ADDR_CITY")
    public void setAddrCity(String addrCity) {
        this.addrCity = addrCity;
    }

    @JsonProperty("LOCN_NAME")
    public String getLocnName() {
        return locnName;
    }

    @JsonProperty("LOCN_NAME")
    public void setLocnName(String locnName) {
        this.locnName = locnName;
    }

    @JsonProperty("PHONE_NBR")
    public String getPhoneNbr() {
        return phoneNbr;
    }

    @JsonProperty("PHONE_NBR")
    public void setPhoneNbr(String phoneNbr) {
        this.phoneNbr = phoneNbr;
    }

    @JsonProperty("CRTIMEI")
    public Integer getCrtimei() {
        return crtimei;
    }

    @JsonProperty("CRTIMEI")
    public void setCrtimei(Integer crtimei) {
        this.crtimei = crtimei;
    }

    @JsonProperty("ASSOC_LOCN_IND")
    public String getAssocLocnInd() {
        return assocLocnInd;
    }

    @JsonProperty("ASSOC_LOCN_IND")
    public void setAssocLocnInd(String assocLocnInd) {
        this.assocLocnInd = assocLocnInd;
    }

    @JsonProperty("CONTACT_FNAMES")
    public String getContactFnames() {
        return contactFnames;
    }

    @JsonProperty("CONTACT_FNAMES")
    public void setContactFnames(String contactFnames) {
        this.contactFnames = contactFnames;
    }

    @JsonProperty("CONTACT_NAME")
    public String getContactName() {
        return contactName;
    }

    @JsonProperty("CONTACT_NAME")
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @JsonProperty("CONTACT_TITLE")
    public String getContactTitle() {
        return contactTitle;
    }

    @JsonProperty("CONTACT_TITLE")
    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}

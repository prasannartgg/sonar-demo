package au.com.tgg.apps.foundation.model.json;

import au.com.tgg.apps.foundation.util.JsonDateDeserializer;
import au.com.tgg.apps.foundation.util.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "TECHONE_FLD2",
        "PORD_COM_VAL",
        "TECHONE_FLD1",
        "LAST_SALE_DATEI",
        "ACTIVE_REPLEN_IND",
        "TECHONE_FLD4",
        "TECHONE_FLD3",
        "SUP_CODE",
        "ACTIVE_PURCH_IND",
        "SUP_PROD_NBR",
        "PICK_COM_QTY",
        "LOCKED_QTY",
        "VERS",
        "ORIDE_ACCT_IND",
        "LAST_MOD_WINDOW",
        "INBOUND_QTY",
        "SYS_TID",
        "WEB_COM_QTY",
        "ACTIVE_TRSFR_IND",
        "CRTERM",
        "MAX_LVL_QTY",
        "PLPC_PRC",
        "PRD_NBR",
        "ACTIVE_SAL_IND",
        "SEM_PRC",
        "LOCL_PROD_ID",
        "ACTIVE_PROD_IND",
        "INBOUND_VAL",
        "OUTBOUND_QTY",
        "HOLD_COM_QTY",
        "WEB_READY",
        "FULFILL_QTY",
        "CRUSER",
        "LOCN_NBR",
        "IN_PEND_COM_QTY",
        "PORD_COM_QTY",
        "LAST_TRSFR_IN_DATE",
        "OUTBOUND_VAL",
        "ONHAND_VAL",
        "CRTIME",
        "LAST_MOD_TIME",
        "CRDATEI",
        "TICKET_PRC",
        "LAST_TRSFR_IN_QTY",
        "LAST_MOD_USER",
        "LAST_RECPT_QTY",
        "ONHAND_AVG_VAL",
        "RECORD_LVL_QTY",
        "CRWINDOW",
        "LAST_SALE_VAL",
        "MIN_LVL_QTY",
        "ACTIVE_ISS_IND",
        "LAST_MOD_DATEI",
        "LAST_RECPT_VAL",
        "LAST_SALE_QTY",
        "LAST_MOD_TERM",
        "LAST_TRSFR_IN_VAL",
        "BKORD_COM_QTY",
        "ONHAND_QTY",
        "REBATE_VALUE",
        "WEB_MIN_QTY",
        "operations"
})
public class StockInfo {

    @JsonProperty("TECHONE_FLD2")
    private String techoneFld2;
    @JsonProperty("PORD_COM_VAL")
    private Double pordComVal;
    @JsonProperty("TECHONE_FLD1")
    private String techoneFld1;
    @JsonProperty("LAST_SALE_DATEI")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDate lastSaleDatei;
    @JsonProperty("ACTIVE_REPLEN_IND")
    private String activeReplenInd;
    @JsonProperty("TECHONE_FLD4")
    private BigDecimal techoneFld4;
    @JsonProperty("TECHONE_FLD3")
    private BigDecimal techoneFld3;
    @JsonProperty("SUP_CODE")
    private BigDecimal supCode;
    @JsonProperty("ACTIVE_PURCH_IND")
    private String activePurchInd;
    @JsonProperty("SUP_PROD_NBR")
    private String supProdNbr;
    @JsonProperty("PICK_COM_QTY")
    private BigDecimal pickComQty;
    @JsonProperty("LOCKED_QTY")
    private BigDecimal lockedQty;
    @JsonProperty("VERS")
    private BigDecimal vers;
    @JsonProperty("ORIDE_ACCT_IND")
    private String orideAcctInd;
    @JsonProperty("LAST_MOD_WINDOW")
    private String lastModWindow;
    @JsonProperty("INBOUND_QTY")
    private BigDecimal inboundQty;
    @JsonProperty("SYS_TID")
    private BigDecimal sysTid;
    @JsonProperty("WEB_COM_QTY")
    private BigDecimal webComQty;
    @JsonProperty("ACTIVE_TRSFR_IND")
    private String activeTrsfrInd;
    @JsonProperty("CRTERM")
    private String crterm;
    @JsonProperty("MAX_LVL_QTY")
    private BigDecimal maxLvlQty;
    @JsonProperty("PLPC_PRC")
    private BigDecimal plpcPrc;
    @JsonProperty("PRD_NBR")
    private String prodNbr;
    @JsonProperty("ACTIVE_SAL_IND")
    private String activeSalInd;
    @JsonProperty("SEM_PRC")
    private BigDecimal semPrc;
    @JsonProperty("LOCL_PROD_ID")
    private BigDecimal loclProdId;
    @JsonProperty("ACTIVE_PROD_IND")
    private String activeProdInd;
    @JsonProperty("INBOUND_VAL")
    private Double inboundVal;
    @JsonProperty("OUTBOUND_QTY")
    private BigDecimal outboundQty;
    @JsonProperty("HOLD_COM_QTY")
    private BigDecimal holdComQty;
    @JsonProperty("WEB_READY")
    private String webReady;
    @JsonProperty("FULFILL_QTY")
    private BigDecimal fulfillQty;
    @JsonProperty("CRUSER")
    private String cruser;
    @JsonProperty("LOCN_NBR")
    private Long locnNbr;
    @JsonProperty("IN_PEND_COM_QTY")
    private BigDecimal inPendComQty;
    @JsonProperty("PORD_COM_QTY")
    private BigDecimal pordComQty;
    @JsonProperty("LAST_TRSFR_IN_DATE")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDate lastTrsfrInDate;
    @JsonProperty("OUTBOUND_VAL")
    private Double outboundVal;
    @JsonProperty("ONHAND_VAL")
    private Double onhandVal;
    @JsonProperty("CRTIME")
    private BigDecimal crtime;
    @JsonProperty("LAST_MOD_TIME")
    private Long lastModTime;
    @JsonProperty("CRDATEI")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDate crdatei;
    @JsonProperty("TICKET_PRC")
    private BigDecimal ticketPrc;
    @JsonProperty("LAST_TRSFR_IN_QTY")
    private BigDecimal lastTrsfrInQty;
    @JsonProperty("LAST_MOD_USER")
    private String lastModUser;
    @JsonProperty("LAST_RECPT_QTY")
    private BigDecimal lastRecptQty;
    @JsonProperty("ONHAND_AVG_VAL")
    private BigDecimal onhandAvgVal;
    @JsonProperty("RECORD_LVL_QTY")
    private BigDecimal recordLvlQty;
    @JsonProperty("CRWINDOW")
    private String crwindow;
    @JsonProperty("LAST_SALE_VAL")
    private Double lastSaleVal;
    @JsonProperty("MIN_LVL_QTY")
    private BigDecimal minLvlQty;
    @JsonProperty("ACTIVE_ISS_IND")
    private String activeIssInd;
    @JsonProperty("LAST_MOD_DATEI")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDate lastModDatei;
    @JsonProperty("LAST_RECPT_VAL")
    private Double lastRecptVal;
    @JsonProperty("LAST_RECPT_DATEI")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDate lastRecptDatei;
    @JsonProperty("LAST_SALE_QTY")
    private BigDecimal lastSaleQty;
    @JsonProperty("LAST_MOD_TERM")
    private String lastModTerm;
    @JsonProperty("LAST_TRSFR_IN_VAL")
    private Double lastTrsfrInVal;
    @JsonProperty("BKORD_COM_QTY")
    private BigDecimal bkordComQty;
    @JsonProperty("ONHAND_QTY")
    private BigDecimal onhandQty;
    @JsonProperty("REBATE_VALUE")
    private BigDecimal rebateValue;
    @JsonProperty("WEB_MIN_QTY")
    private BigDecimal webMinQty;

    @JsonProperty("TECHONE_FLD2")
    public String getTechoneFld2() {
        return techoneFld2;
    }

    @JsonProperty("TECHONE_FLD2")
    public void setTechoneFld2(String techoneFld2) {
        this.techoneFld2 = techoneFld2;
    }

    @JsonProperty("PORD_COM_VAL")
    public Double getPordComVal() {
        return pordComVal;
    }

    @JsonProperty("PORD_COM_VAL")
    public void setPordComVal(Double pordComVal) {
        this.pordComVal = pordComVal;
    }

    @JsonProperty("TECHONE_FLD1")
    public String getTechoneFld1() {
        return techoneFld1;
    }

    @JsonProperty("TECHONE_FLD1")
    public void setTechoneFld1(String techoneFld1) {
        this.techoneFld1 = techoneFld1;
    }

    @JsonProperty("LAST_SALE_DATEI")
    public LocalDate getLastSaleDatei() {
        return lastSaleDatei;
    }

    @JsonProperty("LAST_SALE_DATEI")
    public void setLastSaleDatei(LocalDate lastSaleDatei) {
        this.lastSaleDatei = lastSaleDatei;
    }

    @JsonProperty("ACTIVE_REPLEN_IND")
    public String getActiveReplenInd() {
        return activeReplenInd;
    }

    @JsonProperty("ACTIVE_REPLEN_IND")
    public void setActiveReplenInd(String activeReplenInd) {
        this.activeReplenInd = activeReplenInd;
    }

    @JsonProperty("TECHONE_FLD4")
    public BigDecimal getTechoneFld4() {
        return techoneFld4;
    }

    @JsonProperty("TECHONE_FLD4")
    public void setTechoneFld4(BigDecimal techoneFld4) {
        this.techoneFld4 = techoneFld4;
    }

    @JsonProperty("TECHONE_FLD3")
    public BigDecimal getTechoneFld3() {
        return techoneFld3;
    }

    @JsonProperty("TECHONE_FLD3")
    public void setTechoneFld3(BigDecimal techoneFld3) {
        this.techoneFld3 = techoneFld3;
    }

    @JsonProperty("SUP_CODE")
    public BigDecimal getSupCode() {
        return supCode;
    }

    @JsonProperty("SUP_CODE")
    public void setSupCode(BigDecimal supCode) {
        this.supCode = supCode;
    }

    @JsonProperty("ACTIVE_PURCH_IND")
    public String getActivePurchInd() {
        return activePurchInd;
    }

    @JsonProperty("ACTIVE_PURCH_IND")
    public void setActivePurchInd(String activePurchInd) {
        this.activePurchInd = activePurchInd;
    }

    @JsonProperty("SUP_PROD_NBR")
    public String getSupProdNbr() {
        return supProdNbr;
    }

    @JsonProperty("SUP_PROD_NBR")
    public void setSupProdNbr(String supProdNbr) {
        this.supProdNbr = supProdNbr;
    }

    @JsonProperty("PICK_COM_QTY")
    public BigDecimal getPickComQty() {
        return pickComQty;
    }

    @JsonProperty("PICK_COM_QTY")
    public void setPickComQty(BigDecimal pickComQty) {
        this.pickComQty = pickComQty;
    }

    @JsonProperty("LOCKED_QTY")
    public BigDecimal getLockedQty() {
        return lockedQty;
    }

    @JsonProperty("LOCKED_QTY")
    public void setLockedQty(BigDecimal lockedQty) {
        this.lockedQty = lockedQty;
    }

    @JsonProperty("VERS")
    public BigDecimal getVers() {
        return vers;
    }

    @JsonProperty("VERS")
    public void setVers(BigDecimal vers) {
        this.vers = vers;
    }

    @JsonProperty("ORIDE_ACCT_IND")
    public String getOrideAcctInd() {
        return orideAcctInd;
    }

    @JsonProperty("ORIDE_ACCT_IND")
    public void setOrideAcctInd(String orideAcctInd) {
        this.orideAcctInd = orideAcctInd;
    }

    @JsonProperty("LAST_MOD_WINDOW")
    public String getLastModWindow() {
        return lastModWindow;
    }

    @JsonProperty("LAST_MOD_WINDOW")
    public void setLastModWindow(String lastModWindow) {
        this.lastModWindow = lastModWindow;
    }

    @JsonProperty("INBOUND_QTY")
    public BigDecimal getInboundQty() {
        return inboundQty;
    }

    @JsonProperty("INBOUND_QTY")
    public void setInboundQty(BigDecimal inboundQty) {
        this.inboundQty = inboundQty;
    }

    @JsonProperty("SYS_TID")
    public BigDecimal getSysTid() {
        return sysTid;
    }

    @JsonProperty("SYS_TID")
    public void setSysTid(BigDecimal sysTid) {
        this.sysTid = sysTid;
    }

    @JsonProperty("WEB_COM_QTY")
    public BigDecimal getWebComQty() {
        return webComQty;
    }

    @JsonProperty("WEB_COM_QTY")
    public void setWebComQty(BigDecimal webComQty) {
        this.webComQty = webComQty;
    }

    @JsonProperty("ACTIVE_TRSFR_IND")
    public String getActiveTrsfrInd() {
        return activeTrsfrInd;
    }

    @JsonProperty("ACTIVE_TRSFR_IND")
    public void setActiveTrsfrInd(String activeTrsfrInd) {
        this.activeTrsfrInd = activeTrsfrInd;
    }

    @JsonProperty("CRTERM")
    public String getCrterm() {
        return crterm;
    }

    @JsonProperty("CRTERM")
    public void setCrterm(String crterm) {
        this.crterm = crterm;
    }

    @JsonProperty("MAX_LVL_QTY")
    public BigDecimal getMaxLvlQty() {
        return maxLvlQty;
    }

    @JsonProperty("MAX_LVL_QTY")
    public void setMaxLvlQty(BigDecimal maxLvlQty) {
        this.maxLvlQty = maxLvlQty;
    }

    @JsonProperty("PLPC_PRC")
    public BigDecimal getPlpcPrc() {
        return plpcPrc;
    }

    @JsonProperty("PLPC_PRC")
    public void setPlpcPrc(BigDecimal plpcPrc) {
        this.plpcPrc = plpcPrc;
    }

    @JsonProperty("PRD_NBR")
    public String getProdNbr() {
        return prodNbr;
    }

    @JsonProperty("PRD_NBR")
    public void setProdNbr(String prodNbr) {
        this.prodNbr = prodNbr;
    }

    @JsonProperty("ACTIVE_SAL_IND")
    public String getActiveSalInd() {
        return activeSalInd;
    }

    @JsonProperty("ACTIVE_SAL_IND")
    public void setActiveSalInd(String activeSalInd) {
        this.activeSalInd = activeSalInd;
    }

    @JsonProperty("SEM_PRC")
    public BigDecimal getSemPrc() {
        return semPrc;
    }

    @JsonProperty("SEM_PRC")
    public void setSemPrc(BigDecimal semPrc) {
        this.semPrc = semPrc;
    }

    @JsonProperty("LOCL_PROD_ID")
    public BigDecimal getLoclProdId() {
        return loclProdId;
    }

    @JsonProperty("LOCL_PROD_ID")
    public void setLoclProdId(BigDecimal loclProdId) {
        this.loclProdId = loclProdId;
    }

    @JsonProperty("ACTIVE_PROD_IND")
    public String getActiveProdInd() {
        return activeProdInd;
    }

    @JsonProperty("ACTIVE_PROD_IND")
    public void setActiveProdInd(String activeProdInd) {
        this.activeProdInd = activeProdInd;
    }

    @JsonProperty("INBOUND_VAL")
    public Double getInboundVal() {
        return inboundVal;
    }

    @JsonProperty("INBOUND_VAL")
    public void setInboundVal(Double inboundVal) {
        this.inboundVal = inboundVal;
    }

    @JsonProperty("OUTBOUND_QTY")
    public BigDecimal getOutboundQty() {
        return outboundQty;
    }

    @JsonProperty("OUTBOUND_QTY")
    public void setOutboundQty(BigDecimal outboundQty) {
        this.outboundQty = outboundQty;
    }

    @JsonProperty("HOLD_COM_QTY")
    public BigDecimal getHoldComQty() {
        return holdComQty;
    }

    @JsonProperty("HOLD_COM_QTY")
    public void setHoldComQty(BigDecimal holdComQty) {
        this.holdComQty = holdComQty;
    }

    @JsonProperty("WEB_READY")
    public String getWebReady() {
        return webReady;
    }

    @JsonProperty("WEB_READY")
    public void setWebReady(String webReady) {
        this.webReady = webReady;
    }

    @JsonProperty("FULFILL_QTY")
    public BigDecimal getFulfillQty() {
        return fulfillQty;
    }

    @JsonProperty("FULFILL_QTY")
    public void setFulfillQty(BigDecimal fulfillQty) {
        this.fulfillQty = fulfillQty;
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
    public Long getLocnNbr() {
        return locnNbr;
    }

    @JsonProperty("LOCN_NBR")
    public void setLocnNbr(Long locnNbr) {
        this.locnNbr = locnNbr;
    }

    @JsonProperty("IN_PEND_COM_QTY")
    public BigDecimal getInPendComQty() {
        return inPendComQty;
    }

    @JsonProperty("IN_PEND_COM_QTY")
    public void setInPendComQty(BigDecimal inPendComQty) {
        this.inPendComQty = inPendComQty;
    }

    @JsonProperty("PORD_COM_QTY")
    public BigDecimal getPordComQty() {
        return pordComQty;
    }

    @JsonProperty("PORD_COM_QTY")
    public void setPordComQty(BigDecimal pordComQty) {
        this.pordComQty = pordComQty;
    }

    @JsonProperty("LAST_TRSFR_IN_DATE")
    public LocalDate getLastTrsfrInDate() {
        return lastTrsfrInDate;
    }

    @JsonProperty("LAST_TRSFR_IN_DATE")
    public void setLastTrsfrInDate(LocalDate lastTrsfrInDate) {
        this.lastTrsfrInDate = lastTrsfrInDate;
    }

    @JsonProperty("OUTBOUND_VAL")
    public Double getOutboundVal() {
        return outboundVal;
    }

    @JsonProperty("OUTBOUND_VAL")
    public void setOutboundVal(Double outboundVal) {
        this.outboundVal = outboundVal;
    }

    @JsonProperty("ONHAND_VAL")
    public Double getOnhandVal() {
        return onhandVal;
    }

    @JsonProperty("ONHAND_VAL")
    public void setOnhandVal(Double onhandVal) {
        this.onhandVal = onhandVal;
    }

    @JsonProperty("CRTIME")
    public BigDecimal getCrtime() {
        return crtime;
    }

    @JsonProperty("CRTIME")
    public void setCrtime(BigDecimal crtime) {
        this.crtime = crtime;
    }

    @JsonProperty("LAST_MOD_TIME")
    public Long getLastModTime() {
        return lastModTime;
    }

    @JsonProperty("LAST_MOD_TIME")
    public void setLastModTime(Long lastModTime) {
        this.lastModTime = lastModTime;
    }

    @JsonProperty("CRDATEI")
    public LocalDate getCrdatei() {
        return crdatei;
    }

    @JsonProperty("CRDATEI")
    public void setCrdatei(LocalDate crdatei) {
        this.crdatei = crdatei;
    }

    @JsonProperty("TICKET_PRC")
    public BigDecimal getTicketPrc() {
        return ticketPrc;
    }

    @JsonProperty("TICKET_PRC")
    public void setTicketPrc(BigDecimal ticketPrc) {
        this.ticketPrc = ticketPrc;
    }

    @JsonProperty("LAST_TRSFR_IN_QTY")
    public BigDecimal getLastTrsfrInQty() {
        return lastTrsfrInQty;
    }

    @JsonProperty("LAST_TRSFR_IN_QTY")
    public void setLastTrsfrInQty(BigDecimal lastTrsfrInQty) {
        this.lastTrsfrInQty = lastTrsfrInQty;
    }

    @JsonProperty("LAST_MOD_USER")
    public String getLastModUser() {
        return lastModUser;
    }

    @JsonProperty("LAST_MOD_USER")
    public void setLastModUser(String lastModUser) {
        this.lastModUser = lastModUser;
    }

    @JsonProperty("LAST_RECPT_QTY")
    public BigDecimal getLastRecptQty() {
        return lastRecptQty;
    }

    @JsonProperty("LAST_RECPT_QTY")
    public void setLastRecptQty(BigDecimal lastRecptQty) {
        this.lastRecptQty = lastRecptQty;
    }

    @JsonProperty("LAST_RECPT_DATEI")
    public LocalDate getLastRecptDatei() {
        return lastRecptDatei;
    }

    @JsonProperty("LAST_RECPT_DATEI")
    public void setLastRecptDatei(LocalDate lastRecptDatei) {
        this.lastRecptDatei = lastRecptDatei;
    }

    @JsonProperty("ONHAND_AVG_VAL")
    public BigDecimal getOnhandAvgVal() {
        return onhandAvgVal;
    }

    @JsonProperty("ONHAND_AVG_VAL")
    public void setOnhandAvgVal(BigDecimal onhandAvgVal) {
        this.onhandAvgVal = onhandAvgVal;
    }

    @JsonProperty("RECORD_LVL_QTY")
    public BigDecimal getRecordLvlQty() {
        return recordLvlQty;
    }

    @JsonProperty("RECORD_LVL_QTY")
    public void setRecordLvlQty(BigDecimal recordLvlQty) {
        this.recordLvlQty = recordLvlQty;
    }

    @JsonProperty("CRWINDOW")
    public String getCrwindow() {
        return crwindow;
    }

    @JsonProperty("CRWINDOW")
    public void setCrwindow(String crwindow) {
        this.crwindow = crwindow;
    }

    @JsonProperty("LAST_SALE_VAL")
    public Double getLastSaleVal() {
        return lastSaleVal;
    }

    @JsonProperty("LAST_SALE_VAL")
    public void setLastSaleVal(Double lastSaleVal) {
        this.lastSaleVal = lastSaleVal;
    }

    @JsonProperty("MIN_LVL_QTY")
    public BigDecimal getMinLvlQty() {
        return minLvlQty;
    }

    @JsonProperty("MIN_LVL_QTY")
    public void setMinLvlQty(BigDecimal minLvlQty) {
        this.minLvlQty = minLvlQty;
    }

    @JsonProperty("ACTIVE_ISS_IND")
    public String getActiveIssInd() {
        return activeIssInd;
    }

    @JsonProperty("ACTIVE_ISS_IND")
    public void setActiveIssInd(String activeIssInd) {
        this.activeIssInd = activeIssInd;
    }

    @JsonProperty("LAST_MOD_DATEI")
    public LocalDate getLastModDatei() {

        return lastModDatei;
    }

    @JsonProperty("LAST_MOD_DATEI")
    public void setLastModDatei(LocalDate lastModDatei) {
        if(lastModDatei != null && lastModDatei.toString().length() > 10){
            lastModDatei.toString().substring(1,10);
        }
        this.lastModDatei = lastModDatei;
    }

    @JsonProperty("LAST_RECPT_VAL")
    public Double getLastRecptVal() {
        return lastRecptVal;
    }

    @JsonProperty("LAST_RECPT_VAL")
    public void setLastRecptVal(Double lastRecptVal) {
        this.lastRecptVal = lastRecptVal;
    }

    @JsonProperty("LAST_SALE_QTY")
    public BigDecimal getLastSaleQty() {
        return lastSaleQty;
    }

    @JsonProperty("LAST_SALE_QTY")
    public void setLastSaleQty(BigDecimal lastSaleQty) {
        this.lastSaleQty = lastSaleQty;
    }

    @JsonProperty("LAST_MOD_TERM")
    public String getLastModTerm() {
        return lastModTerm;
    }

    @JsonProperty("LAST_MOD_TERM")
    public void setLastModTerm(String lastModTerm) {
        this.lastModTerm = lastModTerm;
    }

    @JsonProperty("LAST_TRSFR_IN_VAL")
    public Double getLastTrsfrInVal() {
        return lastTrsfrInVal;
    }

    @JsonProperty("LAST_TRSFR_IN_VAL")
    public void setLastTrsfrInVal(Double lastTrsfrInVal) {
        this.lastTrsfrInVal = lastTrsfrInVal;
    }

    @JsonProperty("BKORD_COM_QTY")
    public BigDecimal getBkordComQty() {
        return bkordComQty;
    }

    @JsonProperty("BKORD_COM_QTY")
    public void setBkordComQty(BigDecimal bkordComQty) {
        this.bkordComQty = bkordComQty;
    }

    @JsonProperty("ONHAND_QTY")
    public BigDecimal getOnhandQty() {
        return onhandQty;
    }

    @JsonProperty("ONHAND_QTY")
    public void setOnhandQty(BigDecimal onhandQty) {
        this.onhandQty = onhandQty;
    }

    @JsonProperty("REBATE_VALUE")
    public BigDecimal getRebateValue() {
        return rebateValue;
    }

    @JsonProperty("REBATE_VALUE")
    public void setRebateValue(BigDecimal rebateValue) {
        this.rebateValue = rebateValue;
    }

    @JsonProperty("WEB_MIN_QTY")
    public BigDecimal getWebMinQty() {
        return webMinQty;
    }

    @JsonProperty("WEB_MIN_QTY")
    public void setWebMinQty(BigDecimal webMinQty) {
        this.webMinQty = webMinQty;
    }

    @JsonIgnore
    private JsonNode operationsAsNode;

    @JsonProperty("operations")
    private void setOperations(JsonNode operations) {
        this.operationsAsNode = operations;
    }

    public JsonNode getOperationsAsNode() {
        return this.operationsAsNode;
    }
}

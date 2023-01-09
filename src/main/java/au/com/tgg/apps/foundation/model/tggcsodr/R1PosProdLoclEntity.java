package au.com.tgg.apps.foundation.model.tggcsodr;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@IdClass(R1PosProdLoclId.class)
@DynamicUpdate
@Table(name = "r1pos_prod_locl", schema = "tggcsodr", catalog = "postgres")
public class R1PosProdLoclEntity {
    @Id
    @Basic
    @Column(name = "prod_nbr")
    private String prodNbr;
    @Id
    @Basic
    @Column(name = "locn_nbr")
    private Long locnNbr;
    @Basic
    @Column(name = "locl_prod_id")
    private BigDecimal loclProdId;

    @Basic
    @Column(name = "sup_code")
    private BigDecimal supCode;

    @Basic
    @Column(name = "sup_prod_nbr")
    private String supProdNbr;

    @Basic
    @Column(name = "onhand_qty")
    private BigDecimal onhandQty;

    @Basic
    @Column(name = "onhand_val")
    private Double onhandVal;

    @Basic
    @Column(name = "onhand_avg_val")
    private BigDecimal onhandAvgVal;

    @Basic
    @Column(name = "pord_com_qty")
    private BigDecimal pordComQty;

    @Basic
    @Column(name = "pord_com_val")
    private Double pordComVal;

    @Basic
    @Column(name = "bkord_com_qty")
    private BigDecimal bkordComQty;

    @Basic
    @Column(name = "pick_com_qty")
    private BigDecimal pickComQty;

    @Basic
    @Column(name = "outbound_qty")
    private BigDecimal outboundQty;

    @Basic
    @Column(name = "outbound_val")
    private Double outboundVal;

    @Basic
    @Column(name = "inbound_qty")
    private BigDecimal inboundQty;

    @Basic
    @Column(name = "inbound_val")
    private Double inboundVal;

    @Basic
    @Column(name = "in_pend_com_qty")
    private BigDecimal inPendComQty;

    @Basic
    @Column(name = "hold_com_qty")
    private BigDecimal holdComQty;

    @Basic
    @Column(name = "last_recpt_datei")
    private LocalDate lastRecptDatei;

    @Basic
    @Column(name = "last_recpt_qty")
    private BigDecimal lastRecptQty;

    @Basic
    @Column(name = "last_recpt_val")
    private Double lastRecptVal;

    @Basic
    @Column(name = "last_sale_datei")
    private LocalDate lastSaleDatei;

    @Basic
    @Column(name = "last_sale_qty")
    private BigDecimal lastSaleQty;

    @Basic
    @Column(name = "last_sale_val")
    private Double lastSaleVal;

    @Basic
    @Column(name = "techone_fld1")
    private String techoneFld1;

    @Basic
    @Column(name = "techone_fld2")
    private String techoneFld2;

    @Basic
    @Column(name = "techone_fld3")
    private BigDecimal techoneFld3;

    @Basic
    @Column(name = "techone_fld4")
    private BigDecimal techoneFld4;

    @Basic
    @Column(name = "techone_fld5")
    private Timestamp techoneFld5;

    @Basic
    @Column(name = "cruser")
    private String cruser;

    @Basic
    @Column(name = "crdatei")
    private Timestamp crdatei;

    @Basic
    @Column(name = "crtime")
    private BigDecimal crtime;

    @Basic
    @Column(name = "crterm")
    private String crterm;

    @Basic
    @Column(name = "crwindow")
    private String crwindow;

    @Basic
    @Column(name = "last_mod_user")
    private String lastModUser;

    @Basic
    @Column(name = "last_mod_datei")
    private Timestamp lastModDatei;

    @Basic
    @Column(name = "last_mod_time")
    private Long lastModTime;

    @Basic
    @Column(name = "last_mod_term")
    private String lastModTerm;

    @Basic
    @Column(name = "last_mod_window")
    private String lastModWindow;

    @Basic
    @Column(name = "sys_tid")
    private BigDecimal sysTid;

    @Basic
    @Column(name = "vers")
    private BigDecimal vers;

    @Basic
    @Column(name = "min_lvl_qty")
    private BigDecimal minLvlQty;

    @Basic
    @Column(name = "reord_lvl_qty")
    private BigDecimal reordLvlQty;

    @Basic
    @Column(name = "max_lvl_qty")
    private BigDecimal maxLvlQty;

    @Basic
    @Column(name = "oride_acct_ind")
    private String orideAcctInd;

    @Basic
    @Column(name = "ldg_code")
    private String ldgCode;

    @Basic
    @Column(name = "accnbri")
    private String accnbri;

    @Basic
    @Column(name = "last_trsfr_in_date")
    private LocalDate lastTrsfrInDate;

    @Basic
    @Column(name = "last_trsfr_in_qty")
    private BigDecimal lastTrsfrInQty;

    @Basic
    @Column(name = "last_trsfr_in_val")
    private Double lastTrsfrInVal;

    @Basic
    @Column(name = "rebate_value")
    private BigDecimal rebateValue;

    @Basic
    @Column(name = "active_prod_ind")
    private String activeProdInd;

    @Basic
    @Column(name = "active_iss_ind")
    private String activeIssInd;

    @Basic
    @Column(name = "active_trsfr_ind")
    private String activeTrsfrInd;

    @Basic
    @Column(name = "active_purch_ind")
    private String activePurchInd;

    @Basic
    @Column(name = "active_replen_ind")
    private String activeReplenInd;

    @Basic
    @Column(name = "active_sal_ind")
    private String activeSalInd;

    @Basic
    @Column(name = "cust_msg_text")
    private String custMsgText;

    @Basic
    @Column(name = "cust_msg_type")
    private String custMsgType;

    @Basic
    @Column(name = "abc_class")
    private String abcClass;

    @Basic
    @Column(name = "web_min_qty")
    private BigDecimal webMinQty;

    @Basic
    @Column(name = "web_ready")
    private String webReady;

    @Basic
    @Column(name = "plpc_prc")
    private BigDecimal plpcPrc;

    @Basic
    @Column(name = "ticket_prc")
    private BigDecimal ticketPrc;

    @Basic
    @Column(name = "sem_prc")
    private BigDecimal semPrc;

    @Basic
    @Column(name = "workorder_tmpl_id")
    private Long workorderTmplId;

    @Basic
    @Column(name = "web_com_qty")
    private BigDecimal webComQty;

    @Basic
    @Column(name = "locked_qty")
    private BigDecimal lockedQty;

    @Basic
    @Column(name = "fulfill_qty")
    private BigDecimal fulfillQty;


    public String getProdNbr() {
        return prodNbr;
    }

    public void setProdNbr(String prodNbr) {
        this.prodNbr = prodNbr;
    }


    public Long getLocnNbr() {
        return locnNbr;
    }

    public void setLocnNbr(Long locnNbr) {
        this.locnNbr = locnNbr;
    }


    public BigDecimal getLoclProdId() {
        return loclProdId;
    }

    public void setLoclProdId(BigDecimal loclProdId) {
        this.loclProdId = loclProdId;
    }


    public BigDecimal getSupCode() {
        return supCode;
    }

    public void setSupCode(BigDecimal supCode) {
        this.supCode = supCode;
    }


    public String getSupProdNbr() {
        return supProdNbr;
    }

    public void setSupProdNbr(String supProdNbr) {
        this.supProdNbr = supProdNbr;
    }


    public BigDecimal getOnhandQty() {
        return onhandQty;
    }

    public void setOnhandQty(BigDecimal onhandQty) {
        this.onhandQty = onhandQty;
    }


    public Double getOnhandVal() {
        return onhandVal;
    }

    public void setOnhandVal(Double onhandVal) {
        this.onhandVal = onhandVal;
    }


    public BigDecimal getOnhandAvgVal() {
        return onhandAvgVal;
    }

    public void setOnhandAvgVal(BigDecimal onhandAvgVal) {
        this.onhandAvgVal = onhandAvgVal;
    }


    public BigDecimal getPordComQty() {
        return pordComQty;
    }

    public void setPordComQty(BigDecimal pordComQty) {
        this.pordComQty = pordComQty;
    }


    public Double getPordComVal() {
        return pordComVal;
    }

    public void setPordComVal(Double pordComVal) {
        this.pordComVal = pordComVal;
    }


    public BigDecimal getBkordComQty() {
        return bkordComQty;
    }

    public void setBkordComQty(BigDecimal bkordComQty) {
        this.bkordComQty = bkordComQty;
    }


    public BigDecimal getPickComQty() {
        return pickComQty;
    }

    public void setPickComQty(BigDecimal pickComQty) {
        this.pickComQty = pickComQty;
    }


    public BigDecimal getOutboundQty() {
        return outboundQty;
    }

    public void setOutboundQty(BigDecimal outboundQty) {
        this.outboundQty = outboundQty;
    }


    public Double getOutboundVal() {
        return outboundVal;
    }

    public void setOutboundVal(Double outboundVal) {
        this.outboundVal = outboundVal;
    }


    public BigDecimal getInboundQty() {
        return inboundQty;
    }

    public void setInboundQty(BigDecimal inboundQty) {
        this.inboundQty = inboundQty;
    }


    public Double getInboundVal() {
        return inboundVal;
    }

    public void setInboundVal(Double inboundVal) {
        this.inboundVal = inboundVal;
    }


    public BigDecimal getInPendComQty() {
        return inPendComQty;
    }

    public void setInPendComQty(BigDecimal inPendComQty) {
        this.inPendComQty = inPendComQty;
    }


    public BigDecimal getHoldComQty() {
        return holdComQty;
    }

    public void setHoldComQty(BigDecimal holdComQty) {
        this.holdComQty = holdComQty;
    }


    public LocalDate getLastRecptDatei() {
        return lastRecptDatei;
    }

    public void setLastRecptDatei(LocalDate lastRecptDatei) {
        this.lastRecptDatei = lastRecptDatei;
    }


    public BigDecimal getLastRecptQty() {
        return lastRecptQty;
    }

    public void setLastRecptQty(BigDecimal lastRecptQty) {
        this.lastRecptQty = lastRecptQty;
    }


    public Double getLastRecptVal() {
        return lastRecptVal;
    }

    public void setLastRecptVal(Double lastRecptVal) {
        this.lastRecptVal = lastRecptVal;
    }


    public LocalDate getLastSaleDatei() {
        return lastSaleDatei;
    }

    public void setLastSaleDatei(LocalDate lastSaleDatei) {
        this.lastSaleDatei = lastSaleDatei;
    }


    public BigDecimal getLastSaleQty() {
        return lastSaleQty;
    }

    public void setLastSaleQty(BigDecimal lastSaleQty) {
        this.lastSaleQty = lastSaleQty;
    }


    public Double getLastSaleVal() {
        return lastSaleVal;
    }

    public void setLastSaleVal(Double lastSaleVal) {
        this.lastSaleVal = lastSaleVal;
    }


    public String getTechoneFld1() {
        return techoneFld1;
    }

    public void setTechoneFld1(String techoneFld1) {
        this.techoneFld1 = techoneFld1;
    }


    public String getTechoneFld2() {
        return techoneFld2;
    }

    public void setTechoneFld2(String techoneFld2) {
        this.techoneFld2 = techoneFld2;
    }


    public BigDecimal getTechoneFld3() {
        return techoneFld3;
    }

    public void setTechoneFld3(BigDecimal techoneFld3) {
        this.techoneFld3 = techoneFld3;
    }


    public BigDecimal getTechoneFld4() {
        return techoneFld4;
    }

    public void setTechoneFld4(BigDecimal techoneFld4) {
        this.techoneFld4 = techoneFld4;
    }


    public Timestamp getTechoneFld5() {
        return techoneFld5;
    }

    public void setTechoneFld5(Timestamp techoneFld5) {
        this.techoneFld5 = techoneFld5;
    }


    public String getCruser() {
        return cruser;
    }

    public void setCruser(String cruser) {
        this.cruser = cruser;
    }


    public Timestamp getCrdatei() {
        return crdatei;
    }

    public void setCrdatei(Timestamp crdatei) {
        this.crdatei = crdatei;
    }


    public BigDecimal getCrtime() {
        return crtime;
    }

    public void setCrtime(BigDecimal crtime) {
        this.crtime = crtime;
    }


    public String getCrterm() {
        return crterm;
    }

    public void setCrterm(String crterm) {
        this.crterm = crterm;
    }


    public String getCrwindow() {
        return crwindow;
    }

    public void setCrwindow(String crwindow) {
        this.crwindow = crwindow;
    }


    public String getLastModUser() {
        return lastModUser;
    }

    public void setLastModUser(String lastModUser) {
        this.lastModUser = lastModUser;
    }


    public Timestamp getLastModDatei() {
        return lastModDatei;
    }

    public void setLastModDatei(Timestamp lastModDatei) {
        this.lastModDatei = lastModDatei;
    }


    public Long getLastModTime() {
        return lastModTime;
    }

    public void setLastModTime(Long lastModTime) {
        this.lastModTime = lastModTime;
    }


    public String getLastModTerm() {
        return lastModTerm;
    }

    public void setLastModTerm(String lastModTerm) {
        this.lastModTerm = lastModTerm;
    }


    public String getLastModWindow() {
        return lastModWindow;
    }

    public void setLastModWindow(String lastModWindow) {
        this.lastModWindow = lastModWindow;
    }


    public BigDecimal getSysTid() {
        return sysTid;
    }

    public void setSysTid(BigDecimal sysTid) {
        this.sysTid = sysTid;
    }


    public BigDecimal getVers() {
        return vers;
    }

    public void setVers(BigDecimal vers) {
        this.vers = vers;
    }


    public BigDecimal getMinLvlQty() {
        return minLvlQty;
    }

    public void setMinLvlQty(BigDecimal minLvlQty) {
        this.minLvlQty = minLvlQty;
    }


    public BigDecimal getReordLvlQty() {
        return reordLvlQty;
    }

    public void setReordLvlQty(BigDecimal reordLvlQty) {
        this.reordLvlQty = reordLvlQty;
    }


    public BigDecimal getMaxLvlQty() {
        return maxLvlQty;
    }

    public void setMaxLvlQty(BigDecimal maxLvlQty) {
        this.maxLvlQty = maxLvlQty;
    }


    public String getOrideAcctInd() {
        return orideAcctInd;
    }

    public void setOrideAcctInd(String orideAcctInd) {
        this.orideAcctInd = orideAcctInd;
    }


    public String getLdgCode() {
        return ldgCode;
    }

    public void setLdgCode(String ldgCode) {
        this.ldgCode = ldgCode;
    }


    public String getAccnbri() {
        return accnbri;
    }

    public void setAccnbri(String accnbri) {
        this.accnbri = accnbri;
    }


    public LocalDate getLastTrsfrInDate() {
        return lastTrsfrInDate;
    }

    public void setLastTrsfrInDate(LocalDate lastTrsfrInDate) {
        this.lastTrsfrInDate = lastTrsfrInDate;
    }


    public BigDecimal getLastTrsfrInQty() {
        return lastTrsfrInQty;
    }

    public void setLastTrsfrInQty(BigDecimal lastTrsfrInQty) {
        this.lastTrsfrInQty = lastTrsfrInQty;
    }


    public Double getLastTrsfrInVal() {
        return lastTrsfrInVal;
    }

    public void setLastTrsfrInVal(Double lastTrsfrInVal) {
        this.lastTrsfrInVal = lastTrsfrInVal;
    }


    public BigDecimal getRebateValue() {
        return rebateValue;
    }

    public void setRebateValue(BigDecimal rebateValue) {
        this.rebateValue = rebateValue;
    }


    public String getActiveProdInd() {
        return activeProdInd;
    }

    public void setActiveProdInd(String activeProdInd) {
        this.activeProdInd = activeProdInd;
    }


    public String getActiveIssInd() {
        return activeIssInd;
    }

    public void setActiveIssInd(String activeIssInd) {
        this.activeIssInd = activeIssInd;
    }


    public String getActiveTrsfrInd() {
        return activeTrsfrInd;
    }

    public void setActiveTrsfrInd(String activeTrsfrInd) {
        this.activeTrsfrInd = activeTrsfrInd;
    }


    public String getActivePurchInd() {
        return activePurchInd;
    }

    public void setActivePurchInd(String activePurchInd) {
        this.activePurchInd = activePurchInd;
    }


    public String getActiveReplenInd() {
        return activeReplenInd;
    }

    public void setActiveReplenInd(String activeReplenInd) {
        this.activeReplenInd = activeReplenInd;
    }


    public String getActiveSalInd() {
        return activeSalInd;
    }

    public void setActiveSalInd(String activeSalInd) {
        this.activeSalInd = activeSalInd;
    }


    public String getCustMsgText() {
        return custMsgText;
    }

    public void setCustMsgText(String custMsgText) {
        this.custMsgText = custMsgText;
    }


    public String getCustMsgType() {
        return custMsgType;
    }

    public void setCustMsgType(String custMsgType) {
        this.custMsgType = custMsgType;
    }


    public String getAbcClass() {
        return abcClass;
    }

    public void setAbcClass(String abcClass) {
        this.abcClass = abcClass;
    }


    public BigDecimal getWebMinQty() {
        return webMinQty;
    }

    public void setWebMinQty(BigDecimal webMinQty) {
        this.webMinQty = webMinQty;
    }


    public String getWebReady() {
        return webReady;
    }

    public void setWebReady(String webReady) {
        this.webReady = webReady;
    }


    public BigDecimal getPlpcPrc() {
        return plpcPrc;
    }

    public void setPlpcPrc(BigDecimal plpcPrc) {
        this.plpcPrc = plpcPrc;
    }


    public BigDecimal getTicketPrc() {
        return ticketPrc;
    }

    public void setTicketPrc(BigDecimal ticketPrc) {
        this.ticketPrc = ticketPrc;
    }


    public BigDecimal getSemPrc() {
        return semPrc;
    }

    public void setSemPrc(BigDecimal semPrc) {
        this.semPrc = semPrc;
    }


    public Long getWorkorderTmplId() {
        return workorderTmplId;
    }

    public void setWorkorderTmplId(Long workorderTmplId) {
        this.workorderTmplId = workorderTmplId;
    }


    public BigDecimal getWebComQty() {
        return webComQty;
    }

    public void setWebComQty(BigDecimal webComQty) {
        this.webComQty = webComQty;
    }


    public BigDecimal getLockedQty() {
        return lockedQty;
    }

    public void setLockedQty(BigDecimal lockedQty) {
        this.lockedQty = lockedQty;
    }


    public BigDecimal getFulfillQty() {
        return fulfillQty;
    }

    public void setFulfillQty(BigDecimal fulfillQty) {
        this.fulfillQty = fulfillQty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        R1PosProdLoclEntity that = (R1PosProdLoclEntity) o;

        if (prodNbr != null ? !prodNbr.equals(that.prodNbr) : that.prodNbr != null) return false;
        if (locnNbr != null ? !locnNbr.equals(that.locnNbr) : that.locnNbr != null) return false;
        if (loclProdId != null ? !loclProdId.equals(that.loclProdId) : that.loclProdId != null) return false;
        if (supCode != null ? !supCode.equals(that.supCode) : that.supCode != null) return false;
        if (supProdNbr != null ? !supProdNbr.equals(that.supProdNbr) : that.supProdNbr != null) return false;
        if (onhandQty != null ? !onhandQty.equals(that.onhandQty) : that.onhandQty != null) return false;
        if (onhandVal != null ? !onhandVal.equals(that.onhandVal) : that.onhandVal != null) return false;
        if (onhandAvgVal != null ? !onhandAvgVal.equals(that.onhandAvgVal) : that.onhandAvgVal != null) return false;
        if (pordComQty != null ? !pordComQty.equals(that.pordComQty) : that.pordComQty != null) return false;
        if (pordComVal != null ? !pordComVal.equals(that.pordComVal) : that.pordComVal != null) return false;
        if (bkordComQty != null ? !bkordComQty.equals(that.bkordComQty) : that.bkordComQty != null) return false;
        if (pickComQty != null ? !pickComQty.equals(that.pickComQty) : that.pickComQty != null) return false;
        if (outboundQty != null ? !outboundQty.equals(that.outboundQty) : that.outboundQty != null) return false;
        if (outboundVal != null ? !outboundVal.equals(that.outboundVal) : that.outboundVal != null) return false;
        if (inboundQty != null ? !inboundQty.equals(that.inboundQty) : that.inboundQty != null) return false;
        if (inboundVal != null ? !inboundVal.equals(that.inboundVal) : that.inboundVal != null) return false;
        if (inPendComQty != null ? !inPendComQty.equals(that.inPendComQty) : that.inPendComQty != null) return false;
        if (holdComQty != null ? !holdComQty.equals(that.holdComQty) : that.holdComQty != null) return false;
        if (lastRecptDatei != null ? !lastRecptDatei.equals(that.lastRecptDatei) : that.lastRecptDatei != null)
            return false;
        if (lastRecptQty != null ? !lastRecptQty.equals(that.lastRecptQty) : that.lastRecptQty != null) return false;
        if (lastRecptVal != null ? !lastRecptVal.equals(that.lastRecptVal) : that.lastRecptVal != null) return false;
        if (lastSaleDatei != null ? !lastSaleDatei.equals(that.lastSaleDatei) : that.lastSaleDatei != null)
            return false;
        if (lastSaleQty != null ? !lastSaleQty.equals(that.lastSaleQty) : that.lastSaleQty != null) return false;
        if (lastSaleVal != null ? !lastSaleVal.equals(that.lastSaleVal) : that.lastSaleVal != null) return false;
        if (techoneFld1 != null ? !techoneFld1.equals(that.techoneFld1) : that.techoneFld1 != null) return false;
        if (techoneFld2 != null ? !techoneFld2.equals(that.techoneFld2) : that.techoneFld2 != null) return false;
        if (techoneFld3 != null ? !techoneFld3.equals(that.techoneFld3) : that.techoneFld3 != null) return false;
        if (techoneFld4 != null ? !techoneFld4.equals(that.techoneFld4) : that.techoneFld4 != null) return false;
        if (techoneFld5 != null ? !techoneFld5.equals(that.techoneFld5) : that.techoneFld5 != null) return false;
        if (cruser != null ? !cruser.equals(that.cruser) : that.cruser != null) return false;
        if (crdatei != null ? !crdatei.equals(that.crdatei) : that.crdatei != null) return false;
        if (crtime != null ? !crtime.equals(that.crtime) : that.crtime != null) return false;
        if (crterm != null ? !crterm.equals(that.crterm) : that.crterm != null) return false;
        if (crwindow != null ? !crwindow.equals(that.crwindow) : that.crwindow != null) return false;
        if (lastModUser != null ? !lastModUser.equals(that.lastModUser) : that.lastModUser != null) return false;
        if (lastModDatei != null ? !lastModDatei.equals(that.lastModDatei) : that.lastModDatei != null) return false;
        if (lastModTime != null ? !lastModTime.equals(that.lastModTime) : that.lastModTime != null) return false;
        if (lastModTerm != null ? !lastModTerm.equals(that.lastModTerm) : that.lastModTerm != null) return false;
        if (lastModWindow != null ? !lastModWindow.equals(that.lastModWindow) : that.lastModWindow != null)
            return false;
        if (sysTid != null ? !sysTid.equals(that.sysTid) : that.sysTid != null) return false;
        if (vers != null ? !vers.equals(that.vers) : that.vers != null) return false;
        if (minLvlQty != null ? !minLvlQty.equals(that.minLvlQty) : that.minLvlQty != null) return false;
        if (reordLvlQty != null ? !reordLvlQty.equals(that.reordLvlQty) : that.reordLvlQty != null) return false;
        if (maxLvlQty != null ? !maxLvlQty.equals(that.maxLvlQty) : that.maxLvlQty != null) return false;
        if (orideAcctInd != null ? !orideAcctInd.equals(that.orideAcctInd) : that.orideAcctInd != null) return false;
        if (ldgCode != null ? !ldgCode.equals(that.ldgCode) : that.ldgCode != null) return false;
        if (accnbri != null ? !accnbri.equals(that.accnbri) : that.accnbri != null) return false;
        if (lastTrsfrInDate != null ? !lastTrsfrInDate.equals(that.lastTrsfrInDate) : that.lastTrsfrInDate != null)
            return false;
        if (lastTrsfrInQty != null ? !lastTrsfrInQty.equals(that.lastTrsfrInQty) : that.lastTrsfrInQty != null)
            return false;
        if (lastTrsfrInVal != null ? !lastTrsfrInVal.equals(that.lastTrsfrInVal) : that.lastTrsfrInVal != null)
            return false;
        if (rebateValue != null ? !rebateValue.equals(that.rebateValue) : that.rebateValue != null) return false;
        if (activeProdInd != null ? !activeProdInd.equals(that.activeProdInd) : that.activeProdInd != null)
            return false;
        if (activeIssInd != null ? !activeIssInd.equals(that.activeIssInd) : that.activeIssInd != null) return false;
        if (activeTrsfrInd != null ? !activeTrsfrInd.equals(that.activeTrsfrInd) : that.activeTrsfrInd != null)
            return false;
        if (activePurchInd != null ? !activePurchInd.equals(that.activePurchInd) : that.activePurchInd != null)
            return false;
        if (activeReplenInd != null ? !activeReplenInd.equals(that.activeReplenInd) : that.activeReplenInd != null)
            return false;
        if (activeSalInd != null ? !activeSalInd.equals(that.activeSalInd) : that.activeSalInd != null) return false;
        if (custMsgText != null ? !custMsgText.equals(that.custMsgText) : that.custMsgText != null) return false;
        if (custMsgType != null ? !custMsgType.equals(that.custMsgType) : that.custMsgType != null) return false;
        if (abcClass != null ? !abcClass.equals(that.abcClass) : that.abcClass != null) return false;
        if (webMinQty != null ? !webMinQty.equals(that.webMinQty) : that.webMinQty != null) return false;
        if (webReady != null ? !webReady.equals(that.webReady) : that.webReady != null) return false;
        if (plpcPrc != null ? !plpcPrc.equals(that.plpcPrc) : that.plpcPrc != null) return false;
        if (ticketPrc != null ? !ticketPrc.equals(that.ticketPrc) : that.ticketPrc != null) return false;
        if (semPrc != null ? !semPrc.equals(that.semPrc) : that.semPrc != null) return false;
        if (workorderTmplId != null ? !workorderTmplId.equals(that.workorderTmplId) : that.workorderTmplId != null)
            return false;
        if (webComQty != null ? !webComQty.equals(that.webComQty) : that.webComQty != null) return false;
        if (lockedQty != null ? !lockedQty.equals(that.lockedQty) : that.lockedQty != null) return false;
        return fulfillQty != null ? fulfillQty.equals(that.fulfillQty) : that.fulfillQty == null;
    }

    @Override
    public int hashCode() {
        int result = prodNbr != null ? prodNbr.hashCode() : 0;
        result = 31 * result + (locnNbr != null ? locnNbr.hashCode() : 0);
        result = 31 * result + (loclProdId != null ? loclProdId.hashCode() : 0);
        result = 31 * result + (supCode != null ? supCode.hashCode() : 0);
        result = 31 * result + (supProdNbr != null ? supProdNbr.hashCode() : 0);
        result = 31 * result + (onhandQty != null ? onhandQty.hashCode() : 0);
        result = 31 * result + (onhandVal != null ? onhandVal.hashCode() : 0);
        result = 31 * result + (onhandAvgVal != null ? onhandAvgVal.hashCode() : 0);
        result = 31 * result + (pordComQty != null ? pordComQty.hashCode() : 0);
        result = 31 * result + (pordComVal != null ? pordComVal.hashCode() : 0);
        result = 31 * result + (bkordComQty != null ? bkordComQty.hashCode() : 0);
        result = 31 * result + (pickComQty != null ? pickComQty.hashCode() : 0);
        result = 31 * result + (outboundQty != null ? outboundQty.hashCode() : 0);
        result = 31 * result + (outboundVal != null ? outboundVal.hashCode() : 0);
        result = 31 * result + (inboundQty != null ? inboundQty.hashCode() : 0);
        result = 31 * result + (inboundVal != null ? inboundVal.hashCode() : 0);
        result = 31 * result + (inPendComQty != null ? inPendComQty.hashCode() : 0);
        result = 31 * result + (holdComQty != null ? holdComQty.hashCode() : 0);
        result = 31 * result + (lastRecptDatei != null ? lastRecptDatei.hashCode() : 0);
        result = 31 * result + (lastRecptQty != null ? lastRecptQty.hashCode() : 0);
        result = 31 * result + (lastRecptVal != null ? lastRecptVal.hashCode() : 0);
        result = 31 * result + (lastSaleDatei != null ? lastSaleDatei.hashCode() : 0);
        result = 31 * result + (lastSaleQty != null ? lastSaleQty.hashCode() : 0);
        result = 31 * result + (lastSaleVal != null ? lastSaleVal.hashCode() : 0);
        result = 31 * result + (techoneFld1 != null ? techoneFld1.hashCode() : 0);
        result = 31 * result + (techoneFld2 != null ? techoneFld2.hashCode() : 0);
        result = 31 * result + (techoneFld3 != null ? techoneFld3.hashCode() : 0);
        result = 31 * result + (techoneFld4 != null ? techoneFld4.hashCode() : 0);
        result = 31 * result + (techoneFld5 != null ? techoneFld5.hashCode() : 0);
        result = 31 * result + (cruser != null ? cruser.hashCode() : 0);
        result = 31 * result + (crdatei != null ? crdatei.hashCode() : 0);
        result = 31 * result + (crtime != null ? crtime.hashCode() : 0);
        result = 31 * result + (crterm != null ? crterm.hashCode() : 0);
        result = 31 * result + (crwindow != null ? crwindow.hashCode() : 0);
        result = 31 * result + (lastModUser != null ? lastModUser.hashCode() : 0);
        result = 31 * result + (lastModDatei != null ? lastModDatei.hashCode() : 0);
        result = 31 * result + (lastModTime != null ? lastModTime.hashCode() : 0);
        result = 31 * result + (lastModTerm != null ? lastModTerm.hashCode() : 0);
        result = 31 * result + (lastModWindow != null ? lastModWindow.hashCode() : 0);
        result = 31 * result + (sysTid != null ? sysTid.hashCode() : 0);
        result = 31 * result + (vers != null ? vers.hashCode() : 0);
        result = 31 * result + (minLvlQty != null ? minLvlQty.hashCode() : 0);
        result = 31 * result + (reordLvlQty != null ? reordLvlQty.hashCode() : 0);
        result = 31 * result + (maxLvlQty != null ? maxLvlQty.hashCode() : 0);
        result = 31 * result + (orideAcctInd != null ? orideAcctInd.hashCode() : 0);
        result = 31 * result + (ldgCode != null ? ldgCode.hashCode() : 0);
        result = 31 * result + (accnbri != null ? accnbri.hashCode() : 0);
        result = 31 * result + (lastTrsfrInDate != null ? lastTrsfrInDate.hashCode() : 0);
        result = 31 * result + (lastTrsfrInQty != null ? lastTrsfrInQty.hashCode() : 0);
        result = 31 * result + (lastTrsfrInVal != null ? lastTrsfrInVal.hashCode() : 0);
        result = 31 * result + (rebateValue != null ? rebateValue.hashCode() : 0);
        result = 31 * result + (activeProdInd != null ? activeProdInd.hashCode() : 0);
        result = 31 * result + (activeIssInd != null ? activeIssInd.hashCode() : 0);
        result = 31 * result + (activeTrsfrInd != null ? activeTrsfrInd.hashCode() : 0);
        result = 31 * result + (activePurchInd != null ? activePurchInd.hashCode() : 0);
        result = 31 * result + (activeReplenInd != null ? activeReplenInd.hashCode() : 0);
        result = 31 * result + (activeSalInd != null ? activeSalInd.hashCode() : 0);
        result = 31 * result + (custMsgText != null ? custMsgText.hashCode() : 0);
        result = 31 * result + (custMsgType != null ? custMsgType.hashCode() : 0);
        result = 31 * result + (abcClass != null ? abcClass.hashCode() : 0);
        result = 31 * result + (webMinQty != null ? webMinQty.hashCode() : 0);
        result = 31 * result + (webReady != null ? webReady.hashCode() : 0);
        result = 31 * result + (plpcPrc != null ? plpcPrc.hashCode() : 0);
        result = 31 * result + (ticketPrc != null ? ticketPrc.hashCode() : 0);
        result = 31 * result + (semPrc != null ? semPrc.hashCode() : 0);
        result = 31 * result + (workorderTmplId != null ? workorderTmplId.hashCode() : 0);
        result = 31 * result + (webComQty != null ? webComQty.hashCode() : 0);
        result = 31 * result + (lockedQty != null ? lockedQty.hashCode() : 0);
        result = 31 * result + (fulfillQty != null ? fulfillQty.hashCode() : 0);
        return result;
    }
}

package au.com.tgg.apps.foundation.model.json;

import au.com.tgg.apps.foundation.util.JsonDateDeserializer;
import au.com.tgg.apps.foundation.util.JsonDateTimeSerializer;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


/**
 * POS_ITEM_LOC
 * <p>
 * This is POS_ITEM_LOC
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "product_id",
        "location_id",
        "onhand_qty",
        "onhand_val",
        "onhand_avg_val",
        "pord_com_qty",
        "pord_com_val",
        "bkord_com_qty",
        "pick_com_qty",
        "outbound_qty",
        "outbound_val",
        "inbound_qty",
        "inbound_val",
        "in_pend_com_qty",
        "hold_com_qty",
        "last_recpt_datei",
        "last_recpt_qty",
        "last_recpt_val",
        "last_sale_datei",
        "last_sale_qty",
        "last_sale_val",
        "rebate_value",
        "web_min_qty",
        "web_ready",
        "web_com_qty",
        "created_datetime",
        "last_modified_datetime",
        "web_ready_b2b",
        "active_prod_ind",
        "active_iss_ind",
        "active_trsfr_ind",
        "active_purch_ind",
        "active_replen_ind",
        "active_sal_ind",
        "prod_nbr",
        "locn_nbr",
        "inv_name"
})
public class PosItemLoc extends JsonHeader {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("product_id")
    private BigInteger productId;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("location_id")
    private BigInteger locationId;
    @JsonProperty("onhand_qty")
    private Integer onhandQty;
    @JsonProperty("status")
    private String status;
    @JsonProperty("onhand_val")
    private Integer onhandVal;
    @JsonProperty("onhand_avg_val")
    private Integer onhandAvgVal;
    @JsonProperty("pord_com_qty")
    private Integer pordComQty;
    @JsonProperty("pord_com_val")
    private Double pordComVal;
    @JsonProperty("bkord_com_qty")
    private Integer bkordComQty;
    @JsonProperty("pick_com_qty")
    private Integer pickComQty;
    @JsonProperty("outbound_qty")
    private Integer outboundQty;
    @JsonProperty("outbound_val")
    private Double outboundVal;
    @JsonProperty("inbound_qty")
    private Integer inboundQty;
    @JsonProperty("inbound_val")
    private Double inboundVal;
    @JsonProperty("in_pend_com_qty")
    private Integer inPendComQty;
    @JsonProperty("hold_com_qty")
    private Integer holdComQty;
    @JsonProperty("locn_nbr")
    private BigInteger locn_nbr;
    @JsonProperty("last_recpt_datei")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private LocalDate lastRecptDatei;
    @JsonProperty("last_recpt_qty")
    private Integer lastRecptQty;
    @JsonProperty("last_recpt_val")
    private Double lastRecptVal;
    @JsonProperty("last_sale_datei")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private LocalDate lastSaleDatei;
    @JsonProperty("last_sale_qty")
    private Integer lastSaleQty;
    @JsonProperty("last_sale_val")
    private Double lastSaleVal;
    @JsonProperty("rebate_value")
    private Integer rebateValue;
    @JsonProperty("web_min_qty")
    private Integer webMinQty;
    @JsonProperty("web_ready")
    private String webReady;
    @JsonProperty("web_com_qty")
    private Integer webComQty;
    @JsonProperty("created_datetime")
    private LocalDate createdDatetime;
    @JsonProperty("last_modified_datetime")
    private LocalDate lastModifiedDatetime;
    @JsonProperty("web_ready_b2b")
    private String webReadyB2b;
    @JsonProperty("active_prod_ind")
    private String activeProdInd;
    @JsonProperty("active_iss_ind")
    private String activeIssInd;
    @JsonProperty("active_trsfr_ind")
    private String activeTrsfrInd;
    @JsonProperty("active_purch_ind")
    private String activePurchInd;
    @JsonProperty("active_replen_ind")
    private String activeReplenInd;
    @JsonProperty("active_sal_ind")
    private String activeSalInd;

    @JsonProperty("prod_nbr")
    private String prodNbr;

    @JsonProperty("locn_name")
    private String locnName;

    @JsonProperty("inv_name")
    private String invName;

    @JsonIgnore
    private final Map<String, String> additionalProperties = new HashMap<String, String>();

    /**
     *
     * (Required)
     *
     */
    public BigInteger getProductId() {
        return productId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigInteger getLocn_nbr() {
        return locn_nbr;
    }

    public void setLocn_nbr(BigInteger locn_nbr) {
        this.locn_nbr = locn_nbr;
    }

    /**
     *
     * (Required)
     *
     */
    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

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

    public Integer getOnhandQty() {
        return onhandQty;
    }

    public void setOnhandQty(Integer onhandQty) {
        this.onhandQty = onhandQty;
    }

    public Integer getOnhandVal() {
        return onhandVal;
    }

    public void setOnhandVal(Integer onhandVal) {
        this.onhandVal = onhandVal;
    }

    public Integer getOnhandAvgVal() {
        return onhandAvgVal;
    }

    public void setOnhandAvgVal(Integer onhandAvgVal) {
        this.onhandAvgVal = onhandAvgVal;
    }

    public Integer getPordComQty() {
        return pordComQty;
    }

    public void setPordComQty(Integer pordComQty) {
        this.pordComQty = pordComQty;
    }

    public Double getPordComVal() {
        return pordComVal;
    }

    public void setPordComVal(Double pordComVal) {
        this.pordComVal = pordComVal;
    }

    public Integer getBkordComQty() {
        return bkordComQty;
    }

    public void setBkordComQty(Integer bkordComQty) {
        this.bkordComQty = bkordComQty;
    }

    public Integer getPickComQty() {
        return pickComQty;
    }

    public void setPickComQty(Integer pickComQty) {
        this.pickComQty = pickComQty;
    }

    public Integer getOutboundQty() {
        return outboundQty;
    }

    public void setOutboundQty(Integer outboundQty) {
        this.outboundQty = outboundQty;
    }

    public Double getOutboundVal() {
        return outboundVal;
    }

    public void setOutboundVal(Double outboundVal) {
        this.outboundVal = outboundVal;
    }

    public Integer getInboundQty() {
        return inboundQty;
    }

    public void setInboundQty(Integer inboundQty) {
        this.inboundQty = inboundQty;
    }

    public Double getInboundVal() {
        return inboundVal;
    }

    public void setInboundVal(Double inboundVal) {
        this.inboundVal = inboundVal;
    }

    public Integer getInPendComQty() {
        return inPendComQty;
    }

    public void setInPendComQty(Integer inPendComQty) {
        this.inPendComQty = inPendComQty;
    }

    public Integer getHoldComQty() {
        return holdComQty;
    }

    public void setHoldComQty(Integer holdComQty) {
        this.holdComQty = holdComQty;
    }

    public LocalDate getLastRecptDatei() {
        return lastRecptDatei;
    }

    public void setLastRecptDatei(LocalDate lastRecptDatei) {
        this.lastRecptDatei = lastRecptDatei;
    }

    public Integer getLastRecptQty() {
        return lastRecptQty;
    }

    public void setLastRecptQty(Integer lastRecptQty) {
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

    public Integer getLastSaleQty() {
        return lastSaleQty;
    }

    public void setLastSaleQty(Integer lastSaleQty) {
        this.lastSaleQty = lastSaleQty;
    }

    public Double getLastSaleVal() {
        return lastSaleVal;
    }

    public void setLastSaleVal(Double lastSaleVal) {
        this.lastSaleVal = lastSaleVal;
    }

    public Integer getRebateValue() {
        return rebateValue;
    }

    public void setRebateValue(Integer rebateValue) {
        this.rebateValue = rebateValue;
    }

    public Integer getWebMinQty() {
        return webMinQty;
    }

    public void setWebMinQty(Integer webMinQty) {
        this.webMinQty = webMinQty;
    }

    public String getWebReady() {
        return webReady;
    }

    public void setWebReady(String webReady) {
        this.webReady = webReady;
    }

    public Integer getWebComQty() {
        return webComQty;
    }

    public void setWebComQty(Integer webComQty) {
        this.webComQty = webComQty;
    }

    public LocalDate getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(LocalDate createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public LocalDate getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public void setLastModifiedDatetime(LocalDate lastModifiedDatetime) {
        this.lastModifiedDatetime = lastModifiedDatetime;
    }

    public String getWebReadyB2b() {
        return webReadyB2b;
    }

    public void setWebReadyB2b(String webReadyB2b) {
        this.webReadyB2b = webReadyB2b;
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

    @JsonAnyGetter
    public Map<String, String> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, String value) {
        this.additionalProperties.put(name, value);
    }

    public String getProdNbr() {
        return prodNbr;
    }

    public void setProdNbr(String prodNbr) {
        this.prodNbr = prodNbr;
    }

    public String getLocnName() {
        return locnName;
    }

    public void setLocnName(String locnName) {
        this.locnName = locnName;
    }

    public String getInvName() {
        return invName;
    }

    public void setInvName(String invName) {
        this.invName = invName;
    }

}

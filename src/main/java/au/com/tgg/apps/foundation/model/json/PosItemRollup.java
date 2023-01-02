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
 * POS_ITEM_ROLLUP
 * <p>
 * This is POS_ITEM_ROLLUP
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "product_id",
        "web_ready",
        "web_ready_b2b",
        "onhand_qty",
        "pick_com_qty",
        "bkord_com_qty",
        "hold_com_qty",
        "outbound_qty",
        "web_min_qty",
        "last_recpt_datei",
        "nat_web_onhand_qty",
        "vic_web_onhand_quantity",
        "tas_web_onhand_quantity",
        "qld_web_onhand_quantity",
        "nsw_web_onhand_quantity",
        "act_web_onhand_quantity",
        "wa_web_onhand_quantity",
        "sa_web_onhand_quantity",
        "nt_web_onhand_quantity",
        "created_datetime",
        "last_modified_datetime",
        "onhand_val",
        "onorder_qty",
        "onorder_val",
        "onhand_avg_val",
        "last_sale_datei",
        "onhand_median_val"
})
public class PosItemRollup extends JsonHeader {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("product_id")
    private BigInteger productId;
    /**
     * product field
     * (Required)
     *
     */
    @JsonProperty("prod_nbr")
    @JsonPropertyDescription("prod nbr")
    private String prod_nbr;
    @JsonProperty("web_ready")
    private String webReady;
    @JsonProperty("web_ready_b2b")
    private String webReadyB2b;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("onhand_qty")
    private BigInteger onhandQty;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("pick_com_qty")
    private BigInteger pickComQty;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("bkord_com_qty")
    private BigInteger bkordComQty;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("hold_com_qty")
    private BigInteger holdComQty;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("outbound_qty")
    private BigInteger outboundQty;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("web_min_qty")
    private BigInteger webMinQty;
    @JsonProperty("last_recpt_datei")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private LocalDate lastRecptDate;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("nat_web_onhand_qty")
    private BigInteger natWebOnhandQty;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("vic_web_onhand_quantity")
    private BigInteger vicWebOnhandQuantity;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("tas_web_onhand_quantity")
    private BigInteger tasWebOnhandQuantity;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("qld_web_onhand_quantity")
    private BigInteger qldWebOnhandQuantity;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("nsw_web_onhand_quantity")
    private BigInteger nswWebOnhandQuantity;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("act_web_onhand_quantity")
    private BigInteger actWebOnhandQuantity;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("wa_web_onhand_quantity")
    private BigInteger waWebOnhandQuantity;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("sa_web_onhand_quantity")
    private BigInteger saWebOnhandQuantity;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("nt_web_onhand_quantity")
    private BigInteger ntWebOnhandQuantity;
    @JsonProperty("created_datetime")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private LocalDate createdDatetime;
    @JsonProperty("last_modified_datetime")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private LocalDate lastModifiedDatetime;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("onhand_val")
    private BigInteger onhandVal;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("onorder_qty")
    private BigInteger onorderQty;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("onorder_val")
    private BigInteger onorderVal;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("onhand_avg_val")
    private BigInteger onhandAvgVal;
    @JsonProperty("last_sale_datei")
    private LocalDate lastSaleDatei;
    @JsonProperty("onhand_median_val")
    private BigInteger onhandMedianVal;
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

    /**
     *
     * (Required)
     *
     */
    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    public String getWebReady() {
        return webReady;
    }

    public void setWebReady(String webReady) {
        this.webReady = webReady;
    }

    public String getWebReadyB2b() {
        return webReadyB2b;
    }

    public void setWebReadyB2b(String webReadyB2b) {
        this.webReadyB2b = webReadyB2b;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getOnhandQty() {
        return onhandQty;
    }

    /**
     *
     * (Required)
     *
     */
    public void setOnhandQty(BigInteger onhandQty) {
        this.onhandQty = onhandQty;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getPickComQty() {
        return pickComQty;
    }

    /**
     *
     * (Required)
     *
     */
    public void setPickComQty(BigInteger pickComQty) {
        this.pickComQty = pickComQty;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getBkordComQty() {
        return bkordComQty;
    }

    /**
     *
     * (Required)
     *
     */
    public void setBkordComQty(BigInteger bkordComQty) {
        this.bkordComQty = bkordComQty;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getHoldComQty() {
        return holdComQty;
    }

    /**
     *
     * (Required)
     *
     */
    public void setHoldComQty(BigInteger holdComQty) {
        this.holdComQty = holdComQty;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getOutboundQty() {
        return outboundQty;
    }

    /**
     *
     * (Required)
     *
     */
    public void setOutboundQty(BigInteger outboundQty) {
        this.outboundQty = outboundQty;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getWebMinQty() {
        return webMinQty;
    }

    /**
     *
     * (Required)
     *
     */
    public void setWebMinQty(BigInteger webMinQty) {
        this.webMinQty = webMinQty;
    }

    public LocalDate getLastRecptDate() {
        return lastRecptDate;
    }

    public void setLastRecptDatei(LocalDate lastRecptDatei) {
        this.lastRecptDate = lastRecptDatei;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getNatWebOnhandQty() {
        return natWebOnhandQty;
    }

    /**
     *
     * (Required)
     *
     */
    public void setNatWebOnhandQty(BigInteger natWebOnhandQty) {
        this.natWebOnhandQty = natWebOnhandQty;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getVicWebOnhandQuantity() {
        return vicWebOnhandQuantity;
    }

    /**
     *
     * (Required)
     *
     */
    public void setVicWebOnhandQuantity(BigInteger vicWebOnhandQuantity) {
        this.vicWebOnhandQuantity = vicWebOnhandQuantity;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getTasWebOnhandQuantity() {
        return tasWebOnhandQuantity;
    }

    /**
     *
     * (Required)
     *
     */
    public void setTasWebOnhandQuantity(BigInteger tasWebOnhandQuantity) {
        this.tasWebOnhandQuantity = tasWebOnhandQuantity;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getQldWebOnhandQuantity() {
        return qldWebOnhandQuantity;
    }

    /**
     *
     * (Required)
     *
     */
    public void setQldWebOnhandQuantity(BigInteger qldWebOnhandQuantity) {
        this.qldWebOnhandQuantity = qldWebOnhandQuantity;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getNswWebOnhandQuantity() {
        return nswWebOnhandQuantity;
    }

    /**
     *
     * (Required)
     *
     */
    public void setNswWebOnhandQuantity(BigInteger nswWebOnhandQuantity) {
        this.nswWebOnhandQuantity = nswWebOnhandQuantity;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getActWebOnhandQuantity() {
        return actWebOnhandQuantity;
    }

    /**
     *
     * (Required)
     *
     */
    public void setActWebOnhandQuantity(BigInteger actWebOnhandQuantity) {
        this.actWebOnhandQuantity = actWebOnhandQuantity;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getWaWebOnhandQuantity() {
        return waWebOnhandQuantity;
    }

    /**
     *
     * (Required)
     *
     */
    public void setWaWebOnhandQuantity(BigInteger waWebOnhandQuantity) {
        this.waWebOnhandQuantity = waWebOnhandQuantity;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getSaWebOnhandQuantity() {
        return saWebOnhandQuantity;
    }

    /**
     *
     * (Required)
     *
     */
    public void setSaWebOnhandQuantity(BigInteger saWebOnhandQuantity) {
        this.saWebOnhandQuantity = saWebOnhandQuantity;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getNtWebOnhandQuantity() {
        return ntWebOnhandQuantity;
    }

    /**
     *
     * (Required)
     *
     */
    public void setNtWebOnhandQuantity(BigInteger ntWebOnhandQuantity) {
        this.ntWebOnhandQuantity = ntWebOnhandQuantity;
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

    /**
     *
     * (Required)
     *
     */
    public BigInteger getOnhandVal() {
        return onhandVal;
    }

    /**
     *
     * (Required)
     *
     */
    public void setOnhandVal(BigInteger onhandVal) {
        this.onhandVal = onhandVal;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getOnorderQty() {
        return onorderQty;
    }

    /**
     *
     * (Required)
     *
     */
    public void setOnorderQty(BigInteger onorderQty) {
        this.onorderQty = onorderQty;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getOnorderVal() {
        return onorderVal;
    }

    /**
     *
     * (Required)
     *
     */
    public void setOnorderVal(BigInteger onorderVal) {
        this.onorderVal = onorderVal;
    }

    /**
     *
     * (Required)
     *
     */
    public BigInteger getOnhandAvgVal() {
        return onhandAvgVal;
    }

    /**
     *
     * (Required)
     *
     */
    public void setOnhandAvgVal(BigInteger onhandAvgVal) {
        this.onhandAvgVal = onhandAvgVal;
    }

    public LocalDate getLastSaleDatei() {
        return lastSaleDatei;
    }

    public void setLastSaleDatei(LocalDate lastSaleDatei) {
        this.lastSaleDatei = lastSaleDatei;
    }

    public BigInteger getOnhandMedianVal() {
        return onhandMedianVal;
    }

    public void setOnhandMedianVal(BigInteger onhandMedianVal) {
        this.onhandMedianVal = onhandMedianVal;
    }

    public String getprod_nbr() {
        return prod_nbr;
    }

    public void setprod_nbr(String prod_nbr) {
        this.prod_nbr = prod_nbr;
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

package au.com.tgg.apps.foundation.model.tggcsodr;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "pos_item_rollup")
@SuppressWarnings("ALL")
@DynamicUpdate
public class PosItemRollupEntity {

    @Id
    @Column(name = "product_id")
    private BigInteger productId;   //RMS PK    FK

    @Basic
    @Column(name = "prod_nbr")
    private String prod_nbr;

    @Basic
    @Column(name = "web_ready")
    private String webReady;

    @Basic
    @Column(name = "web_ready_b2b")
    private String webReadyB2B;

    @Basic
    @Column(name = "onhand_qty")
    private BigInteger onhandQty = new BigInteger(String.valueOf(0));

    @Basic
    @Column(name = "pick_com_qty")
    private BigInteger pickComQty = new BigInteger(String.valueOf(0));

    @Basic
    @Column(name = "bkord_com_qty")
    private BigInteger bkordComQty = new BigInteger(String.valueOf(0));

    @Basic
    @Column(name = "hold_com_qty")
    private BigInteger holdComQty = new BigInteger(String.valueOf(0));

    @Basic
    @Column(name = "outbound_qty")
    private BigInteger outboundQty = new BigInteger(String.valueOf(0));

    @Basic
    @Column(name = "web_min_qty")
    private BigInteger webMinQty = new BigInteger(String.valueOf(0));

    @Basic
    @Column(name = "last_recpt_datei")
    private LocalDateTime lastRecptDatei;

    @Basic
    @Column(name = "nat_web_onhand_qty")
    private BigInteger natWebOnhandQty = new BigInteger(String.valueOf(0));

    @Basic
    @Column(name = "vic_web_onhand_quantity")
    private BigInteger vicWebOnhandQuantity = new BigInteger(String.valueOf(0));

    @Basic
    @Column(name = "tas_web_onhand_quantity")
    private BigInteger tasWebOnhandQuantity = new BigInteger(String.valueOf(0));

    @Basic
    @Column(name = "qld_web_onhand_quantity")
    private BigInteger qldWebOnhandQuantity = new BigInteger(String.valueOf(0));

    @Basic
    @Column(name = "nsw_web_onhand_quantity")
    private BigInteger nswWebOnhandQuantity = new BigInteger(String.valueOf(0));

    @Basic
    @Column(name = "act_web_onhand_quantity")
    private BigInteger actWebOnhandQuantity = new BigInteger(String.valueOf(0));

    @Basic
    @Column(name = "wa_web_onhand_quantity")
    private BigInteger waWebOnhandQuantity = new BigInteger(String.valueOf(0));

    @Basic
    @Column(name = "sa_web_onhand_quantity")
    private BigInteger saWebOnhandQuantity = new BigInteger(String.valueOf(0));

    @Basic
    @Column(name = "nt_web_onhand_quantity")
    private BigInteger ntWebOnhandQuantity = new BigInteger(String.valueOf(0));

    @Basic
    @Column(name = "created_datetime")
    private LocalDateTime createdDatetime;

    @Basic
    @Column(name = "last_modified_datetime")
    private LocalDateTime lastModifiedDatetime;

    @Basic
    @Column(name = "onhand_val")
    private BigInteger onhandVal = new BigInteger(String.valueOf(0));

    @Basic
    @Column(name = "onorder_qty")
    private BigInteger onorderQty = new BigInteger(String.valueOf(0));

    @Basic
    @Column(name = "onorder_val")
    private BigInteger onorderVal = new BigInteger(String.valueOf(0));

    @Basic
    @Column(name = "onhand_avg_val")
    private BigInteger onhandAvgVal = new BigInteger(String.valueOf(0));

    @Basic
    @Column(name = "last_sale_datei")
    private LocalDateTime lastSaleDatei;

    @Basic
    @Column(name = "onhand_median_val")
    private BigInteger onhandMedianVal = new BigInteger(String.valueOf(0));

    public String getProd_nbr() {
        return prod_nbr;
    }

    public void setProd_nbr(String prod_nbr) {
        this.prod_nbr = prod_nbr;
    }

    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }


    public String getWebReady() {
        return webReady;
    }

    public void setWebReady(String webReady) {
        this.webReady = webReady;
    }


    public String getWebReadyB2B() {
        return webReadyB2B;
    }

    public void setWebReadyB2B(String webReadyB2B) {
        this.webReadyB2B = webReadyB2B;
    }


    public BigInteger getOnhandQty() {
        return onhandQty;
    }

    public void setOnhandQty(BigInteger onhandQty) {
        this.onhandQty = onhandQty;
    }


    public BigInteger getPickComQty() {
        return pickComQty;
    }

    public void setPickComQty(BigInteger pickComQty) {
        this.pickComQty = pickComQty;
    }


    public BigInteger getBkordComQty() {
        return bkordComQty;
    }

    public void setBkordComQty(BigInteger bkordComQty) {
        this.bkordComQty = bkordComQty;
    }


    public BigInteger getHoldComQty() {
        return holdComQty;
    }

    public void setHoldComQty(BigInteger holdComQty) {
        this.holdComQty = holdComQty;
    }


    public BigInteger getOutboundQty() {
        return outboundQty;
    }

    public void setOutboundQty(BigInteger outboundQty) {
        this.outboundQty = outboundQty;
    }


    public BigInteger getWebMinQty() {
        return webMinQty;
    }

    public void setWebMinQty(BigInteger webMinQty) {
        this.webMinQty = webMinQty;
    }


    public LocalDateTime getLastRecptDatei() {
        return lastRecptDatei;
    }

    public void setLastRecptDatei(LocalDateTime lastRecptDatei) {
        this.lastRecptDatei = lastRecptDatei;
    }


    public BigInteger getNatWebOnhandQty() {
        return natWebOnhandQty;
    }

    public void setNatWebOnhandQty(BigInteger natWebOnhandQty) {
        this.natWebOnhandQty = natWebOnhandQty;
    }


    public BigInteger getVicWebOnhandQuantity() {
        return vicWebOnhandQuantity;
    }

    public void setVicWebOnhandQuantity(BigInteger vicWebOnhandQuantity) {
        this.vicWebOnhandQuantity = vicWebOnhandQuantity;
    }


    public BigInteger getTasWebOnhandQuantity() {
        return tasWebOnhandQuantity;
    }

    public void setTasWebOnhandQuantity(BigInteger tasWebOnhandQuantity) {
        this.tasWebOnhandQuantity = tasWebOnhandQuantity;
    }


    public BigInteger getQldWebOnhandQuantity() {
        return qldWebOnhandQuantity;
    }

    public void setQldWebOnhandQuantity(BigInteger qldWebOnhandQuantity) {
        this.qldWebOnhandQuantity = qldWebOnhandQuantity;
    }


    public BigInteger getNswWebOnhandQuantity() {
        return nswWebOnhandQuantity;
    }

    public void setNswWebOnhandQuantity(BigInteger nswWebOnhandQuantity) {
        this.nswWebOnhandQuantity = nswWebOnhandQuantity;
    }


    public BigInteger getActWebOnhandQuantity() {
        return actWebOnhandQuantity;
    }

    public void setActWebOnhandQuantity(BigInteger actWebOnhandQuantity) {
        this.actWebOnhandQuantity = actWebOnhandQuantity;
    }


    public BigInteger getWaWebOnhandQuantity() {
        return waWebOnhandQuantity;
    }

    public void setWaWebOnhandQuantity(BigInteger waWebOnhandQuantity) {
        this.waWebOnhandQuantity = waWebOnhandQuantity;
    }


    public BigInteger getSaWebOnhandQuantity() {
        return saWebOnhandQuantity;
    }

    public void setSaWebOnhandQuantity(BigInteger saWebOnhandQuantity) {
        this.saWebOnhandQuantity = saWebOnhandQuantity;
    }


    public BigInteger getNtWebOnhandQuantity() {
        return ntWebOnhandQuantity;
    }

    public void setNtWebOnhandQuantity(BigInteger ntWebOnhandQuantity) {
        this.ntWebOnhandQuantity = ntWebOnhandQuantity;
    }


    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(LocalDateTime createdDatetime) {
        this.createdDatetime = createdDatetime;
    }


    public LocalDateTime getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public void setLastModifiedDatetime(LocalDateTime lastModifiedDatetime) {
        this.lastModifiedDatetime = lastModifiedDatetime;
    }


    public BigInteger getOnhandVal() {
        return onhandVal;
    }

    public void setOnhandVal(BigInteger onhandVal) {
        this.onhandVal = onhandVal;
    }


    public BigInteger getOnorderQty() {
        return onorderQty;
    }

    public void setOnorderQty(BigInteger onorderQty) {
        this.onorderQty = onorderQty;
    }


    public BigInteger getOnorderVal() {
        return onorderVal;
    }

    public void setOnorderVal(BigInteger onorderVal) {
        this.onorderVal = onorderVal;
    }


    public BigInteger getOnhandAvgVal() {
        return onhandAvgVal;
    }

    public void setOnhandAvgVal(BigInteger onhandAvgVal) {
        this.onhandAvgVal = onhandAvgVal;
    }


    public LocalDateTime getLastSaleDatei() {
        return lastSaleDatei;
    }

    public void setLastSaleDatei(LocalDateTime lastSaleDatei) {
        this.lastSaleDatei = lastSaleDatei;
    }


    public BigInteger getOnhandMedianVal() {
        return onhandMedianVal;
    }

    public void setOnhandMedianVal(BigInteger onhandMedianVal) {
        this.onhandMedianVal = onhandMedianVal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PosItemRollupEntity that = (PosItemRollupEntity) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(webReady, that.webReady);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, webReady, webReadyB2B, onhandQty, pickComQty, bkordComQty, holdComQty, outboundQty, webMinQty, lastRecptDatei, natWebOnhandQty, vicWebOnhandQuantity, tasWebOnhandQuantity, qldWebOnhandQuantity, nswWebOnhandQuantity, actWebOnhandQuantity, waWebOnhandQuantity, saWebOnhandQuantity, ntWebOnhandQuantity, createdDatetime, lastModifiedDatetime, onhandVal, onorderQty, onorderVal, onhandAvgVal, lastSaleDatei, onhandMedianVal);
    }
}

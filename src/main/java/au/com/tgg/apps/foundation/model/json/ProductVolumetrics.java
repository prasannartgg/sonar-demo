package au.com.tgg.apps.foundation.model.json;

import au.com.tgg.apps.foundation.util.JsonDateDeserializer;
import au.com.tgg.apps.foundation.util.JsonDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigInteger;
import java.time.LocalDate;


/**
 * PRODUCT_VOLUMETRICS
 * <p>
 * This is PRODUCT_VOLUMETRICS
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "length",
        "width",
        "height",
        "vm_weight",
        "lwh_uom",
        "weight",
        "net_weight",
        "weight_uom",
        "create_date",
        "last_modified_date"
})
public class ProductVolumetrics extends JsonHeader {

    @JsonProperty("prod_nbr")
    private String prodNbr;
    @JsonProperty("supplier_account")
    private String supplier_account;
    @JsonProperty("length")
    private Double length;
    @JsonProperty("width")
    private Double width;
    @JsonProperty("height")
    private Double height;
    @JsonProperty("vm_weight")
    private BigInteger vmWeight;
    @JsonProperty("lwh_uom")
    private String lwhUom;
    @JsonProperty("source")
    private String source;
    @JsonProperty("weight")
    private Double weight;
    @JsonProperty("net_weight")
    private Double netWeight;
    @JsonProperty("weight_uom")
    private String weightUom;
    @JsonProperty("create_date")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private LocalDate createDate;
    @JsonProperty("last_modified_date")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private LocalDate lastModifiedDate;

    public String getSupplier_account() {
        return supplier_account;
    }

    public void setSupplier_account(String supplier_account) {
        this.supplier_account = supplier_account;
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public BigInteger getVmWeight() {
        return vmWeight;
    }

    public void setVmWeight(BigInteger vmWeight) {
        this.vmWeight = vmWeight;
    }

    public String getLwhUom() {
        return lwhUom;
    }

    public void setLwhUom(String lwhUom) {
        this.lwhUom = lwhUom;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
    }

    public String getWeightUom() {
        return weightUom;
    }

    public void setWeightUom(String weightUom) {
        this.weightUom = weightUom;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getProdNbr() {
        return prodNbr;
    }

    public void setProdNbr(String prodNbr) {
        this.prodNbr = prodNbr;
    }
}

package au.com.tgg.apps.foundation.model.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductBarcode extends JsonHeader {

    /**
     * product field
     * (Required)
     *
     */
    @JsonProperty("prod_nbr")
    @JsonPropertyDescription("prod number")
    private String prodNbr;

    /**
     * product field
     * (Required)
     *
     */
    @JsonProperty("barcode")
    @JsonPropertyDescription("product field")
    private String barcode;

    /**
     * product field
     * (Required)
     *
     */
    @JsonProperty("barcode_type")
    @JsonPropertyDescription("product field")
    private String barcodeType;

    /**
     * product field
     * (Required)
     *
     */
    @JsonProperty("primary_ind")
    @JsonPropertyDescription("product field")
    private String primaryInd;

    /**
     * product field
     * (Required)
     *
     */
    @JsonProperty("deleted")
    @JsonPropertyDescription("product field")
    private String deleted;

    /**
     * product field
     * (Required)
     *
     */
    @JsonProperty("created_by")
    @JsonPropertyDescription("product field")
    private String createdBy;

    /**
     * product field
     * (Required)
     *
     */
    @JsonProperty("created_date")
    @JsonPropertyDescription("product field")
    private LocalDate createdDate;

    /**
     * product field
     * (Required)
     *
     */
    @JsonProperty("last_modified_by")
    @JsonPropertyDescription("product field")
    private String lastModifiedBy;

    /**
     * product field
     * (Required)
     *
     */
    @JsonProperty("last_modified_date")
    @JsonPropertyDescription("product field")
    private LocalDate lastModifiedDate;

    public String getProdNbr() {
        return prodNbr;
    }

    public void setProdNbr(String prodNbr) {
        this.prodNbr = prodNbr;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcodeType() {
        return barcodeType;
    }

    public void setBarcodeType(String barcodeType) {
        this.barcodeType = barcodeType;
    }

    public String getPrimaryInd() {
        return primaryInd;
    }

    public void setPrimaryInd(String primaryInd) {
        this.primaryInd = primaryInd;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}

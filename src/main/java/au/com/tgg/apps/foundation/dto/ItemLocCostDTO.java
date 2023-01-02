package au.com.tgg.apps.foundation.dto;

import java.math.BigDecimal;

public class ItemLocCostDTO {

    private String itemId;
    private Long quantityTotal;
    private BigDecimal unitCost;

    public ItemLocCostDTO(String itemId, Long quantityTotal, BigDecimal unitCost) {
        this.itemId = itemId;
        this.quantityTotal = quantityTotal;
        this.unitCost = unitCost;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Long getQuantityTotal() {
        return quantityTotal;
    }

    public void setQuantityTotal(Long quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }
}

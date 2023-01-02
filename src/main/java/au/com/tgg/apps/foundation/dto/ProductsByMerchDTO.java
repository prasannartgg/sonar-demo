package au.com.tgg.apps.foundation.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductsByMerchDTO {
    private String message;
    private boolean status;
    private List<ItemLocCostDTO> data = new ArrayList<>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<ItemLocCostDTO> getData() {
        return data;
    }

    public void setData(List<ItemLocCostDTO> data) {
        this.data = data;
    }
}

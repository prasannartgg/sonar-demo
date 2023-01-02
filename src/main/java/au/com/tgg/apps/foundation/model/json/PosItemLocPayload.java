package au.com.tgg.apps.foundation.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.List;

public class PosItemLocPayload {
    @JsonProperty("PosItemLocs")
    @JsonPropertyDescription("PosItemLoc insert list")
    private List<PosItemLoc> PosItemLocs;

    public List<PosItemLoc> getPosItemLocs() {
        return PosItemLocs;
    }

    public void setPosItemLocs(List<PosItemLoc> posItemLocs) {
        PosItemLocs = posItemLocs;
    }
}

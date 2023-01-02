package au.com.tgg.apps.foundation.model.json;

import com.fasterxml.jackson.annotation.JsonGetter;

public class JsonHeader {
    private String name;
    private JsonOperation operation;

    @JsonGetter("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonGetter("operations")
    public JsonOperation getOperation() {
        return operation;
    }

    public void setOperation(JsonOperation operation) {
        this.operation = operation;
    }
}

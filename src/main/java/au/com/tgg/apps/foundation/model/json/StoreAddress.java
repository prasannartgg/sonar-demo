package au.com.tgg.apps.foundation.model.json;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "state_name",
        "country_name",
        "addr",
        "addr_type",
        "primary_addr_type_ind",
        "primary_addr_ind",
        "add_1",
        "add_2",
        "city",
        "state",
        "country_id",
        "post",
        "contact_name",
        "contact_phone",
        "contact_email"
})
public class StoreAddress {
    @JsonProperty("state_name")
    private String stateName;
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("addr")
    private String addr;
    @JsonProperty("addr_type")
    private String addrType;
    @JsonProperty("primary_addr_type_ind")
    private String primaryAddrTypeInd;
    @JsonProperty("primary_addr_ind")
    private String primaryAddrInd;
    @JsonProperty("add_1")
    private String add1;
    @JsonProperty("add_2")
    private String add2;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;
    @JsonProperty("country_id")
    private String countryId;
    @JsonProperty("post")
    private String post;
    @JsonProperty("contact_name")
    private String contactName;
    @JsonProperty("contact_phone")
    private String contactPhone;
    @JsonProperty("contact_email")
    private String contactEmail;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("state_name")
    public String getStateName() {
        return stateName;
    }

    @JsonProperty("state_name")
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @JsonProperty("country_name")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("country_name")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonProperty("addr")
    public String getAddr() {
        return addr;
    }

    @JsonProperty("addr")
    public void setAddr(String addr) {
        this.addr = addr;
    }

    @JsonProperty("addr_type")
    public String getAddrType() {
        return addrType;
    }

    @JsonProperty("addr_type")
    public void setAddrType(String addrType) {
        this.addrType = addrType;
    }

    @JsonProperty("primary_addr_type_ind")
    public String getPrimaryAddrTypeInd() {
        return primaryAddrTypeInd;
    }

    @JsonProperty("primary_addr_type_ind")
    public void setPrimaryAddrTypeInd(String primaryAddrTypeInd) {
        this.primaryAddrTypeInd = primaryAddrTypeInd;
    }

    @JsonProperty("primary_addr_ind")
    public String getPrimaryAddrInd() {
        return primaryAddrInd;
    }

    @JsonProperty("primary_addr_ind")
    public void setPrimaryAddrInd(String primaryAddrInd) {
        this.primaryAddrInd = primaryAddrInd;
    }

    @JsonProperty("add_1")
    public String getAdd1() {
        return add1;
    }

    @JsonProperty("add_1")
    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    @JsonProperty("add_2")
    public String getAdd2() {
        return add2;
    }

    @JsonProperty("add_2")
    public void setAdd2(String add2) {
        this.add2 = add2;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("country_id")
    public String getCountryId() {
        return countryId;
    }

    @JsonProperty("country_id")
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @JsonProperty("post")
    public String getPost() {
        return post;
    }

    @JsonProperty("post")
    public void setPost(String post) {
        this.post = post;
    }

    @JsonProperty("contact_name")
    public String getContactName() {
        return contactName;
    }

    @JsonProperty("contact_name")
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @JsonProperty("contact_phone")
    public String getContactPhone() {
        return contactPhone;
    }

    @JsonProperty("contact_phone")
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @JsonProperty("contact_email")
    public String getContactEmail() {
        return contactEmail;
    }

    @JsonProperty("contact_email")
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}

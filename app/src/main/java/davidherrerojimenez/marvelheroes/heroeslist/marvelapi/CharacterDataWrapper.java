
package davidherrerojimenez.marvelheroes.heroeslist.marvelapi;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "code",
    "status",
    "copyright",
    "attributionText",
    "attributionHTML",
    "data",
    "etag"
})
public class CharacterDataWrapper {

    @JsonProperty("code")
    private String code;
    @JsonProperty("status")
    private String status;
    @JsonProperty("copyright")
    private String copyright;
    @JsonProperty("attributionText")
    private String attributionText;
    @JsonProperty("attributionHTML")
    private String attributionHTML;
    @JsonProperty("data")
    private CharacterDataContainer data;
    @JsonProperty("etag")
    private String etag;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    public CharacterDataWrapper withCode(String code) {
        this.code = code;
        return this;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public CharacterDataWrapper withStatus(String status) {
        this.status = status;
        return this;
    }

    @JsonProperty("copyright")
    public String getCopyright() {
        return copyright;
    }

    @JsonProperty("copyright")
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public CharacterDataWrapper withCopyright(String copyright) {
        this.copyright = copyright;
        return this;
    }

    @JsonProperty("attributionText")
    public String getAttributionText() {
        return attributionText;
    }

    @JsonProperty("attributionText")
    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public CharacterDataWrapper withAttributionText(String attributionText) {
        this.attributionText = attributionText;
        return this;
    }

    @JsonProperty("attributionHTML")
    public String getAttributionHTML() {
        return attributionHTML;
    }

    @JsonProperty("attributionHTML")
    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public CharacterDataWrapper withAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
        return this;
    }

    @JsonProperty("data")
    public CharacterDataContainer getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(CharacterDataContainer data) {
        this.data = data;
    }

    public CharacterDataWrapper withData(CharacterDataContainer data) {
        this.data = data;
        return this;
    }

    @JsonProperty("etag")
    public String getEtag() {
        return etag;
    }

    @JsonProperty("etag")
    public void setEtag(String etag) {
        this.etag = etag;
    }

    public CharacterDataWrapper withEtag(String etag) {
        this.etag = etag;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public CharacterDataWrapper withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}

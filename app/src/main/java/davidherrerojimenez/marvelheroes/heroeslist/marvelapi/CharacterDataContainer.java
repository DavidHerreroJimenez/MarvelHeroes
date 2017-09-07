
package davidherrerojimenez.marvelheroes.heroeslist.marvelapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "offset",
    "limit",
    "total",
    "count",
    "results"
})
public class CharacterDataContainer {

    @JsonProperty("offset")
    private String offset;
    @JsonProperty("limit")
    private String limit;
    @JsonProperty("total")
    private String total;
    @JsonProperty("count")
    private String count;
    @JsonProperty("results")
    private List<Character> results = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("offset")
    public String getOffset() {
        return offset;
    }

    @JsonProperty("offset")
    public void setOffset(String offset) {
        this.offset = offset;
    }

    public CharacterDataContainer withOffset(String offset) {
        this.offset = offset;
        return this;
    }

    @JsonProperty("limit")
    public String getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(String limit) {
        this.limit = limit;
    }

    public CharacterDataContainer withLimit(String limit) {
        this.limit = limit;
        return this;
    }

    @JsonProperty("total")
    public String getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(String total) {
        this.total = total;
    }

    public CharacterDataContainer withTotal(String total) {
        this.total = total;
        return this;
    }

    @JsonProperty("count")
    public String getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(String count) {
        this.count = count;
    }

    public CharacterDataContainer withCount(String count) {
        this.count = count;
        return this;
    }

    @JsonProperty("results")
    public List<Character> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Character> results) {
        this.results = results;
    }

    public CharacterDataContainer withResults(List<Character> results) {
        this.results = results;
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

    public CharacterDataContainer withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}


package davidherrerojimenez.marvelheroes.heroeslist.marvelapi;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resourceURI",
    "name"
})
public class ComicSummary implements Parcelable {

    public static final String TAG = "ComicSummary";

    @JsonProperty("resourceURI")
    private String resourceURI;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    protected ComicSummary(Parcel in) {
        resourceURI = in.readString();
        name = in.readString();
    }

    public static final Creator<ComicSummary> CREATOR = new Creator<ComicSummary>() {
        @Override
        public ComicSummary createFromParcel(Parcel in) {
            return new ComicSummary(in);
        }

        @Override
        public ComicSummary[] newArray(int size) {
            return new ComicSummary[size];
        }
    };

    @JsonProperty("resourceURI")
    public String getResourceURI() {
        return resourceURI;
    }

    @JsonProperty("resourceURI")
    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public ComicSummary withResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public ComicSummary withName(String name) {
        this.name = name;
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

    public ComicSummary withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(resourceURI);
        parcel.writeString(name);
    }
}

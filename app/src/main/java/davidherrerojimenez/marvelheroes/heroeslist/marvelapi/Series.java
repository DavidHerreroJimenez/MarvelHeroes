
package davidherrerojimenez.marvelheroes.heroeslist.marvelapi;

import android.os.Parcel;
import android.os.Parcelable;

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
    "available",
    "returned",
    "collectionURI",
    "items"
})
public class Series implements Parcelable {

    @JsonProperty("available")
    private String available;
    @JsonProperty("returned")
    private String returned;
    @JsonProperty("collectionURI")
    private String collectionURI;
    @JsonProperty("items")
    private List<SeriesSummary> items = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Series() {
    }

    protected Series(Parcel in) {
        available = in.readString();
        returned = in.readString();
        collectionURI = in.readString();
    }

    public static final Creator<Series> CREATOR = new Creator<Series>() {
        @Override
        public Series createFromParcel(Parcel in) {
            return new Series(in);
        }

        @Override
        public Series[] newArray(int size) {
            return new Series[size];
        }
    };

    @JsonProperty("available")
    public String getAvailable() {
        return available;
    }

    @JsonProperty("available")
    public void setAvailable(String available) {
        this.available = available;
    }

    public Series withAvailable(String available) {
        this.available = available;
        return this;
    }

    @JsonProperty("returned")
    public String getReturned() {
        return returned;
    }

    @JsonProperty("returned")
    public void setReturned(String returned) {
        this.returned = returned;
    }

    public Series withReturned(String returned) {
        this.returned = returned;
        return this;
    }

    @JsonProperty("collectionURI")
    public String getCollectionURI() {
        return collectionURI;
    }

    @JsonProperty("collectionURI")
    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public Series withCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
        return this;
    }

    @JsonProperty("items")
    public List<SeriesSummary> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<SeriesSummary> items) {
        this.items = items;
    }

    public Series withItems(List<SeriesSummary> items) {
        this.items = items;
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

    public Series withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(available);
        parcel.writeString(returned);
        parcel.writeString(collectionURI);
    }
}

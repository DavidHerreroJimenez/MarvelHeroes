
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
import davidherrerojimenez.marvelheroes.heroeslist.marvelapi.Comics;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "description",
    "modified",
    "resourceURI",
    "urls",
    "thumbnail",
    "comics",
    "stories",
    "events",
    "series"
})
public class Character implements Parcelable {

    public static final String TAG = "Character";

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("modified")
    private String modified;
    @JsonProperty("resourceURI")
    private String resourceURI;
    @JsonProperty("urls")
    private List<Url> urls = null;
    @JsonProperty("thumbnail")
    private Thumbnail thumbnail;
    @JsonProperty("comics")
    private Comics comics;
    @JsonProperty("stories")
    private Stories stories;
    @JsonProperty("events")
    private Events events;
    @JsonProperty("series")
    private Series series;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Character() {
    }

    protected Character(Parcel in) {
        id = in.readString();
        name = in.readString();
        description = in.readString();
        modified = in.readString();
        resourceURI = in.readString();
        urls = in.createTypedArrayList(Url.CREATOR);
        thumbnail = in.readParcelable(Thumbnail.class.getClassLoader());
        comics = in.readParcelable(Comics.class.getClassLoader());
        stories = in.readParcelable(Stories.class.getClassLoader());
        events = in.readParcelable(Events.class.getClassLoader());
        series = in.readParcelable(Series.class.getClassLoader());
    }

    public static final Creator<Character> CREATOR = new Creator<Character>() {
        @Override
        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Character withId(String id) {
        this.id = id;
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

    public Character withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Character withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("modified")
    public String getModified() {
        return modified;
    }

    @JsonProperty("modified")
    public void setModified(String modified) {
        this.modified = modified;
    }

    public Character withModified(String modified) {
        this.modified = modified;
        return this;
    }

    @JsonProperty("resourceURI")
    public String getResourceURI() {
        return resourceURI;
    }

    @JsonProperty("resourceURI")
    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Character withResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
        return this;
    }

    @JsonProperty("urls")
    public List<Url> getUrls() {
        return urls;
    }

    @JsonProperty("urls")
    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

    public Character withUrls(List<Url> urls) {
        this.urls = urls;
        return this;
    }

    @JsonProperty("thumbnail")
    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Character withThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    @JsonProperty("comics")
    public Comics getComics() {
        return comics;
    }

    @JsonProperty("comics")
    public void setComics(Comics comics) {
        this.comics = comics;
    }

    public Character withComics(Comics comics) {
        this.comics = comics;
        return this;
    }

    @JsonProperty("stories")
    public Stories getStories() {
        return stories;
    }

    @JsonProperty("stories")
    public void setStories(Stories stories) {
        this.stories = stories;
    }

    public Character withStories(Stories stories) {
        this.stories = stories;
        return this;
    }

    @JsonProperty("events")
    public Events getEvents() {
        return events;
    }

    @JsonProperty("events")
    public void setEvents(Events events) {
        this.events = events;
    }

    public Character withEvents(Events events) {
        this.events = events;
        return this;
    }

    @JsonProperty("series")
    public Series getSeries() {
        return series;
    }

    @JsonProperty("series")
    public void setSeries(Series series) {
        this.series = series;
    }

    public Character withSeries(Series series) {
        this.series = series;
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

    public Character withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(modified);
        parcel.writeString(resourceURI);
        parcel.writeTypedList(urls);
        parcel.writeParcelable(thumbnail, i);
        parcel.writeParcelable(comics, i);
        parcel.writeParcelable(stories, i);
        parcel.writeParcelable(events, i);
        parcel.writeParcelable(series, i);
    }
}

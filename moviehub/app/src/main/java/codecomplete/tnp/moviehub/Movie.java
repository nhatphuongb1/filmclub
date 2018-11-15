
package codecomplete.tnp.moviehub;


import android.os.Bundle;
import android.widget.ImageView;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.ArrayList;

public class Movie {

    public Movie() {
        this.favorite = false;
        this.poster_url = "";
        this.movie_url = "";
        this.id = "";
        this.nameVi = "";
        this.nameEng = "";
        this.director = "";
        this.publishDate = "";
        this.description = "";
        this.url = "";
        this.imdb = 0.0;
    }

    public Movie(String id, String nameVi, String nameEng, String movie_url, String poster_url) {
        this.id = id;
        this.favorite = false;
        this.director = "";
        this.publishDate = "";
        this.description = "";
        this.url = "";
        this.imdb = 0.0;
        this.movie_url = movie_url;
        this.poster_url = poster_url;
        this.nameVi = nameVi;
        this.nameEng = nameEng;

    }

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("favorite")
    @Expose
    private boolean favorite;
    @SerializedName("movie_url")
    @Expose
    private String movie_url;


    @SerializedName("categories")
    @Expose
    private ArrayList<String> categories;

    @SerializedName("poster_url")
    @Expose
    private String poster_url;


    @SerializedName("name_vi")
    @Expose
    private String nameVi;
    @SerializedName("name_eng")
    @Expose
    private String nameEng;
    @SerializedName("director")
    @Expose
    private String director;
    @SerializedName("publishDate")
    @Expose
    private String publishDate;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("imdb")
    @Expose
    private Double imdb;

    public String getMovie_url() {
        return movie_url;
    }

    public void setMovie_url(String movie_url) {
        this.movie_url = movie_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameVi() {
        return nameVi;
    }

    public void setNameVi(String nameVi) {
        this.nameVi = nameVi;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getImdb() {
        return imdb;
    }

    public void setImdb(Double imdb) {
        this.imdb = imdb;
    }

    public String getPoster_url() {
        return poster_url;
    }

    public void setPoster_url(String poster_url) {
        this.poster_url = poster_url;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("id", getId());
        bundle.putBoolean("favorite", isFavorite());
        bundle.putString("name_vi", getNameVi());
        bundle.putString("name_eng", getNameEng());
        bundle.putString("description", getDescription());
        bundle.putString("publish_date", getPublishDate());
        bundle.putString("url", getUrl());
        bundle.putString("movie_url", getMovie_url());
        bundle.putDouble("imdb", getImdb());
        bundle.putString("director", getDirector());
        bundle.putString("movie_url", getMovie_url());
        bundle.putString("poster_url", getPoster_url());
        bundle.putStringArrayList("categories", categories);

        return bundle;
    }

    public void getDataFromBundle(Bundle bundle) {
        setUrl(bundle.getString("url"));
        setId(bundle.getString("id"));
        setNameVi(bundle.getString("name_vi"));
        setNameEng(bundle.getString("name_eng"));
        setPublishDate(bundle.getString("publish_date"));
        setDescription(bundle.getString("description"));
        setDirector(bundle.getString("director"));
        setImdb(bundle.getDouble("imdb"));
        setMovie_url(bundle.getString("movie_url"));
        setPoster_url(bundle.getString("poster_url"));
        setFavorite(bundle.getBoolean("favorite"));
        setCategories(bundle.getStringArrayList("categories"));

    }

    public JsonObject getJSON() {
        JsonObject object = new JsonObject();
        object.addProperty("id", id);
        object.addProperty("name_vi", nameVi);
        object.addProperty("name_eng", nameEng);
        object.addProperty("publish_date", publishDate);
        object.addProperty("description", description);
        object.addProperty("director", director);
        object.addProperty("imdb", imdb);
        object.addProperty("movie_url", movie_url);
        object.addProperty("poster_url", poster_url);
        object.addProperty("url", url);
        object.addProperty("favorite", favorite);
        object.addProperty("categories", "");

        return object;
    }

}
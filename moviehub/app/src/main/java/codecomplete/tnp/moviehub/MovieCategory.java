package codecomplete.tnp.moviehub;

import android.os.Bundle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieCategory {

    private ArrayList<Movie> movies;
    private Category category;

    public MovieCategory(Category category, ArrayList<Movie> movies) {
        this.category = category;
        this.movies = movies;
    }


    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}

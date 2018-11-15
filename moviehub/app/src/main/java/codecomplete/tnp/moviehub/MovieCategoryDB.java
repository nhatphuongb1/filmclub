package codecomplete.tnp.moviehub;

import java.util.ArrayList;

public class MovieCategoryDB {
    private static MovieCategoryDB single_instance = null;
    public static ArrayList<MovieCategory> movieCategories = new ArrayList<>();

    private MovieCategoryDB() {
        prepareMovieData();
    }

    private void prepareMovieData() {
        MovieCategory category;

        String icon = "https://www.iconfinder.com/icons/1379476/download/png/32";
        for (int i = 0; i <= 10; i++) {

//            category = new MovieCategory(i + "", icon, "category " + i, MovieDB.getInstance().movies);
//            movieCategories.add(category);
        }

    }

    public static MovieCategoryDB getInstance() {
        if (single_instance == null)
            single_instance = new MovieCategoryDB();
        return single_instance;
    }
}

package codecomplete.tnp.moviehub;

import java.util.ArrayList;

class MovieDB {
    private static MovieDB single_instance = null;
    public static ArrayList<Movie> movies = new ArrayList<>();
    ;

    private MovieDB() {
        prepareMovieData();
    }


    private void prepareMovieData() {
        Movie movie;
        for (int i = 0; i < 10; i++) {
            movie = new Movie();
            movie.setId(i + "");
            movie.setNameVi("Ten " + i);
            movie.setNameEng("Name " + i);
            movie.setPublishDate("1/1/2018");
            movie.setMovie_url("ZMFxoGfErUA");
            movie.setPoster_url("https://cdn.pixabay.com/photo/2018/05/07/10/48/husky-3380548_960_720.jpg");
            movies.add(movie);
        }
    }
    // get all movies
    public  ArrayList<Movie> getMovies() {

        return new ArrayList<>();
    }
    public  ArrayList<Movie> getMovies(String category_id) {

        return new ArrayList<>();
    }
    public static MovieDB getInstance() {
        if (single_instance == null)
            single_instance = new MovieDB();
        return single_instance;
    }

}

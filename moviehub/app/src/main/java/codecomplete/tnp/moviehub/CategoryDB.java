package codecomplete.tnp.moviehub;

import java.util.ArrayList;

public class CategoryDB {
    private static CategoryDB single_instance = null;
    public static ArrayList<Category> categories = new ArrayList<>();
    ;

    private CategoryDB() {
        prepareMovieData();
    }


    public ArrayList<Category> getCategories() {

        return categories;
    }

    private void prepareMovieData() {
        for (int i = 0; i < 10; i++) {
            categories.add(new Category(i + "", "Thể loại " + i, "Category " + i, "https://freeiconshop.com/wp-content/uploads/edd/bulb-curvy-flat.png"));
        }
    }

    public static CategoryDB getInstance() {
        if (single_instance == null)
            single_instance = new CategoryDB();
        return single_instance;
    }

}

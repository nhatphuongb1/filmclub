package codecomplete.tnp.moviehub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String MAIN_TAG = "MAIN TAG";
    private ArrayList<MovieCategory> categoryDB;
    private RecyclerView rvMovieCategoryList;
    private RecyclerView rvCategoryButtonList;
    private ArrayList<Category> categories;
    private MovieCategoryAdapter movieCategoryAdapter;
    private CategoryButtonAdapter categoryButtonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    private void addControls() {
        addCategoryButton();

        addMovieCategoryList();
    }

    private void addCategoryButton() {

        categories = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            categories.add(new Category(i + "", "Thể loại " + i, "Category " + i, "https://freeiconshop.com/wp-content/uploads/edd/bulb-curvy-flat.png"));
        }
        Log.d(MAIN_TAG, categories.size() + "");
        rvCategoryButtonList = findViewById(R.id.rv_category_button_list);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvCategoryButtonList.setLayoutManager(mLayoutManager);
        rvCategoryButtonList.setItemAnimator(new DefaultItemAnimator());
        categoryButtonAdapter = new CategoryButtonAdapter(this, categories);
        rvCategoryButtonList.setAdapter(categoryButtonAdapter);
    }

    void categoriesData() {
        for (int i = 0; i < 10; i++) {
            categories.add(new Category(i + "", "Thể loại " + i, "Category " + i, "https://freeiconshop.com/wp-content/uploads/edd/bulb-curvy-flat.png"));
        }
        categoryButtonAdapter.notifyDataSetChanged();
    }

    private void addMovieCategoryList() {
        categoryDB = new ArrayList<>();
        rvMovieCategoryList = findViewById(R.id.rv_movie_category_list);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvMovieCategoryList.setLayoutManager(mLayoutManager);
        rvMovieCategoryList.setItemAnimator(new DefaultItemAnimator());
        movieCategoryAdapter = new MovieCategoryAdapter(this, categoryDB);
        rvMovieCategoryList.setAdapter(movieCategoryAdapter);
        data();
    }

    private void data() {
        String icon = "https://www.iconfinder.com/icons/1379476/download/png/32";
        ArrayList<Movie> movies = new ArrayList<>();

        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j < 100; j++) {
                // xep cac item nay` lai dung thu tu
                movies.add(new Movie(j + "",
                        "Ten" + j, "Name " + j, "u9Mv98Gr5pY",
                        "https://ins.dkn.tv/wp-content/uploads/2016/09/c18.jpg"));
                ;
                // khong
            }
            Category category = new Category(i + "", "Thể loại " + i, "Category " + i, "https://freeiconshop.com/wp-content/uploads/edd/bulb-curvy-flat.png");
            categoryDB.add(new MovieCategory(category, movies));
        }
        Log.e("listsize", categoryDB.size() + "");
        movieCategoryAdapter.notifyDataSetChanged();

    }

}

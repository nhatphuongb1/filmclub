package codecomplete.tnp.moviehub;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieCategoryGroupActivity extends AppCompatActivity {
    private Category category;
    private ArrayList<Movie> movies;
    private Intent intent;
    private ImageView imgIcon;
    private TextView tvName;
    private Bundle bundle;
    private RecyclerView recyclerView;
    private MovieItemAdapter movieItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_category_group);
        addControls();
    }

    private void addControls() {
        intent = getIntent();
        bundle = intent.getBundleExtra("category");
        category = new Category();
        category.setCategoryFromBundle(bundle);
        //
        imgIcon = findViewById(R.id.img_movie_category_group_icon);
        tvName = findViewById(R.id.tv_movie_category_group_name);
        recyclerView = findViewById(R.id.rv_movie_category_group);

        //

        movies = new ArrayList<>();
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        movieItemAdapter = new MovieItemAdapter(this, movies);
        recyclerView.setAdapter(movieItemAdapter);
        tvName.setText(category.getNameVi());
        Glide.with(this).load(category.getIcon()).into(imgIcon);
        addData();
    }

    private void addData() {

        for (int j = 0; j < 100; j++) {
            // xep cac item nay` lai dung thu tu
            movies.add(new Movie(j + "",
                    "Ten" + j, "Name " + j, "GIDoQsQyS0s",
                    "https://cdn.pixabay.com/photo/2018/05/07/10/48/husky-3380548_960_720.jpg"));
            ;
            // khong
        }
        movieItemAdapter.notifyDataSetChanged();

    }

}

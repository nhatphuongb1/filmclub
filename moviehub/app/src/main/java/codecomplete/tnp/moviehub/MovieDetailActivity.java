package codecomplete.tnp.moviehub;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MovieDetailActivity extends YouTubeBaseActivity {
    private final static String TAG = "MovieDetailActivity";
    private Intent intent;
    private TextView tvNameVi, tvNameEng, tvPublishDate, tvDescription, tvCategories;
    private ImageView imgPoster;
    private ImageButton btnPlay;
    private Movie movie;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    private ImageButton btnFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
//
        //get data
        intent = getIntent();
        movie = new Movie();
        movie.getDataFromBundle(intent.getBundleExtra("movie"));

        addControls();
        addEvents();

    }

    private void addEvents() {

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgPoster.setVisibility(View.INVISIBLE);
                btnPlay.setVisibility(View.INVISIBLE);
                Log.d(TAG, "onClick: Initializing Youtube Player");
                youTubePlayerView.initialize(DeveloperKey.DEVELOPER_KEY, onInitializedListener);

            }
        });

        // display view via YoutubePlayer  -  still not set play on background
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onInitializationSuccess: ");
                youTubePlayer.loadVideo(movie.getMovie_url());
            }


            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onInitializationFailure");
            }
        };
        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favoriteEvent();
            }
        });
    }

    private void favoriteEvent() {
        movie.setFavorite(!movie.isFavorite());
        btnFavorite.setBackgroundResource(movie.isFavorite() ? R.drawable.ic_favorite_red : R.drawable.ic_favorite_white);
    }

    private void addControls() {



        //description
        tvDescription = findViewById(R.id.tv_movie_detail_description);
        tvDescription.setText(movie.getDescription());

        //name_vi
        tvNameVi = findViewById(R.id.tv_movie_detail_name_vi);
        tvNameVi.setText(movie.getNameVi());

        //name_eng
        tvNameEng = findViewById(R.id.tv_movie_detail_name_eng);
        tvNameEng.setText(movie.getNameEng());

        //publish date
        tvPublishDate = findViewById(R.id.tv_movie_detail_publish_date);
        tvPublishDate.setText(movie.getPublishDate());

        //btn play
        btnPlay = findViewById(R.id.btn_movie_detail_play);

        //image poster
        imgPoster = findViewById(R.id.img_movie_detail_poster);
        Glide.with(this).load(movie.getPoster_url()).into(imgPoster);

        btnFavorite = findViewById(R.id.btn_movie_detail_favorite);

        // youtube view
        youTubePlayerView = findViewById(R.id.youtube_player_view);

        // categories textview
        tvCategories = findViewById(R.id.tv_movie_detail_categories);
//        tvCategories.setText(movie.getCategories().toString().replace('[', ' ').replace(']', ' ').trim());
    }

}

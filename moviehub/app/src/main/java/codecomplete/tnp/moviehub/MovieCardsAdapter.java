package codecomplete.tnp.moviehub;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieCardsAdapter extends RecyclerView.Adapter<MovieCardsAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<Movie> movies;
    private Movie movie;
    private View view;
    private AsyncTaskLoadImage asyncTaskLoadImage;

    public MovieCardsAdapter(Context context, ArrayList<Movie> movies) {
        this.movies = movies;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MovieCardsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = inflater.inflate(R.layout.movie_card, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieCardsAdapter.MyViewHolder myViewHolder, int i) {
        Movie movie = movies.get(i);
        myViewHolder.movie = movie;
        myViewHolder.tvNameVi.setText(movie.getNameVi());
        myViewHolder.tvNameEng.setText(movie.getNameEng());
//        new AsyncTaskLoadImage(myViewHolder.imgPoster, 128, 128).execute(movie.getPoster_url());
        Glide.with(view).load(movie.getPoster_url()).into(myViewHolder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNameEng, tvNameVi;
        private ImageView imgPoster;
        private ImageButton btnFavorite;
        private View view;
        private Movie movie;
        private Intent intent;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            addControls();
            addEvents();
        }

        private void addEvents() {

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), movie.getId() + "", Toast.LENGTH_SHORT).show();
                    intent = new Intent(v.getContext(), MovieDetailActivity.class);
                    intent.putExtra("movie", movie.toBundle());
                    v.getContext().startActivity(intent);
                }
            });

            btnFavorite.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {
                    //todo
                    favoriteEvent();
                }

                private void favoriteEvent() {
                    movie.setFavorite(!movie.isFavorite());
                    btnFavorite.setBackgroundResource(movie.isFavorite() ? R.drawable.ic_favorite_red : R.drawable.ic_favorite_white);
                }
            });
        }

        private void addControls() {

            tvNameEng = view.findViewById(R.id.tv_movie_card_name_eng);
            tvNameVi = view.findViewById(R.id.tv_movie_card_name_vi);
            imgPoster = view.findViewById(R.id.img_movie_card_poster);
            btnFavorite = view.findViewById(R.id.btn_movie_card_favorite);
//

        }
    }
}

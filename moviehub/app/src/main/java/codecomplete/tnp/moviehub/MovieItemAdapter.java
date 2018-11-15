package codecomplete.tnp.moviehub;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
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

public class MovieItemAdapter extends RecyclerView.Adapter<MovieItemAdapter.MyViewHolder> {
    private LayoutInflater layoutInflater;
    private ArrayList<Movie> movies;
    private View view;
    private Movie movie;

    public MovieItemAdapter(Context context, ArrayList<Movie> movies) {
        this.movies = movies;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = layoutInflater.inflate(R.layout.movie_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        movie = movies.get(position);
        holder.movie = movie;
        holder.tvIMDB.setText(movie.getImdb() + "");
        holder.tvPublishDate.setText(movie.getPublishDate());
        holder.tvNameVi.setText(movie.getNameVi());
        holder.tvNameEng.setText(movie.getNameEng());
        Glide.with(view).load(movie.getPoster_url()).into(holder.imagePoster);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNameVi, tvNameEng, tvIMDB, tvPublishDate;
        private ImageView imagePoster;
        private Intent intent;
        private Movie movie;
        private View view;
        private ImageButton btnFavorite;

        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            addControls();
            addEvents();
        }

        private void addEvents() {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), movie.getId() + "", Toast.LENGTH_SHORT).show();
                    intent = new Intent(v.getContext(), MovieDetailActivity.class);
                    intent.putExtra("movie", movie.toBundle());
                    v.getContext().startActivity(intent);
                }
            });
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
            tvNameEng = itemView.findViewById(R.id.tv_item_name_eng);
            tvNameVi = itemView.findViewById(R.id.tv_item_name_vi);
            tvIMDB = itemView.findViewById(R.id.tv_movie_item_imdb);
            tvPublishDate = itemView.findViewById(R.id.tv_item_publish_date);
            imagePoster = itemView.findViewById(R.id.img_item_poster);
            btnFavorite = itemView.findViewById(R.id.btn_movie_item_favorite);

        }

    }
}

package codecomplete.tnp.moviehub;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MovieCategoryAdapter extends RecyclerView.Adapter<MovieCategoryAdapter.MyViewHolder> {
    private ArrayList<MovieCategory> movieCategories;
    private LayoutInflater layoutInflater;
    private View view;

    public MovieCategoryAdapter(Context context, ArrayList<MovieCategory> movieCategory) {
        this.movieCategories = movieCategory;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MovieCategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = layoutInflater.inflate(R.layout.movie_category, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieCategoryAdapter.MyViewHolder myViewHolder, int i) {
        Log.e("size",movieCategories.size()+"");
        MovieCategory movieCategory = movieCategories.get(i);
        myViewHolder.category = movieCategory;

        Glide.with(view).load(movieCategory.getCategory().getIcon()).into(myViewHolder.imgCategoryIcon);
        myViewHolder.tvCategoryName.setText(movieCategory.getCategory().getNameVi());
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);

        myViewHolder.recyclerView.setLayoutManager(mLayoutManager);
        myViewHolder.recyclerView.setItemAnimator(new DefaultItemAnimator());
        myViewHolder.recyclerView.setAdapter(new MovieCardsAdapter(view.getContext(), movieCategory.getMovies()));
    }

    @Override
    public int getItemCount() {
        return movieCategories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private MovieCategory category;
        private ImageView imgCategoryIcon;
        private TextView tvCategoryName;
        private RecyclerView recyclerView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            addControls();
        }

        private void addControls() {
            imgCategoryIcon = itemView.findViewById(R.id.img_category_icon);
            tvCategoryName = itemView.findViewById(R.id.tv_category_name);
            recyclerView = itemView.findViewById(R.id.rv_movie_category);
        }
    }
}

package codecomplete.tnp.moviehub;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CategoryButtonAdapter extends RecyclerView.Adapter<CategoryButtonAdapter.MyViewHolder> {
    private View view;
    private LayoutInflater layoutInflater;
    private ArrayList<Category> categories;
    private Category category;

    public CategoryButtonAdapter(Context context, ArrayList<Category> categories) {
        this.categories = categories;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CategoryButtonAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = layoutInflater.inflate(R.layout.category_button, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryButtonAdapter.MyViewHolder myViewHolder, int i) {
        category = categories.get(i);
        myViewHolder.category = category;
//        myViewHolder.imgCategoryButtonIcon.setBackgroundColor(MyColors.getRandomColor());
        myViewHolder.tvCategoryButtonName.setText(category.getNameVi());
        Glide.with(view).load(category.getIcon()).into(myViewHolder.imgCategoryButtonIcon);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCategoryButtonIcon;
        private TextView tvCategoryButtonName;

        private Category category;
        private Intent intent;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            addControls();
            addEvent();

        }

        private void addEvent() {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent = new Intent(v.getContext(), MovieCategoryGroupActivity.class);
                    intent.putExtra("category", category.getBundle());
                    v.getContext().startActivity(intent);
                }
            });
        }

        private void addControls() {
            tvCategoryButtonName = itemView.findViewById(R.id.tv_category_button_name);
            imgCategoryButtonIcon = itemView.findViewById(R.id.img_category_button_icon);
        }
    }
}

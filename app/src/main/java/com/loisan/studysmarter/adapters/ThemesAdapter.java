package com.loisan.studysmarter.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loisan.studysmarter.R;
import com.loisan.studysmarter.model.Theme;

import java.util.List;
import java.util.zip.Inflater;

public class ThemesAdapter extends RecyclerView.Adapter<ThemesViewHolder> {

    Context context;
    List<Theme> themeList;

    public ThemesAdapter(Context context, List<Theme> themeList) {
        this.context = context;
        this.themeList = themeList;
    }

    @NonNull
    @Override
    public ThemesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.theme_list, parent, false);

        return new ThemesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThemesViewHolder holder, int position) {

        holder.list_iv.setImageDrawable(themeList.get(position).getImg());
        holder.list_points_tv.setText(themeList.get(position).getPrice()+"");

    }

    @Override
    public int getItemCount() {
        return themeList.size();
    }
}

class ThemesViewHolder extends RecyclerView.ViewHolder {

    ImageView list_iv;
    TextView list_points_tv;

    public ThemesViewHolder(@NonNull View itemView) {
        super(itemView);

        list_iv = itemView.findViewById(R.id.list_iv);
        list_points_tv = itemView.findViewById(R.id.list_points_tv);

    }
}

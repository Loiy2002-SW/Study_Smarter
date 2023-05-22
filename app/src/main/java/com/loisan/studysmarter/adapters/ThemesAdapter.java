package com.loisan.studysmarter.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loisan.studysmarter.R;
import com.loisan.studysmarter.model.Theme;
import com.loisan.studysmarter.sharedPreferences.SharedPreferencesManager;
import com.loisan.studysmarter.ui.HomeScreen;
import com.loisan.studysmarter.ui.StoreScreen;

import java.util.List;
import java.util.zip.Inflater;

public class ThemesAdapter extends RecyclerView.Adapter<ThemesViewHolder> {

    Context context;
    List<Theme> themeList;

    SharedPreferencesManager spm = SharedPreferencesManager.getInstance(context);

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

        //change the color of price to red if there is not enough stars.
        if(themeList.get(position).getPrice() > spm.getPointsNumber())
            holder.list_points_tv.setTextColor(context.getColor(R.color.red));
        else
            holder.list_points_tv.setTextColor(context.getColor(R.color.white));


        //change the state of theme(used, locked, available).
        int currentTheme = spm.getCurrentTheme();
        Log.println(Log.INFO,"lololo","The current theme number is:"+currentTheme);
        String openedThemes = spm.getOpenedThemes();

        if (openedThemes.contains((position)+"")){

            holder.list_state_tv.setText("");
            holder.list_state_tv.setCompoundDrawablesRelative(null, null, null, null);
            holder.list_points_tv.setVisibility(View.INVISIBLE);
        }

        if(currentTheme == position){
            holder.list_state_tv.setText(context.getString(R.string.used_str));
            holder.list_state_tv.setCompoundDrawablesRelative(null, null, null, null);

        }


        Log.println(Log.INFO,"lololo","The current themes:"+openedThemes);
        holder.list_iv.setImageDrawable(themeList.get(position).getImg());
        holder.list_points_tv.setText(themeList.get(position).getPrice()+"");

        holder.list_state_tv.setOnClickListener(v->

                {

                    int currentTh = spm.getCurrentTheme();
                    String openedThs = spm.getOpenedThemes();

                    if(openedThs.contains(String.valueOf(position)) && position != currentTh){

                        spm.setCurrentTheme(position);
                        holder.list_state_tv.setText(context.getString(R.string.used_str));

                        //change the theme
                        ((Activity)context).recreate();

                    }else if(!openedThs.contains(String.valueOf(position)) && themeList.get(position).getPrice() <= spm.getPointsNumber()){

                        Log.println(Log.INFO,"lololo","Unlock this theme");
                        spm.unlockTheme(String.valueOf(position));
                        spm.updatePointsNumber(spm.getPointsNumber() - themeList.get(position).getPrice());

                        //update the number of start from the sharedPref.
                        StoreScreen.store_points_tv.setText(spm.getPointsNumber() + "");

                        //change the theme
                        ((Activity)context).recreate();

                    }else if(!openedThs.contains(String.valueOf(position)) && themeList.get(position).getPrice() > spm.getPointsNumber()){

                        Toast.makeText(context, context.getString(R.string.not_enough_str), Toast.LENGTH_SHORT).show();

                    }


                }

        );


    }

    @Override
    public int getItemCount() {
        return themeList.size();
    }
}

class ThemesViewHolder extends RecyclerView.ViewHolder {

    ImageView list_iv;
    TextView list_points_tv, list_state_tv;

    public ThemesViewHolder(@NonNull View itemView) {
        super(itemView);

        list_iv = itemView.findViewById(R.id.list_iv);
        list_points_tv = itemView.findViewById(R.id.list_points_tv);
        list_state_tv = itemView.findViewById(R.id.list_state_tv);

    }
}

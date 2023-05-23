package com.loisan.studysmarter.ui;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.loisan.studysmarter.R;
import com.loisan.studysmarter.adapters.ThemesAdapter;
import com.loisan.studysmarter.model.Theme;
import com.loisan.studysmarter.sharedPreferences.SharedPreferencesManager;

import java.util.ArrayList;
import java.util.List;

public class StoreScreen extends AppCompatActivity {


    ConstraintLayout store_root_layout;

    TextView store_back_tv;
    public static TextView store_points_tv;
    RecyclerView store_themes_rv;


    SharedPreferencesManager spm = SharedPreferencesManager.getInstance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_screen);

        store_themes_rv = findViewById(R.id.store_themes_rv);
        store_back_tv = findViewById(R.id.store_back_tv);
        store_points_tv = findViewById(R.id.store_points_tv);


        store_root_layout = findViewById(R.id.store_root_layout);
        setStoreTheme(String.valueOf(spm.getCurrentTheme()), store_root_layout);

        //update the number of start from the sharedPref.
        store_points_tv.setText(spm.getPointsNumber() + "");


        List<Theme> themeList = new ArrayList<>();

        themeList.add(new Theme(getDrawable(R.drawable.ic_theme1), 6));
        themeList.add(new Theme(getDrawable(R.drawable.ic_theme2), 5));
        themeList.add(new Theme(getDrawable(R.drawable.ic_theme3), 4));
        themeList.add(new Theme(getDrawable(R.drawable.ic_theme4), 10));
        themeList.add(new Theme(getDrawable(R.drawable.ic_theme5), 13));
        themeList.add(new Theme(getDrawable(R.drawable.ic_theme6), 15));


        ThemesAdapter adapter = new ThemesAdapter(this, themeList);

        store_themes_rv.setAdapter(adapter);
        store_themes_rv.setLayoutManager(new LinearLayoutManager(this));



        store_back_tv.setOnClickListener(v -> onBackPressed());

    }


    public void setStoreTheme(String currentTheme, ConstraintLayout background){

        switch (currentTheme){

            case "0":
                background.setBackground(getDrawable(R.drawable.bg_store_theme1));
                getWindow().setStatusBarColor(getColor(R.color.teal_700));
                break;

            case "1":
                background.setBackground(getDrawable(R.drawable.bg_store_theme2));
                getWindow().setStatusBarColor(getColor(R.color.pink));
                break;

            case "2":
                background.setBackground(getDrawable(R.drawable.bg_store_theme3));
                getWindow().setStatusBarColor(getColor(R.color.purple_200));
                break;

            case "3":
                background.setBackground(getDrawable(R.drawable.bg_store_theme4));
                getWindow().setStatusBarColor(getColor(R.color.brown));
                break;

            case "4":
                background.setBackground(getDrawable(R.drawable.bg_store_theme5));
                getWindow().setStatusBarColor(getColor(R.color.green));
                break;

            case "5":
                background.setBackground(getDrawable(R.drawable.bg_store_theme6));
                getWindow().setStatusBarColor(getColor(R.color.gray));



        }





    }



    public void onBackPressed() {

            startActivity(new Intent(this, HomeScreen.class));
            finish();
        }
    }
package com.loisan.studysmarter.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.loisan.studysmarter.R;
import com.loisan.studysmarter.adapters.ThemesAdapter;
import com.loisan.studysmarter.model.Theme;

import java.util.ArrayList;
import java.util.List;

public class StoreScreen extends AppCompatActivity {

    TextView store_back_tv, store_points_tv;
    RecyclerView store_themes_rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_screen);

        store_themes_rv = findViewById(R.id.store_themes_rv);
        store_back_tv = findViewById(R.id.store_back_tv);
        store_points_tv = findViewById(R.id.store_points_tv);


        List<Theme> themeList = new ArrayList<>();

        themeList.add(new Theme(getDrawable(R.drawable.bg_home_theme1_store), 5));
        themeList.add(new Theme(getDrawable(R.drawable.bg_home_theme1_store), 2));
        themeList.add(new Theme(getDrawable(R.drawable.bg_home_theme1_store), 6));


        ThemesAdapter adapter = new ThemesAdapter(getApplicationContext(), themeList);

        store_themes_rv.setAdapter(adapter);
        store_themes_rv.setLayoutManager(new LinearLayoutManager(this));




    }













    public void onBackPressed() {

            startActivity(new Intent(this, HomeScreen.class));
            finish();
        }
    }
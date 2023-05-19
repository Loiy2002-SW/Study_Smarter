package com.loisan.studysmarter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {


    TextView home_setting_tv, home_points_tv, home_store_tv,
             home_timer_tv, home_start_pause_resume_tv, home_reset_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        home_setting_tv = findViewById(R.id.home_setting_tv);
        home_points_tv = findViewById(R.id.home_points_tv);
        home_store_tv = findViewById(R.id.home_store_tv);
        home_timer_tv = findViewById(R.id.home_timer_tv);
        home_start_pause_resume_tv = findViewById(R.id.home_start_pause_resume_tv);
        home_reset_tv = findViewById(R.id.home_reset_tv);



    }
}
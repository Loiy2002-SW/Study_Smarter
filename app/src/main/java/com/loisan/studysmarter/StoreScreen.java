package com.loisan.studysmarter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class StoreScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_screen);
    }

    public void onBackPressed() {

            startActivity(new Intent(this, HomeScreen.class));
            finish();
        }
    }
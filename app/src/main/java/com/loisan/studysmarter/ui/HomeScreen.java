package com.loisan.studysmarter.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.loisan.studysmarter.R;
import com.loisan.studysmarter.sharedPreferences.SharedPreferencesManager;
import com.loisan.studysmarter.ui.StoreScreen;

import java.util.Locale;

public class HomeScreen extends AppCompatActivity {


    ConstraintLayout home_root_layout;

    TextView home_setting_tv, home_points_tv, home_store_tv,
             home_timer_tv, home_start_pause_resume_tv, home_reset_tv;

    MediaPlayer mediaPlayer;
    Animation animation;


    SharedPreferencesManager spm = SharedPreferencesManager.getInstance(this);

    private static final long START_TIME_IN_MILLIS = 3000;//1500000

    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        home_root_layout = findViewById(R.id.home_root_layout);
        setHomeTheme(String.valueOf(spm.getCurrentTheme()), home_root_layout);

        home_setting_tv = findViewById(R.id.home_setting_tv);
        home_points_tv = findViewById(R.id.home_points_tv);
        home_store_tv = findViewById(R.id.home_store_tv);
        home_timer_tv = findViewById(R.id.home_timer_tv);
        home_start_pause_resume_tv = findViewById(R.id.home_start_pause_resume_tv);
        home_reset_tv = findViewById(R.id.home_reset_tv);

        home_points_tv.setText(spm.getPointsNumber()+"");


        home_start_pause_resume_tv.setOnClickListener(this::onTvClick);
        home_reset_tv.setOnClickListener(this::onTvClick);
        home_store_tv.setOnClickListener(this::onTvClick);


    }

    private void startTimer() {

        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                home_start_pause_resume_tv.setText(getString(R.string.start_str));
                home_start_pause_resume_tv.setVisibility(View.INVISIBLE);
                home_reset_tv.setVisibility(View.VISIBLE);

                spm.updatePointsNumber(spm.getPointsNumber()+1);
                home_points_tv.setText(spm.getPointsNumber()+"");

                mediaPlayer = MediaPlayer.create(HomeScreen.this, R.raw.sound_1);
                mediaPlayer.start();

                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                home_points_tv.startAnimation(animation);

                resetTimer();
            }
        }.start();

        mTimerRunning = true;
        home_start_pause_resume_tv.setText(getString(R.string.pause_str));
        home_start_pause_resume_tv.setVisibility(View.VISIBLE);
        home_reset_tv.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        home_start_pause_resume_tv.setText(getString(R.string.resume_str));
        home_reset_tv.setVisibility(View.VISIBLE);


    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        home_reset_tv.setVisibility(View.INVISIBLE);
        home_start_pause_resume_tv.setVisibility(View.VISIBLE);
        home_start_pause_resume_tv.setText(getString(R.string.start_str));
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        home_timer_tv.setText(timeLeftFormatted);
    }


    private void onTvClick(View view) {

        switch (view.getId()){

            case R.id.home_start_pause_resume_tv:
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
                break;

            case R.id.home_reset_tv:
                resetTimer();
                break;

            case R.id.home_store_tv:
                startActivity(new Intent(getApplicationContext(), StoreScreen.class));
                finish();

                break;

        }
    }


    public void setHomeTheme(String currentTheme, ConstraintLayout background){

        switch (currentTheme){

            case "0":
                background.setBackground(getDrawable(R.drawable.bg_home_theme1));
                getWindow().setStatusBarColor(getColor(R.color.teal_700));
                break;

            case "1":
                background.setBackground(getDrawable(R.drawable.bg_home_theme2));
                getWindow().setStatusBarColor(getColor(R.color.yellow));
                break;

            case "2":
                background.setBackground(getDrawable(R.drawable.bg_home_theme3));
                getWindow().setStatusBarColor(getColor(R.color.purple_200));
                break;

            case "3":
                background.setBackground(getDrawable(R.drawable.bg_home_theme4));
                getWindow().setStatusBarColor(getColor(R.color.brown));
                break;

            case "4":
                background.setBackground(getDrawable(R.drawable.bg_home_theme5));
                getWindow().setStatusBarColor(getColor(R.color.green));
                break;

            case "5":
                background.setBackground(getDrawable(R.drawable.bg_home_theme6));
                getWindow().setStatusBarColor(getColor(R.color.gray));



        }

    }


}
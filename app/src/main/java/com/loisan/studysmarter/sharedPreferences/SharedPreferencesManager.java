package com.loisan.studysmarter.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {

    private static final String SHARED_PREF_NAME= "SharedPreferences";
    private static final String KEY_CURRENT_THEME_IN_NUMBER= "keyTheme";
    private static final String KEY_OPENED_THEMES= "keyOpenedThemes";

    private static final String KEY_NUMBER_OF_POINTS= "KeyPoints";


    private static SharedPreferencesManager mInstance;
    private static Context mCtx;

    //singleton
    private SharedPreferencesManager(Context context){
        mCtx = context;
    }

    //initialization SharedPreferencesManager class only from this method
    public static synchronized SharedPreferencesManager getInstance(Context context){
        if (mInstance == null){
            mInstance = new SharedPreferencesManager(context);
        }

        return mInstance;
    }

    public void unlockTheme(String number){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_OPENED_THEMES, getOpenedThemes() + number);
        editor.apply();


    }

    public String getOpenedThemes(){

        SharedPreferences  sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        return sharedPreferences.getString(KEY_OPENED_THEMES,"");

    }

    public int getCurrentTheme(){

        SharedPreferences  sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        return sharedPreferences.getInt(KEY_CURRENT_THEME_IN_NUMBER,1);

    }

    public void setCurrentTheme(int number){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_CURRENT_THEME_IN_NUMBER, number);
        editor.apply();


    }

    public void updatePointsNumber(int number){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_NUMBER_OF_POINTS, number);
        editor.apply();


    }

    public int getPointsNumber(){

        SharedPreferences  sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        return sharedPreferences.getInt(KEY_NUMBER_OF_POINTS,0);

    }






}
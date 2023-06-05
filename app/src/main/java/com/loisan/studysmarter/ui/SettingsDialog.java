package com.loisan.studysmarter.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.loisan.studysmarter.R;
import com.loisan.studysmarter.sharedPreferences.SharedPreferencesManager;

public class SettingsDialog extends AppCompatDialogFragment {

    Switch swNotification, swSound;

    ConstraintLayout settings_layout;
    SharedPreferencesManager spm = SharedPreferencesManager.getInstance(getContext());
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //instance from AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_settings, null);


        swNotification = view.findViewById(R.id.settings_notification_sw);
        swSound = view.findViewById(R.id.settings_sound_sw);
        settings_layout = view.findViewById(R.id.settings_layout);

        setSettingsTheme(String.valueOf(spm.getCurrentTheme()), settings_layout);

        if (spm.isAllowedSound()){
            swSound.setChecked(true);
        }

        if (spm.isAllowedNotification()){
            swNotification.setChecked(true);
        }

        swNotification.setOnCheckedChangeListener((buttonView, isChecked) -> {
                spm.setKeyNotification(isChecked);
                swNotification.setChecked(isChecked);

        });

        swSound.setOnCheckedChangeListener((buttonView, isChecked) -> {
            spm.setKeySound(isChecked);
            swSound.setChecked(isChecked);
        });



        builder.setView(view);

        return builder.create();


    }

    public void setSettingsTheme(String currentTheme, ConstraintLayout background){

        switch (currentTheme){

            case "0":
                background.setBackground(getActivity().getDrawable(R.drawable.gradient_two_colors_theme1));
                break;

            case "1":
                background.setBackground(getActivity().getDrawable(R.drawable.gradient_two_colors_theme2));
                break;

            case "2":
                background.setBackground(getActivity().getDrawable(R.drawable.gradient_two_colors_theme3));
                break;

            case "3":
                background.setBackground(getActivity().getDrawable(R.drawable.gradient_two_colors_theme4));
                break;

            case "4":
                background.setBackground(getActivity().getDrawable(R.drawable.gradient_two_colors_theme5));
                break;

            case "5":
                background.setBackground(getActivity().getDrawable(R.drawable.gradient_three_colors_theme1));
                break;

            case "6":
                background.setBackground(getActivity().getDrawable(R.drawable.gradient_three_colors_theme2));
                break;

            case "7":
                background.setBackground(getActivity().getDrawable(R.drawable.gradient_three_colors_theme3));
                break;

            case "8":
                background.setBackground(getActivity().getDrawable(R.drawable.gradient_three_colors_theme4));
                break;

            case "9":
                background.setBackground(getActivity().getDrawable(R.drawable.gradient_three_colors_theme5));
                break;



        }

    }




}
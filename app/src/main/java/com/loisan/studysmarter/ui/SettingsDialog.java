package com.loisan.studysmarter.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

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


        if (spm.isAllowedSound()){
            swSound.setChecked(true);
        }

        if (spm.isAllowedNotification()){
            swNotification.setChecked(true);
        }

        swNotification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    spm.setKeyNotification(isChecked);
                    swNotification.setChecked(isChecked);

            }
        });

        swSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                spm.setKeySound(isChecked);
                swSound.setChecked(isChecked);
            }
        });



        builder.setView(view);

        return builder.create();


    }



}
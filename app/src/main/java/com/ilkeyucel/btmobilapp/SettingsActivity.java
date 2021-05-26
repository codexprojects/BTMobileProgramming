package com.ilkeyucel.btmobilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.ilkeyucel.btmobilapp.model.Answer;
import com.ilkeyucel.btmobilapp.model.Question;
import com.ilkeyucel.btmobilapp.model.Settings;
import com.ilkeyucel.btmobilapp.model.SharedPrefHelper;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    SeekBar examLevel;
    EditText examDuration;
    EditText examPoint;
    Button saveSettings;
    Settings settingsItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setView();
        getSettings();


        saveSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSettings();
            }
        });

    }

    public void setView() {
        examLevel = (SeekBar)findViewById(R.id.seekBar);
        examDuration = (EditText)findViewById(R.id.durationText);
        examPoint = (EditText)findViewById(R.id.pointText);
        saveSettings = (Button)findViewById(R.id.saveSettings);
    }

    public void getSettings() {
        List<Settings> settings = SharedPrefHelper.getSettingsList();
        if (settings != null) {
            Settings settingItem = settings.get(settings.size() - 1);
            examLevel.setProgress(settingItem.getExamLevel());
            examPoint.setText(settingItem.getExamPoint());
            examDuration.setText(settingItem.getExamDuration());
        }
    }

    public void saveSettings() {
        if (examDuration.getText().toString().isEmpty() || examPoint.getText().toString().isEmpty() || examLevel.getProgress() == 0) {
            new MaterialAlertDialogBuilder(SettingsActivity.this)
                    .setTitle("Hata")
                    .setMessage("Tüm alanlar zorunludur, lütfen kontrol edin.")
                    .setCancelable(true)
                    .setPositiveButton("Tamam", null)
                    .show();

        } else {
            settingsItem = new Settings();
            settingsItem.setExamDuration(examDuration.getText().toString());
            settingsItem.setExamPoint(examPoint.getText().toString());
            settingsItem.setExamLevel(examLevel.getProgress());

            List<Settings> settings = SharedPrefHelper.getSettingsList();
            if (settings == null) {
                settings = new ArrayList<>();
            }
            settings.add(settingsItem);

            SharedPrefHelper.putSettingsList(settings);
            new MaterialAlertDialogBuilder(SettingsActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage("Ayarlar başarıyla kayıt edildi, menü'ye dönmek için Tamam'a basın.")
                    .setCancelable(true)
                    .setPositiveButton("Tamam", (dialog, which) -> SettingsActivity.this.onBackPressed())
                    .show();
        }
    }
}
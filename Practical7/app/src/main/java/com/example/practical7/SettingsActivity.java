package com.example.practical7;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        final CheckBox checkBoxDarkMode = findViewById(R.id.checkBoxDarkMode);
        Button buttonSave = findViewById(R.id.buttonSave);

        boolean isDarkModeEnabled = sharedPreferences.getBoolean("dark_mode", false);
        checkBoxDarkMode.setChecked(isDarkModeEnabled);

        buttonSave.setOnClickListener(view -> {
            boolean darkMode = checkBoxDarkMode.isChecked();
            editor.putBoolean("dark_mode", darkMode);
            editor.apply();

            // Inform the user that settings are saved
            Toast.makeText(this, "Settings Saved", Toast.LENGTH_SHORT).show();
        });
    }
}

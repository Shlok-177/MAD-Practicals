package com.example.practical2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ExplicitIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);

        // Create an explicit intent to open another activity

        Button openTargetActivityButton = findViewById(R.id.openTargetActivityButton);

        openTargetActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an explicit intent to open the target activity
                Intent intent = new Intent(ExplicitIntentActivity.this, ImplicitIntentActivity.class);

                // Start the target activity
                startActivity(intent);
            }
        });

    }
}

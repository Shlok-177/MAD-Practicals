package com.example.practical2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button returnResultButton = findViewById(R.id.returnResultButton);

        returnResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to return a result to the starting activity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result_data", "This is the result data.");

                // Set the result and finish the activity
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}


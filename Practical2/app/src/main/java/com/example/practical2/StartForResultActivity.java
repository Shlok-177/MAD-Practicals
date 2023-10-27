package com.example.practical2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartForResultActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1; // Request code to identify the result

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_for_result);

        Button startForResultButton = findViewById(R.id.startForResultButton);

        startForResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an explicit intent to open ResultActivity for a result
                Intent intent = new Intent(StartForResultActivity.this, ResultActivity.class);

                // Start the target activity and wait for a result
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Handle the result returned from the target activity
                String resultData = data.getStringExtra("result_data");
                // You can perform actions with the resultData here
            } else {
                // Handle the case where the user canceled the operation
            }
        }
    }
}

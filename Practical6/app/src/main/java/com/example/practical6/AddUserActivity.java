package com.example.practical6;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddUserActivity extends AppCompatActivity {
    private EditText editTextName, editTextEmail;
    private DatabaseHelper databaseHelper;

    private void showSuccessDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);

        Button closeButton = dialog.findViewById(R.id.buttonClose);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        Button buttonSave = findViewById(R.id.buttonSave);

        databaseHelper = new DatabaseHelper(this);



        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUser();
            }
        });

        Button buttonShowData = findViewById(R.id.buttonShowData);
        buttonShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUserData();
            }
        });

    }
    private void showUserData() {
        Intent intent = new Intent(AddUserActivity.this, ShowDataActivity.class);
        startActivity(intent);
    }

    private void saveUser() {
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();

        if (!name.isEmpty() && !email.isEmpty()) {
            SQLiteDatabase database = databaseHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(DatabaseHelper.COLUMN_NAME, name);
            values.put(DatabaseHelper.COLUMN_EMAIL, email);
            long newRowId = database.insert(DatabaseHelper.TABLE_USERS, null, values);

            if (newRowId != -1) {
                // Data was successfully inserted
                editTextName.setText("");
                editTextEmail.setText("");
                showSuccessDialog();
            } else {
                // Handle the case where data insertion failed
            }
            database.close();
        } else {
            // Handle empty input fields
        }
    }
}

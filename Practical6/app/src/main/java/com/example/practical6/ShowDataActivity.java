package com.example.practical6;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShowDataActivity extends AppCompatActivity {
    private TableLayout tableLayout;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        tableLayout = findViewById(R.id.table);
        databaseHelper = new DatabaseHelper(this);

        // Retrieve data from the database
        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        String[] projection = {
                DatabaseHelper.COLUMN_ID,
                DatabaseHelper.COLUMN_NAME,
                DatabaseHelper.COLUMN_EMAIL
        };
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_USERS,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        // Populate the table with data
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
            String email = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_EMAIL));

            // Create a new row
            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT
            ));

            // Create and add TextViews for each data field
            TextView idTextView = createTextView(id + "");
            TextView nameTextView = createTextView(name);
            TextView emailTextView = createTextView(email);

            row.addView(idTextView);
            row.addView(nameTextView);
            row.addView(emailTextView);

            tableLayout.addView(row);
        }

        cursor.close();
        database.close();
    }

    private TextView createTextView(String text) {
        TextView textView = new TextView(this);
        textView.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT
        ));
        textView.setText(text);
        return textView;
    }
}

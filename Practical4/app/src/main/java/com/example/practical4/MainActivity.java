package com.example.practical4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StudentAdapter.OnDeleteClickListener {
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        studentList = new ArrayList<>();
        // Add student data to the list
        studentList.add(new Student("Shlok Jadeja", "43 Krishna tenament", R.drawable.shlok));
        studentList.add(new Student("Dhruv Kukadiya", "Gnadhinagar", R.drawable.dhruv));
        studentList.add(new Student("Joy", "Kalol", R.drawable.bin));

        studentAdapter = new StudentAdapter(studentList, this);
        recyclerView.setAdapter(studentAdapter);
    }

    @Override
    public void onDeleteClick(int position) {
        // Handle the delete button click here
        studentList.remove(position);
        studentAdapter.notifyItemRemoved(position);
    }
}

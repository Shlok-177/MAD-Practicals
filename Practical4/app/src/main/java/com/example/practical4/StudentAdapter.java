package com.example.practical4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private List<Student> studentList;
    private OnDeleteClickListener onDeleteClickListener;

    public StudentAdapter(List<Student> studentList, OnDeleteClickListener onDeleteClickListener) {
        this.studentList = studentList;
        this.onDeleteClickListener = onDeleteClickListener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.textName.setText("Name: " + student.getName());
        holder.textAddress.setText("Address: " + student.getAddress());
        holder.imagePhoto.setImageResource(student.getPhotoResId());

        holder.btnDelete.setOnClickListener(view -> {
            if (onDeleteClickListener != null) {
                onDeleteClickListener.onDeleteClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView textName;
        TextView textAddress;
        ImageView imagePhoto;
        Button btnDelete;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textAddress = itemView.findViewById(R.id.textAddress);
            imagePhoto = itemView.findViewById(R.id.imagePhoto);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }

    public interface OnDeleteClickListener {
        void onDeleteClick(int position);
    }

}


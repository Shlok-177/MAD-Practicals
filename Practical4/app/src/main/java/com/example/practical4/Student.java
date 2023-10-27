package com.example.practical4;

public class Student {
    private String name;
    private String address;
    private int photoResId;

    public Student(String name, String address, int photoResId) {
        this.name = name;
        this.address = address;
        this.photoResId = photoResId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPhotoResId() {
        return photoResId;
    }
}


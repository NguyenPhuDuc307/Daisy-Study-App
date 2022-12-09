package com.example.daisyapp.Models;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("userId")
    private String UserId;

    @SerializedName("fullName")
    private String FullName;

    @SerializedName("dob")
    private String Dob;

    @SerializedName("email")
    private String Email;

    public User() {
    }

    public User(String userId, String fullName, String dob, String email) {
        UserId = userId;
        FullName = fullName;
        Dob = dob;
        Email = email;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId='" + UserId + '\'' +
                ", FullName='" + FullName + '\'' +
                ", Dob='" + Dob + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}

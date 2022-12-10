package com.example.pieceworkapp;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties

public class User {
    private  String FullName;
    private  String email;
    private  Integer contactNumber;
    private  String profession;
    private  String category;
    private  Integer yearsOfExperience;

    public User(String username, String userEmail, String userContact, String userProfession, String contact, String userCategory, String userYears) {
    }

    public User(String fullName, String email, Integer contactNumber, String profession, String category, Integer yearsOfExperience) {
        FullName = fullName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.profession = profession;
        this.category = category;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getFullName() {
        return FullName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getContactNumber() {
        return contactNumber;
    }

    public String getProfession() {
        return profession;
    }

    public String getCategory() {
        return category;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }
}

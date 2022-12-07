package com.example.pieceworkapp;


import android.os.Bundle;

import com.example.pieceworkapp.databinding.ActivityCreateListBinding;


public class createList extends navigation {
    ActivityCreateListBinding activityCreateListBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        activityCreateListBinding = ActivityCreateListBinding.inflate(getLayoutInflater());
        setContentView(activityCreateListBinding.getRoot());
        allocateActivityTitle("Create list");
    }
}
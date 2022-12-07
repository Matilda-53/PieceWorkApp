package com.example.pieceworkapp;


import android.os.Bundle;

import com.example.pieceworkapp.databinding.ActivityCategoryBinding;

public class category extends navigation {
      ActivityCategoryBinding activityCategoryBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCategoryBinding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(activityCategoryBinding.getRoot());
        allocateActivityTitle("Category");

    }
}
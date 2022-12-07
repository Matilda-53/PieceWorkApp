package com.example.pieceworkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pieceworkapp.databinding.ActivityCategoryBinding;
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
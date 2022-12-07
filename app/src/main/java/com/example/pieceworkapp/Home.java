package com.example.pieceworkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pieceworkapp.databinding.ActivityHomeBinding;

public class Home extends navigation {
      ActivityHomeBinding activityHomeBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(activityHomeBinding.getRoot());
        allocateActivityTitle("Home");

    }
}
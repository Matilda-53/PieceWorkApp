package com.example.pieceworkapp;

import android.os.Bundle;

import com.example.pieceworkapp.databinding.ActivityInboxBinding;

public class Inbox extends navigation {
    ActivityInboxBinding activityInboxBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityInboxBinding = ActivityInboxBinding.inflate(getLayoutInflater());
        setContentView(activityInboxBinding.getRoot());
        allocateActivityTitle("Inbox");
    }
}
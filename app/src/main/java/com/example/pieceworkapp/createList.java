package com.example.pieceworkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class createList extends AppCompatActivity {
    TextView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);
        list = (TextView) findViewById(R.id.list);

    }
}
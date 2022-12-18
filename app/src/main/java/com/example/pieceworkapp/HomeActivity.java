package com.example.pieceworkapp;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pieceworkapp.databinding.ActivityHome2Binding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class HomeActivity extends navigation {


    private RecyclerView recyclerView;
    private TextInputEditText textInputEditText;

    ArrayList<Category2> list;
    DatabaseReference databaseReference;
    CategoryAdapter adapter;
    ActivityHome2Binding activityHomeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        activityHomeBinding = ActivityHome2Binding.inflate(getLayoutInflater());
        setContentView(activityHomeBinding.getRoot());
        allocateActivityTitle("Home");

        recyclerView = findViewById(R.id.recycleView_categories);
        list = new ArrayList<>();
        list = getData();
        adapter = new CategoryAdapter(this, list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(HomeActivity.this));

    }

    private ArrayList<Category2> getData()
    {
        ArrayList<Category2> list = new ArrayList<>();
        list.add(new Category2("Engineering", R.drawable.ic_baseline_engineering_50));
        list.add(new Category2("Education", R.drawable.ic_baseline_school_50));
        list.add(new Category2("Health", R.drawable.ic_baseline_local_hospital_50));
        list.add(new Category2("Communication", R.drawable.ic_baseline_engineering_50));

        return list;
    }
}
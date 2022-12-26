package com.example.pieceworkapp;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pieceworkapp.databinding.ActivityCategoryBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class category extends navigation {
      ActivityCategoryBinding activityCategoryBinding;
      RecyclerView recyclerView;
      ArrayList<User> list;
      DatabaseReference databaseReference;
      MyAdapter adapter;
      Bundle extras;
      String sReceiver;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(category.this, createList.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCategoryBinding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(activityCategoryBinding.getRoot());
        allocateActivityTitle("Category");

        recyclerView = findViewById(R.id.recycleView);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("users");
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this, list);
        recyclerView.setAdapter(adapter);
        extras = getIntent().getExtras();

        sReceiver = extras.getString("categoryName");
        initLayouts();


    }

    private void initLayouts()
    {
        if(extras!=null && sReceiver.contains("engines"))
        {
            databaseReference.orderByChild("category").equalTo("Engineering").
                    addValueEventListener(new ValueEventListener() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    list.clear();
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){

                        User user = dataSnapshot.getValue(User.class);
                        list.add(user);
                    }
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error)
                {
                    Toast.makeText(category.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }else if(extras!=null && sReceiver.contains("edu"))
        {
            databaseReference.orderByChild("category").equalTo("Education").
                    addValueEventListener(new ValueEventListener() {
                        @SuppressLint("NotifyDataSetChanged")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            list.clear();
                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){

                                User user = dataSnapshot.getValue(User.class);
                                list.add(user);
                            }
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error)
                        {
                            Toast.makeText(category.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });


        }else if(extras!=null && sReceiver.contains("health"))
        {
            databaseReference.orderByChild("category").equalTo("Health").
                    addValueEventListener(new ValueEventListener() {
                        @SuppressLint("NotifyDataSetChanged")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            list.clear();
                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){

                                User user = dataSnapshot.getValue(User.class);
                                list.add(user);
                            }
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error)
                        {
                            Toast.makeText(category.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });


        }else if(extras!=null && sReceiver.contains("comms"))
        {
            databaseReference.orderByChild("category").equalTo("communication").
                    addValueEventListener(new ValueEventListener() {
                        @SuppressLint("NotifyDataSetChanged")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            list.clear();
                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){

                                User user = dataSnapshot.getValue(User.class);
                                list.add(user);
                            }
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error)
                        {
                            Toast.makeText(category.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });

        }else if(extras!=null && sReceiver.contains("all"))
        {
            databaseReference.addValueEventListener(new ValueEventListener() {
                        @SuppressLint("NotifyDataSetChanged")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            list.clear();
                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){

                                User user = dataSnapshot.getValue(User.class);
                                list.add(user);
                            }
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error)
                        {
                            Toast.makeText(category.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });

        }
    }
}
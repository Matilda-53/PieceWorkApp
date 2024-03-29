package com.example.pieceworkapp;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
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
      private Button message;


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
        message = findViewById(R.id.msg_extra);

        sReceiver = extras.getString("categoryName");
        initLayouts();

//        msg_extra.setOnClickListener(view -> startActivity(new Intent(this, Inbox.class)));



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

        }else if(extras!=null && sReceiver.contains("agr"))
        {
            databaseReference.orderByChild("category").equalTo("Agriculture").
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

        }else if(extras!=null && sReceiver.contains("arch"))
        {
            databaseReference.orderByChild("category").equalTo("Architecture & Construction").
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

        }else if(extras!=null && sReceiver.contains("Busi"))
        {
            databaseReference.orderByChild("category").equalTo("Business Management").
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

        }else if(extras!=null && sReceiver.contains("fin"))
        {
            databaseReference.orderByChild("category").equalTo("Finance").
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

        }else if(extras!=null && sReceiver.contains("hosp"))
        {
            databaseReference.orderByChild("category").equalTo("Hospitality & Tourism").
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

        }else if(extras!=null && sReceiver.contains("inf"))
        {
            databaseReference.orderByChild("category").equalTo("Information & Technology").
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

        }else if(extras!=null && sReceiver.contains("fin"))
        {
            databaseReference.orderByChild("category").equalTo("Finance").
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

        }else if(extras!=null && sReceiver.contains("manf"))

        {
            databaseReference.orderByChild("category").equalTo("Manufacturing").
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

        }else if(extras!=null && sReceiver.contains("mark"))
        {
            databaseReference.orderByChild("category").equalTo("Marketing").
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

        }else if(extras!=null && sReceiver.contains("log"))
        {
            databaseReference.orderByChild("category").equalTo("Logistics").
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

        }

        else if(extras!=null && sReceiver.contains("all"))
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
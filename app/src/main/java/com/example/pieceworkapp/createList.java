package com.example.pieceworkapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pieceworkapp.databinding.ActivityCreateListBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class createList extends navigation {
  Button btnCreateList, btnCategory;
  EditText FullName, email, contactNumber, profession, category, yearsOfExperience;
  DatabaseReference databaseUsers;

    ActivityCreateListBinding activityCreateListBinding;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        activityCreateListBinding = ActivityCreateListBinding.inflate(getLayoutInflater());
        setContentView(activityCreateListBinding.getRoot());
        allocateActivityTitle("Create list");

        btnCreateList = findViewById(R.id.btnCreateList);
        btnCategory = findViewById(R.id.btnCategory);
        FullName = findViewById(R.id.text_name);
        email = findViewById(R.id.MaILe);
        contactNumber = findViewById(R.id.conta);
        profession = findViewById(R.id.professional);
        category = findViewById(R.id.choose);
        yearsOfExperience = findViewById(R.id.Exp);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseUsers = FirebaseDatabase.getInstance().getReference().child("users");

        btnCreateList.setOnClickListener(view -> InsertData());
        btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(createList.this, category.class));
                finish();
            }
        });

    }

    private void InsertData() {
        String username = FullName.getText().toString();
        String userEmail = email.getText().toString();
        String userContact = contactNumber.getText().toString();
        String userProfession = profession.getText().toString();
        String userCategory = category.getText().toString();
        String userYears = yearsOfExperience.getText().toString();
        String id =databaseUsers.push().getKey();

        User user = new User();
        user.setCategory(userCategory);
        user.setEmail(userEmail);
        user.setContactNumber(userContact);
        user.setProfession(userProfession);
        user.setYearsOfExperience(userYears);
        user.setFullName(username);
        user.setUid(firebaseAuth.getUid());



        HashMap<String, Object> mHashmap = new HashMap<>();
        mHashmap.put("category", userCategory);
        mHashmap.put("contactNumber", userContact);
        mHashmap.put("email", userEmail);
        mHashmap.put("fullName", username);
        mHashmap.put("profession", userProfession);
        mHashmap.put("uid", firebaseAuth.getUid());
        mHashmap.put("yearsOfExperience", userYears);

        databaseUsers.child(id).setValue(mHashmap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

                Toast.makeText(createList.this, "successfully created list", Toast.LENGTH_SHORT).show();

            }
        });





//                databaseUsers.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot)
//                    {
//
//
//                        // Write a message to the
//
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error)
//                    {
//
//                        Toast.makeText(createList.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });

    }
}
package com.example.pieceworkapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.example.pieceworkapp.databinding.ActivityCreateListBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.xml.transform.sax.SAXResult;


public class createList extends navigation {
  Button btnCreateList, btnCategory;
  EditText FullName, email, contactNumber, profession, category, yearsOfExperience;
  DatabaseReference databaseUsers;

    ActivityCreateListBinding activityCreateListBinding;

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
        databaseUsers = FirebaseDatabase.getInstance().getReference();

        btnCreateList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertData();

            }
        });
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

        User user = new User(username, userEmail, userContact, userProfession, userContact,userCategory, userYears);
                databaseUsers.child("users").child(id).setValue(user)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                            }
                        });

    }
}
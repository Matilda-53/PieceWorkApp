package com.example.pieceworkapp;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Logout extends navigation {
    TextView LogOut;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        LogOut = (TextView)findViewById(R.id.LogOut);
        mAuth = FirebaseAuth.getInstance();


//        LogOut.setOnClickListener(view -> startActivity(new Intent(Logout.this, MainActivity.class)));
//        LogOut.setOnClickListener(view -> {
//            Intent intent = new Intent(Logout.this, MainActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
//
//        });
    }

}
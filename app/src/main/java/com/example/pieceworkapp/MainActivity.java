package com.example.pieceworkapp;

import static android.app.ProgressDialog.show;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView signup;
    EditText email, password;
    ProgressDialog progressDialog;
    Button loginbtn;
    String emailPattern = "[a-zA-Z0-9,_-]+@[a-z]+\\.+[a-z]+";
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        email = (EditText) findViewById(R.id.UserName);
        password = (EditText) findViewById(R.id.PassWord);
        signup = (TextView) findViewById(R.id.signup);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        loginbtn = (MaterialButton) findViewById(R.id.logIN);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUP.class));
            }
        });


        //admin
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerforLogin();

                //correct
            }
        });
    }

    private void PerforLogin() {
        String UserName = email.getText().toString();
        String PassWord = password.getText().toString();

        if(!Patterns.EMAIL_ADDRESS.matcher(UserName).matches()) {
            email.setError("Enter connect email");
        } else if (PassWord.isEmpty() || PassWord.length() < 6) {
            password.setError("Enter proper password");

        } else {
            progressDialog.setMessage("Please wait for login....");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(UserName, PassWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();

                        sendUserToNextActivity();
                        Toast.makeText(MainActivity.this, "login successiful", Toast.LENGTH_SHORT).show();
                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "" +task.getException(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(MainActivity.this, Home.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
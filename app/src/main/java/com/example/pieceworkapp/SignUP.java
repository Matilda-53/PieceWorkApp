package com.example.pieceworkapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUP extends AppCompatActivity {
     TextView alreadyHaveAccount;
     EditText fullname, Username2, Email, Password1, ConfirmPassword;
     Button nbtRegister;
     String emailPattern = "[a-zA-Z0-9,_-]+@[a-z]+\\.+[a-z]+";
     ProgressDialog progressDialog;
     FirebaseAuth mAuth;
     FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
         alreadyHaveAccount = (TextView) findViewById(R.id.alreadyHaveAccount);
         fullname = (EditText) findViewById(R.id.full_name);
         Email = (EditText) findViewById(R.id.email);
         Username2 = (EditText) findViewById(R.id.username2);
         Password1 = (EditText) findViewById(R.id.password1);
         ConfirmPassword = (EditText) findViewById(R.id.confirm);
         progressDialog = new ProgressDialog(this);
         mAuth= FirebaseAuth.getInstance();
         mUser = mAuth.getCurrentUser();

        MaterialButton btnRegister = (MaterialButton) findViewById(R.id.btnRegister);

        alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           startActivity(new Intent(SignUP.this, MainActivity.class));
       }
   });

        //admin
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PerforAuth();

//                perfoAuth();
            }

        });

    }

    private void PerforAuth() {
        String email = Email.getText().toString();
        String password1 =Password1.getText().toString();
        String confirm =ConfirmPassword.getText().toString();


//        if(!email.matches(emailPattern)){
//
//        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Email.setError("Enter connect email");

        }


        else if(password1.isEmpty() || password1.length() <6){
            Password1.setError("Enter proper password");
        } else if (!password1.equals(confirm)){
            ConfirmPassword.setError("password does not match fields");
        } else {
            progressDialog.setMessage("Please wait for registration....");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email, password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        
                        sendUserToNextActivity();
                        Toast.makeText(SignUP.this, "Registration successful", Toast.LENGTH_SHORT).show();
                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(SignUP.this, "" +task.getException(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }

    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(SignUP.this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
//        finish();
    }
}
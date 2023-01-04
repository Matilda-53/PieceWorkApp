package com.example.pieceworkapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pieceworkapp.databinding.ActivityInboxBinding;

public class Inbox extends navigation {
    ActivityInboxBinding activityInboxBinding;


    public static String getInbox() {
        return getInbox();
    }

    Bundle extras;
    String s, mail_str;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityInboxBinding = ActivityInboxBinding.inflate(getLayoutInflater());
        setContentView(activityInboxBinding.getRoot());
        allocateActivityTitle("Inbox");

        extras = getIntent().getExtras();
        s = extras.getString("userData");

        if(s.contains("client"))
        {

            mail_str = getIntent().getStringExtra("mailUser");

            activityInboxBinding.emailAddress.setText(mail_str);
            activityInboxBinding.emailAddress.setEnabled(false);


        }

        activityInboxBinding.sendBtn.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("QueryPermissionsNeeded")
            @Override
            public void onClick(View view) {

                String email = activityInboxBinding.emailAddress.getText().toString();
                String subject = activityInboxBinding.subjects.getText().toString();
                String message = activityInboxBinding.messagebox.getText().toString();

//
//                String[] addresses = email.split(",");

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, message);

                // set type of intent
                intent.setType("message/rfc822");

                if (intent.resolveActivity(getPackageManager()) != null) {

                    startActivity(intent);

                } else {
                    Toast.makeText(Inbox.this, "No app installed", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
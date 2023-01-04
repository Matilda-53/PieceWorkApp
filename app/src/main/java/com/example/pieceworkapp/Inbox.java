package com.example.pieceworkapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pieceworkapp.databinding.ActivityInboxBinding;

public class Inbox extends navigation {
    ActivityInboxBinding activityInboxBinding;


    public static String getInbox() {
        return getInbox();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityInboxBinding = ActivityInboxBinding.inflate(getLayoutInflater());
        setContentView(activityInboxBinding.getRoot());
        allocateActivityTitle("Inbox");

        activityInboxBinding.sendBtn.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("QueryPermissionsNeeded")
            @Override
            public void onClick(View view) {

                String email = activityInboxBinding.emailAddress.getText().toString();
                String subject = activityInboxBinding.subjects.getText().toString();
                String message = activityInboxBinding.messagebox.getText().toString();


                String[] addresses = email.split(",");

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "subjects");
                intent.putExtra(Intent.EXTRA_SUBJECT, "messagebox");

                if (intent.resolveActivity(getPackageManager()) != null) {

                    startActivity(intent);

                } else {
                    Toast.makeText(Inbox.this, "No app installed", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
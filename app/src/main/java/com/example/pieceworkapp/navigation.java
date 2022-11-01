package com.example.pieceworkapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class navigation extends AppCompatActivity  {
    TextView list;
    TextView cate;
    TextView in_box;
    TextView home;



    private  DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_navigation);
         drawerLayout =findViewById(R.id.nav_view);
         Toolbar toolbar = findViewById(R.id.toolbar);
         NavigationView navigationView = findViewById(R.id.navigation_view);
         list = (TextView) findViewById(R.id.list);
         cate = (TextView) findViewById(R.id.cate);
         in_box = (TextView) findViewById(R.id.in_box);
         home = (TextView) findViewById(R.id.home);



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //create list
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(navigation.this, createList.class));

            }
        });

        cate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(navigation.this, category.class));

            }
        });

        in_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(navigation.this, Inbox.class));

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(navigation.this, Home.class));

            }
        });
    }
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
          else {
              super.onBackPressed();
        }
    }
}
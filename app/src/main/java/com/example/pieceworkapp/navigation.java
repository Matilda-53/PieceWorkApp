package com.example.pieceworkapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class navigation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
          DrawerLayout drawerLayout;

    @Override
    public void setContentView(View view) {
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_navigation, drawerLayout);
        FrameLayout container = drawerLayout.findViewById(R.id.fragment_container);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = drawerLayout.findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);

        switch (item.getItemId()){

            case R.id.home:
                startActivity(new Intent(this, Home.class));
                overridePendingTransition(0,0);
                break;
            case R.id.inbox:
                startActivity(new Intent(this, Inbox.class));
                overridePendingTransition(0,0);
                break;

            case R.id.createList:
                startActivity(new Intent(this, createList.class));
                overridePendingTransition(0,0);
                break;

            case R.id.category:
                startActivity(new Intent(this, category.class));
                overridePendingTransition(0,0);
                break;
        }
        return false;
    }
    protected void allocateActivityTitle(String titleString){
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(titleString);
        }
    }


    //    TextView list;
//    TextView cate;
//    TextView in_box;
//    TextView home;
//
//
//
//    private  DrawerLayout drawerLayout;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//         super.onCreate(savedInstanceState);
//         setContentView(R.layout.activity_navigation);
//         drawerLayout =findViewById(R.id.nav_view);
//         Toolbar toolbar = findViewById(R.id.toolbar);
//         NavigationView navigationView = findViewById(R.id.navigation_view);
//         list = (TextView) findViewById(R.id.list);
//         cate = (TextView) findViewById(R.id.cate);
//         in_box = (TextView) findViewById(R.id.in_box);
//         home = (TextView) findViewById(R.id.home);
//
//
//
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//
//        //create list
//        list.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(navigation.this, createList.class));
//
//            }
//        });
//
//        cate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(navigation.this, category.class));
//
//            }
//        });
//           //inbox
//        in_box.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(navigation.this, Inbox.class));
//
//            }
//        });
//        //home
//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(navigation.this, Home.class));
//
//            }
//        });
//    }
//    @Override
//    public void onBackPressed(){
//        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
//            drawerLayout.closeDrawer(GravityCompat.START);
//        }
//          else {
//              super.onBackPressed();
//        }
//    }
//    private void sendUserToNextActivity() {
//        Intent intent = new Intent(navigation.this, Home.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
//
//    }

}
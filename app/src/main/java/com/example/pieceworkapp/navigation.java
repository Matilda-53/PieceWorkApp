package com.example.pieceworkapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

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

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);

        switch (item.getItemId()){

            case R.id.home:
                startActivity(new Intent(this, HomeActivity.class));
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



}
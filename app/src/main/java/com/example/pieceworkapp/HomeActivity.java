package com.example.pieceworkapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pieceworkapp.databinding.ActivityHome2Binding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class HomeActivity extends navigation{


    private RecyclerView recyclerView;
    private TextInputEditText textInputEditText;
    SearchView searchView;
    ArrayList<Category2> list;
    DatabaseReference databaseReference;
    CategoryAdapter adapter;
    ActivityHome2Binding activityHomeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        activityHomeBinding = ActivityHome2Binding.inflate(getLayoutInflater());
        setContentView(activityHomeBinding.getRoot());
        allocateActivityTitle("Home");
        searchView = findViewById(R.id.search);

        recyclerView = findViewById(R.id.recycleView_categories);
        list = new ArrayList<>();
        list = getData();
        adapter = new CategoryAdapter(this, list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(HomeActivity.this));


        searchView.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });

    }

//    private void filter(String newText) {
//        List<Category2>filteredList = new ArrayList<>();
//        for (Category2 item: list){
//            if (item.getName().toLowerCase().contains(newText.toLowerCase()));
//            filteredList.add(item);
//        }
//        MyAdapter.filterList(filteredList);
//    }

    private void filter(String text) {
        // creating a new array list to filter our data.
        ArrayList<Category2> filteredlist = new ArrayList<Category2>();

        // running a for loop to compare elements.
        for (Category2 item : list) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            adapter.filterList(filteredlist);
        }
    }

    private ArrayList<Category2> getData()
    {
        ArrayList<Category2> list = new ArrayList<>();
        list.add(new Category2("Engineering", R.drawable.ic_baseline_engineering_50));
        list.add(new Category2("Education", R.drawable.ic_baseline_school_50));
        list.add(new Category2("Health", R.drawable.ic_baseline_local_hospital_50));
        list.add(new Category2("Communication", R.drawable.ic_baseline_perm_phone_msg_24));
        list.add(new Category2("Agriculture", R.drawable.ic_baseline_agriculture_24));
        list.add(new Category2("Architecture & Construction", R.drawable.ic_baseline_architecture_24));
        list.add(new Category2("Business Management", R.drawable.ic_baseline_business_center_24));
        list.add(new Category2("Finance", R.drawable.ic_baseline_monetization_on_24));
        list.add(new Category2("Hospitality & Tourism", R.drawable.ic_baseline_home_work_24));
        list.add(new Category2("Information Technology", R.drawable.ic_baseline_cast_connected_24));
        list.add(new Category2("Manufacturing", R.drawable.ic_baseline_handyman_24));
        list.add(new Category2("Marketing", R.drawable.ic_baseline_add_shopping_cart_24));
        list.add(new Category2("Logistics", R.drawable.ic_baseline_emoji_transportation_24));


        return list;
    }

}
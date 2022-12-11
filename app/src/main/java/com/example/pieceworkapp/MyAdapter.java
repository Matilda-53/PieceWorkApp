package com.example.pieceworkapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<User>list;

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
         User user = list.get(position);
         holder.name.setText(user.getFullName());
        holder.email.setText(user.getEmail());
        holder.number.setText(user.getContactNumber());
        holder.profession.setText(user.getProfession());
        holder.category.setText(user.getCategory());
        holder.yearOfExperience.setText(user.getYearsOfExperience());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, email, number, profession, category, yearOfExperience;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.mail);
            number = itemView.findViewById(R.id.number);
            profession = itemView.findViewById(R.id.pro);
            category = itemView.findViewById(R.id.gory);
            yearOfExperience = itemView.findViewById(R.id.year);

        }
    }
}

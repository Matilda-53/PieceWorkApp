package com.example.pieceworkapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<User>list;
//     Button button;



    public MyAdapter(Context context, ArrayList<User> list ) {
        this.context = context;
        this.list = list;
//        this.button = button;
    }

    public static void filterList(List<Category2> filteredList) {

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
         holder.Fullname.setText(user.getFullName());
        holder.email.setText(user.getEmail());
        holder.contactNumber.setText(user.getContactNumber());
        holder.profession.setText(user.getProfession());
        holder.category.setText(user.getCategory());
        holder.yearsOfExperience.setText(user.getYearsOfExperience());
//
//        String addresses = Inbox.getInbox();
//
        holder.msg_extra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, Inbox.class);
                intent.putExtra("mailUser", user.getEmail() );
                intent.putExtra("userData", "client" );
                context.startActivity(intent);

            }

        });
        };




    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Fullname, email, contactNumber, profession, category, yearsOfExperience;
        Button msg_extra;
//        Button button;
        private ArrayList<Category2> list;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Fullname = itemView.findViewById(R.id.name_extra);
            email = itemView.findViewById(R.id.mail_extra);
            contactNumber = itemView.findViewById(R.id.number_extra);
            profession = itemView.findViewById(R.id.pro_extra);
            category = itemView.findViewById(R.id.gory_extra);
            yearsOfExperience = itemView.findViewById(R.id.year_extra);
            msg_extra = itemView.findViewById(R.id.msg_extra);


        }
        public   void filterList(ArrayList<Category2>filteredList){
            list = filteredList;
            notify();

        }
    }
}

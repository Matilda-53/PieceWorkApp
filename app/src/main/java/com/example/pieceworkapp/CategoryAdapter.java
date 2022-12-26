package com.example.pieceworkapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder>{

    public Context context;
    public ArrayList<Category2> list;

    public CategoryAdapter(Context context, ArrayList<Category2> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.category_layout,parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {

        Category2 category2 = list.get(position);
        holder.textView.setText(category2.getName());
        holder.imageView.setImageResource(category2.getDrawable());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



//                Intent intent = new Intent();
//                intent.putExtra("categoryName",category2.getName());
//                intent.putExtra("pos",holder.getLayoutPosition());
//                context.startActivity(intent);

                Toast.makeText(context, ""+category2.getName(), Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            imageView = itemView.findViewById(R.id.img_ctgory);
            textView = itemView.findViewById(R.id.txt_ctgory);
        }
    }
}

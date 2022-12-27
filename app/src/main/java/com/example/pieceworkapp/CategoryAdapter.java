package com.example.pieceworkapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder>{

    public Context context;
    public ArrayList<Category2> list;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

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

        String categoryName = category2.getCategory();


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(holder.getLayoutPosition()==0)
                {
                    Intent intent = new Intent(context, category.class);
                    intent.putExtra("categoryName","engines");

                    context.startActivity(intent);

                }else if(holder.getLayoutPosition()==1)
                {
                    Intent intent = new Intent(context, category.class);
                    intent.putExtra("categoryName","edu");
                    context.startActivity(intent);

                }else if (holder.getLayoutPosition()==2)
                {
                    Intent intent = new Intent(context, category.class);
                    intent.putExtra("categoryName","health");
                    context.startActivity(intent);

                }else if(holder.getLayoutPosition()==3)
                {
                    Intent intent = new Intent(context, category.class);
                    intent.putExtra("categoryName","comms");
                    context.startActivity(intent);

                }
                else if(holder.getLayoutPosition()==4)
                {
                    Intent intent = new Intent(context, category.class);
                    intent.putExtra("categoryName","agri");
                    context.startActivity(intent);

                }else if(holder.getLayoutPosition()==5)
                {
                    Intent intent = new Intent(context, category.class);
                    intent.putExtra("categoryName","arch");
                    context.startActivity(intent);

                }else if(holder.getLayoutPosition()==6)
                {
                    Intent intent = new Intent(context, category.class);
                    intent.putExtra("categoryName","Busi");
                    context.startActivity(intent);

                }else if(holder.getLayoutPosition()==7)
                {
                    Intent intent = new Intent(context, category.class);
                    intent.putExtra("categoryName","fin");
                    context.startActivity(intent);

                }else if(holder.getLayoutPosition()==8)
                {
                    Intent intent = new Intent(context, category.class);
                    intent.putExtra("categoryName","hosp");
                    context.startActivity(intent);

                }else if(holder.getLayoutPosition()==9)
                {
                    Intent intent = new Intent(context, category.class);
                    intent.putExtra("categoryName","inf");
                    context.startActivity(intent);

                }else if(holder.getLayoutPosition()==10)
                {
                    Intent intent = new Intent(context, category.class);
                    intent.putExtra("categoryName","manf");
                    context.startActivity(intent);

                }else if(holder.getLayoutPosition()==11)
                {
                    Intent intent = new Intent(context, category.class);
                    intent.putExtra("categoryName","mark");
                    context.startActivity(intent);

                }else if(holder.getLayoutPosition()==12)
                {
                    Intent intent = new Intent(context, category.class);
                    intent.putExtra("categoryName","log");
                    context.startActivity(intent);

                }

                else
                {
                    Toast.makeText(context, ""+category2.getName(), Toast.LENGTH_SHORT).show();
                }


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

package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<String> names;
    String data1[], data2[];
    int images[];
    Context context;
    public MyAdapter(Context ct, String s1[], String s2[], int img[]){
        context =ct;
        data1= s1;
        data2= s2;
        images= img;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.my_row,parent,false);

        return new MyViewHolder(view);
    }
    @NonNull
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);

        holder.mainlayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,SecondActivity.class);
                intent.putExtra(  "data1", data1[position]);
                intent.putExtra(  "data2", data2[position]);
                intent.putExtra(  "myImage", images[position]);
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView myText1, myText2;
        ImageView myImage;
        ConstraintLayout mainlayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.myTextext1);
            myText2 = itemView.findViewById(R.id.myTextext2);
            myImage = itemView.findViewById(R.id.myImageView);
            mainlayout=itemView.findViewById(R.id.mainLayout);
        }
    }
    public void updatelist(List<String>newlist){
        names = new ArrayList<>();
        names.addAll(newlist);
        notifyDataSetChanged();
    }
}

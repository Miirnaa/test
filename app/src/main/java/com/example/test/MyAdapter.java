package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.shapes.OvalShape;
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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable{
    String data1[], data2[];
    int images[];
    Context context;
    private List<MyAdapter>examplelist;
    private List<MyAdapter>examplelistfull;

    public MyAdapter(Context ct, String s1[], String s2[], int img[]){
        context =ct;
        data1= s1;
        data2= s2;
        images= img;
    }

    public int[] getImageresource()
    {
        return images;
    }
    public String[] getData1()
    {
        return data1;
    }
    public String[] getData2()
    {
        return data2;
    }



    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.my_row,parent,false);

        return new MyViewHolder(view);
    }
    MyAdapter(List<MyAdapter>examplelist)   {
        this.examplelist= examplelist;
        examplelistfull= new ArrayList<>(examplelist);
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
        return data1.length;
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;

    }
private Filter exampleFilter = new Filter() {
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        List<MyAdapter>filteredlist = new ArrayList<>();
        if (constraint == null|| constraint.length()==0){
            filteredlist.addAll((examplelistfull));
        }else {
            String filteredPattern = constraint.toString().toLowerCase().trim();
            for(MyAdapter item :examplelistfull){
                if (item.getData1().toString().toLowerCase().contains(filteredPattern)){
                    filteredlist.add(item);
                }
            }
        }
        FilterResults results = new FilterResults();
        results.values= filteredlist;
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
examplelist.clear();
examplelist.addAll((List)results.values);
notifyDataSetChanged();
    }
};

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

    }



package com.amirht97.test7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class RecycleAdapter extends RecyclerView.Adapter<MyViewHolder> {

    ArrayList<String> type,path_img;
    ArrayList<Double> lat,lng;
    public RecycleAdapter(ArrayList<String> type,ArrayList<Double> lat,ArrayList<Double> lng,ArrayList<String> path_img){
        this.type=type;
        this.lat=lat;
        this.lng=lng;
        this.path_img=path_img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_layout,parent,false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txt_type.setText(type.get(position));
        holder.txt_lat.setText("Lat : "+lat.get(position).toString());
        holder.txt_lng.setText("Lng : "+lng.get(position).toString());
        Picasso.get().load(path_img.get(position)).fit().into(holder.img_View);
    }

    @Override
    public int getItemCount() {
        int i = 0;
        if(type != null)
            i = type.size();
        return i;
    }
}

package com.amirht97.test7;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView txt_type,txt_lat,txt_lng;
    ImageView img_View;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_type= itemView.findViewById(R.id.txt_type);
        txt_lat= itemView.findViewById(R.id.txt_lat);
        txt_lng= itemView.findViewById(R.id.txt_lng);
        img_View= itemView.findViewById(R.id.img_View);

    }
}

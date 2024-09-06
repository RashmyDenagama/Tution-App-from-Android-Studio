package com.firstapp.teachertutionapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class viewnote extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView title,content;
    public viewnote(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        title = itemView.findViewById(R.id.title);
        content = itemView.findViewById(R.id.content);

    }
}

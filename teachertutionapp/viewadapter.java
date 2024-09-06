package com.firstapp.teachertutionapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class viewadapter extends RecyclerView.Adapter<viewnote> {

    Context context;
    List<note> notes;

    public viewadapter(Context context, List<note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public viewnote onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new viewnote(LayoutInflater.from(context).inflate(R.layout.noteview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewnote holder, int position) {
        holder.title.setText(notes.get(position).getTitle());
        holder.content.setText(notes.get(position).getContent());
        holder.imageView.setImageResource(notes.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}

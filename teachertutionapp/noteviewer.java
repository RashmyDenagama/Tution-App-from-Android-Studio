package com.firstapp.teachertutionapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class noteviewer extends AppCompatActivity {
    private Button noteback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_notes);

        List<note> notes = new ArrayList<note>();
        notes.add(new note("Note-1","Overview of HCI, UX and UCD",R.drawable.a));
        notes.add(new note("Note-2","Social Issues related to HCI, Usability Goals",R.drawable.b));
        notes.add(new note("Note-3","Interaction Design, Interface",R.drawable.a));
        notes.add(new note("Note-4","Design Principles and Usage",R.drawable.b));
        notes.add(new note("Note-5","Prototyping",R.drawable.a));
        notes.add(new note("Note-1","Overview of HCI, UX and UCD",R.drawable.a));
        notes.add(new note("Note-2","Social Issues related to HCI, Usability Goals",R.drawable.b));
        notes.add(new note("Note-3","Interaction Design, Interface",R.drawable.a));
        notes.add(new note("Note-4","Design Principles and Usage",R.drawable.b));
        notes.add(new note("Note-5","Prototyping",R.drawable.a));

        RecyclerView recyclerView = findViewById(R.id.noterecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new viewadapter(getApplicationContext(),notes));

        noteback = findViewById(R.id.noteback);

        noteback.setOnClickListener(v -> {
            Intent intent = new Intent(noteviewer.this, MainActivity.class);
            startActivity(intent);
        });
    }

}

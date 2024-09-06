package com.firstapp.teachertutionapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class eventSave extends AppCompatActivity
{
    private CalendarView calendarView;
    private Button btnAddEvent;
    private eventDataSource eventDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcalenderevenets);

        calendarView = findViewById(R.id.calendarView);
        btnAddEvent = findViewById(R.id.btnAddEvent);

        eventDataSource = new eventDataSource(this);
        eventDataSource.open();

        btnAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEvent();
            }
        });
    }

    private void addEvent() {
        long selectedDate = calendarView.getDate();

        eventdata event = new eventdata();
        event.setEventDate(selectedDate);
        String eventName = "";
        event.setEventName(eventName);

        long result = eventDataSource.insertEvent(event);

        if (selectedDate != 0) {
            Intent intent = new Intent(Intent.ACTION_INSERT);
            intent.setData(CalendarContract.Events.CONTENT_URI);

            intent.putExtra(CalendarContract.Events.TITLE, "Event Title");
            intent.putExtra(CalendarContract.Events.DESCRIPTION, "Event Description");
            intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Event Location");
            startActivity(intent);

            Toast.makeText(this, "Event added to calendar", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Please select a date", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        eventDataSource.close();
    }
}

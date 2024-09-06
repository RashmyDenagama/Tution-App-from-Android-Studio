package com.firstapp.teachertutionapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class eventDataSource {
    private SQLiteDatabase database;
    private eventdb dbHelper;

    public eventDataSource(Context context) {
        dbHelper = new eventdb(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long insertEvent(eventdata event)
    {
        ContentValues values = new ContentValues();
        values.put("eventDate", event.getEventDate());
        values.put("eventName", event.getEventName());

        return database.insert("eventAdd", null, values);
    }
}

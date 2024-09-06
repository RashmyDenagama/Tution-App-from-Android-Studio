package com.firstapp.teachertutionapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class quizDataSource {
    private SQLiteDatabase database;
    private quizdb dbHelper;

    public quizDataSource(Context context) {

        dbHelper = new quizdb(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long insertQuiz(quizdata quiz)
    {
        ContentValues values = new ContentValues();
        values.put("question", quiz.getQuestion());
        values.put("options", quiz.getOptions());
        values.put("correct_option", quiz.getCorrectOption());

        return database.insert("QuizEntry", null, values);
    }
}

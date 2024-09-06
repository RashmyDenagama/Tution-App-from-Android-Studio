package com.firstapp.teachertutionapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class quizActivity extends AppCompatActivity
{
    private EditText etQuestion, etOptions, etCorrectOption;
    private Button btnSaveQuiz,backbtn = findViewById(R.id.backquiz);
    private quizDataSource dataSource;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        etQuestion = findViewById(R.id.etQuestion);
        etOptions = findViewById(R.id.etOptions);
        etCorrectOption = findViewById(R.id.etCorrectOption);
        btnSaveQuiz = findViewById(R.id.btnSaveQuiz);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(quizActivity.this,activity_home.class));
            }
        });

        dataSource = new quizDataSource(this);
        dataSource.open();

        btnSaveQuiz.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveQuiz();
            }
        });
    }
    private void saveQuiz()
    {
        String question = etQuestion.getText().toString();
        String options = etOptions.getText().toString();
        int correctOption = Integer.parseInt(etCorrectOption.getText().toString());

        quizdata quiz = new quizdata();
        quiz.setQuestion(question);
        quiz.setOptions(options);
        quiz.setCorrectOption(correctOption);

        long result = dataSource.insertQuiz(quiz);
        if (result != -1) {
            Toast.makeText(quizActivity.this, "Quiz saved successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(quizActivity.this, "Failed to save quiz", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        dataSource.close();
    }
}

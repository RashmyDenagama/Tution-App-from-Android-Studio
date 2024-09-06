package com.firstapp.teachertutionapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private signupdb dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new signupdb(this);

        usernameEditText = findViewById(R.id.Username);
        passwordEditText = findViewById(R.id.Password);

        findViewById(R.id.loginbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        TextView forgotPassTextView = findViewById(R.id.forgotpass);
        forgotPassTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Forgot Password clicked", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btnsignup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, signup.class);
                startActivity(intent);
            }
        });

    }
    private void loginUser() {
        String enteredUsername = usernameEditText.getText().toString().trim();
        String enteredPassword = passwordEditText.getText().toString().trim();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {
                signupdb.COLUMN_USERNAME,
                signupdb.COLUMN_PASSWORD
        };

        String selection = signupdb.COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {enteredUsername};

        Cursor cursor = db.query(
                signupdb.TABLE_USERS,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (cursor.moveToFirst()) {
            String storedUsername = cursor.getString(cursor.getColumnIndexOrThrow(signupdb.COLUMN_USERNAME));
            String storedPassword = cursor.getString(cursor.getColumnIndexOrThrow(signupdb.COLUMN_PASSWORD));

            if ("admin".equals(storedUsername) && "00000".equals(enteredPassword)) {
                Toast.makeText(this, "Admin login successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, activity_home.class);
                startActivity(intent);
                finish();
            } else if (enteredPassword.equals(storedPassword)) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, factapi.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }

        cursor.close();
        db.close();;
    }

}
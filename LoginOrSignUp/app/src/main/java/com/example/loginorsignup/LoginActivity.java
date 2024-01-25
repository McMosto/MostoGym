package com.example.loginorsignup;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import java.io.*;
import java.net.*;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    //private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //dbHelper = new DatabaseHelper(this);

        emailEditText = findViewById(R.id.editTextEmailLogin);
        passwordEditText = findViewById(R.id.editTextPasswordLogin);

        Button loginButton = findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                login();
            }
        });
    }

    // Inside the login() method in LoginActivity.java
    private void login() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        PrintWriter out;
        BufferedReader in;
        Socket s = ConnectSocket("10.0.2.2", 1234); //connect to server
        String msg = ""; //create a message
        //new LongRunningTask().execute();
        if(s != null) {
            do {
                try {
                    out = new PrintWriter(s.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    out.println(String.format("login-%1$s-%2$s",email,password)); //send that we are logging in + the email and the password
                    msg = in.readLine(); //reiceve message if login has completed
                    in.close();
                    out.close();
                }
                catch (Exception e) {
                    System.out.println(e);
                }
                if (msg == "ok") { //when login completed
                    // Login successful, navigate to WelcomeActivity
                    Intent welcomeIntent = new Intent(LoginActivity.this, WelcomeActivity.class);
                    startActivity(welcomeIntent);
                    finish(); // Optional: finish the LoginActivity to prevent going back
                } else { //otherwise toast
                    // Show error message
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
            while(msg != "ok");


        }
    }

//    private boolean checkUser(String email, String password) {
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//
//        // Define the columns you want to retrieve
//        String[] projection = {
//                DatabaseHelper.COLUMN_ID,
//                DatabaseHelper.COLUMN_FIRST_NAME,
//                DatabaseHelper.COLUMN_LAST_NAME,
//                DatabaseHelper.COLUMN_NICKNAME,
//                DatabaseHelper.COLUMN_EMAIL,
//                DatabaseHelper.COLUMN_PASSWORD
//        };
//
//        // Define the WHERE clause
//        String selection = DatabaseHelper.COLUMN_EMAIL + " = ? AND " +
//                DatabaseHelper.COLUMN_PASSWORD + " = ?";
//
//        // Define the values for the WHERE clause
//        String[] selectionArgs = {email, password};
//
//        // Query the database
//        Cursor cursor = db.query(
//                DatabaseHelper.TABLE_USERS,
//                projection,
//                selection,
//                selectionArgs,
//                null,
//                null,
//                null
//        );
//
//        // Check if the cursor has any rows
//        boolean userExists = cursor.moveToFirst();
//
//        // If a user exists, log the retrieved user information
//        if (userExists) {
//            Log.d("LoginActivity", "User found:");
//
//            for (String columnName : projection) {
//                int columnIndex = cursor.getColumnIndex(columnName);
//
//                if (columnIndex != -1) {
//                    String columnValue = cursor.getString(columnIndex);
//                    Log.d("LoginActivity", columnName + ": " + columnValue);
//                } else {
//                    Log.e("LoginActivity", "Column not found: " + columnName);
//                }
//            }
//        }
//
//        // Close the cursor and database connection
//        cursor.close();
//        db.close();
//
//        return userExists;
//    }

//    private class LongRunningTask extends AsyncTask<Void, Void, Void> {
//        @Override
//        protected Void doInBackground(Void... voids) {
//            try {
//                System.out.println("Connecting");
//                Socket s = new Socket("10.0.2.2", 1234);
//                System.out.println("connected");
//                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//                dout.writeUTF("login");
//                dout.flush();
//                dout.close();
//                s.close();
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//            return null;
//        }
//    }

    private Socket ConnectSocket(String ip, int port) {
        try {
            System.out.println("Connecting");
            Socket s = new Socket(ip,port);
            System.out.println("connected");
            s.close();
            return s;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}

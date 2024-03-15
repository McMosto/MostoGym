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
import android.widget.ImageButton;
import android.widget.Toast;
import java.io.*;
import java.net.*;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Base64;
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
        ImageButton backButton = findViewById(R.id.backButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                login();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(backIntent);
                finish();
            }
        });
    }

    // Inside the login() method in LoginActivity.java
    private void login() {
        new LongRunningTask().execute();
    }

    // Inside the LongRunningTask class in LoginActivity.java
    // Inside the LongRunningTask class in LoginActivity.java
    private class LongRunningTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                DataOutputStream out;
                DataInputStream in;
                byte[] data; // Change the type to byte array
                String msg = ""; // create a message
                Socket s = SocketManager.getSocketInstance();
                if (s != null) {
                    try {
                        out = new DataOutputStream(s.getOutputStream());
                        in = new DataInputStream(s.getInputStream());
                        out.writeUTF(String.format("login-%1$s-%2$s", email, password));
                        Log.d("Client", "Request sent");

                        // Read bytes from the input stream
                        data = new byte[1024];
                        int bytesRead = in.read(data);

                        // Convert bytes to String
                        msg = new String(data, 0, bytesRead, "UTF-8");
                        Log.d("Client", "Response received: " + msg + " Length: " + msg.length());

                        // Removed in.close() and out.close() from here
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("Client", "Error: " + e.getMessage());
                    }
                    Log.d("Client", "got here");
                    if (msg.equals("CONT\r\n")) {
                        // Login successful, navigate to WelcomeActivity
                        Intent welcomeIntent = new Intent(LoginActivity.this, WelcomeActivity.class);
                        startActivity(welcomeIntent);
                        finish(); // Optional: finish the LoginActivity to prevent going back
                    } else {
                        // Show error message
                        Log.e("Client", msg);
                        //Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }


}

package com.example.loginorsignup;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.buttonLogin);
        Button signUpButton = findViewById(R.id.buttonSignUp);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the login screen
                Log.d("LoginActivity", "Login button clicked");
                Dataset dataset = Dataset.getInstance(getApplicationContext());
                List<String[]> data = dataset.getData();
                Log.d("DataSet", data.toString());
                // Print the header
                if (!dataset.getData().isEmpty()) {
                    String[] header = dataset.getData().get(0);
                    System.out.println("Header: " + String.join(",", header));
                }

                // Print the data
                for (int i = 1; i < dataset.getData().size(); i++) {
                    System.out.println(Arrays.toString(dataset.getData().get(i))); };
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                finish();
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the sign-up screen
                Log.d("LoginActivity", "Login button clicked");
                Intent signUpIntent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(signUpIntent);
                finish();
            }
        });



    }


}

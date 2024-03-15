package com.example.loginorsignup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button signOutButton = findViewById(R.id.buttonSignOut);
        ImageButton homeButton = findViewById(R.id.homeButton);
        ImageButton workoutButton = findViewById(R.id.workoutButton);
        ImageButton profileButton = findViewById(R.id.profileButton);

        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle sign-out logic, such as clearing user credentials or navigating to the login screen
                signOut();
            }

        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle sign-out logic, such as clearing user credentials or navigating to the login screen
                home();
            }
        });

        workoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle sign-out logic, such as clearing user credentials or navigating to the login screen
                workout();
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle sign-out logic, such as clearing user credentials or navigating to the login screen
                profile();
            }
        });
    }

    private void signOut() {
        // Implement your sign-out logic here

        // For example, navigate back to the login screen
        Intent mainIntent = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(mainIntent);
        finish(); // Optional: finish the WelcomeActivity to prevent going back
    }

    private void home() {
        Intent homeIntent = new Intent(WelcomeActivity.this, WelcomeActivity.class);
        startActivity(homeIntent);
        finish(); // Optional: finish the WelcomeActivity to prevent going back
    }

    private void workout() {
        Intent workoutIntent = new Intent(WelcomeActivity.this, WorkoutActivity.class);
        startActivity(workoutIntent);
        finish();
    }

    private void profile() {
        Intent profileIntent = new Intent(WelcomeActivity.this, ProfileActivity.class);
        startActivity(profileIntent);
        finish(); // Optional: finish the WelcomeActivity to prevent going back
    }
}

package com.example.loginorsignup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class WorkoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        Button signOutButton = findViewById(R.id.buttonSignOut);
        ImageButton homeButton = findViewById(R.id.homeButton);
        ImageButton workoutButton = findViewById(R.id.workoutButton);
        ImageButton profileButton = findViewById(R.id.profileButton);
        ImageButton backButton = findViewById(R.id.backButton);
        Button newWorkoutButton = findViewById(R.id.newWorkoutButton);
        Button exploreRoutineButton = findViewById(R.id.exploreRoutineButton);
        Button SearchExerciseButton = findViewById(R.id.SearchExerciseButton);

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

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(WorkoutActivity.this, WelcomeActivity.class);
                startActivity(backIntent);
                finish();
            }
        });

        exploreRoutineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RoutinesIntent = new Intent(WorkoutActivity.this, RoutinesActivity.class);
                startActivity(RoutinesIntent);
                finish();
            }
        });

    }


    private void signOut() {
        // Implement your sign-out logic here

        // For example, navigate back to the login screen
        Intent mainIntent = new Intent(WorkoutActivity.this, MainActivity.class);
        startActivity(mainIntent);
        finish(); // Optional: finish the WelcomeActivity to prevent going back
    }

    private void home() {
        Intent homeIntent = new Intent(WorkoutActivity.this, WelcomeActivity.class);
        startActivity(homeIntent);
        finish(); // Optional: finish the WelcomeActivity to prevent going back
    }

    private void workout() {
        Intent workoutIntent = new Intent(WorkoutActivity.this, WorkoutActivity.class);
        startActivity(workoutIntent);
        finish();
    }

    private void profile() {
        Intent profileIntent = new Intent(WorkoutActivity.this, ProfileActivity.class);
        startActivity(profileIntent);
        finish(); // Optional: finish the WelcomeActivity to prevent going back
    }
}
package com.example.loginorsignup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class NewWorkoutActivity extends AppCompatActivity {
    private File csvFile;
    private List<ExerciseItem> items = new ArrayList<ExerciseItem>();
    private static final int ADD_EXERCISE_REQUEST_CODE = 1;
    private RecyclerView recyclerView2; // Declare recyclerView2 as a class-level variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout);

        Button AddExerciseButton = findViewById(R.id.AddExerciseButton);
        Button DiscardWorkoutButton = findViewById(R.id.DiscardWorkoutButton);
        recyclerView2 = findViewById(R.id.recyclerView2); // Initialize recyclerView2 here
        Button saveWorkoutButton = findViewById(R.id.saveWorkoutButton);

        csvFile = (File) getIntent().getSerializableExtra("CSV_FILE");
            AddExerciseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent addExerIntent = new Intent(NewWorkoutActivity.this, AddExerciseActivity.class);
                    startActivityForResult(addExerIntent, ADD_EXERCISE_REQUEST_CODE);
                }
            });

        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_EXERCISE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String exerciseName = data.getStringExtra("EXERCISE_NAME");
            Toast.makeText(this, "Selected exercise: " + exerciseName, Toast.LENGTH_SHORT).show();
            items.add(new ExerciseItem(exerciseName));

            // Initialize the adapter if it is null
            if (recyclerView2.getAdapter() == null) {
                ExerciseAdapter adapter = new ExerciseAdapter(getApplicationContext(), items, this);
                recyclerView2.setAdapter(adapter);
                recyclerView2.setLayoutManager(new LinearLayoutManager(this));
            } else {
                // Update the existing adapter with the new data set
                ((ExerciseAdapter) recyclerView2.getAdapter()).setItems(items);
            }
        }
    }



}



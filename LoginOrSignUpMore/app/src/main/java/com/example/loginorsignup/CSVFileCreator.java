package com.example.loginorsignup;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CSVFileCreator extends AppCompatActivity {

    private static final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout);

        // Check and request permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted, request it
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
        } else {
            // Permission is already granted, proceed with file operations
            createCSVFile();
        }
    }

    private void createCSVFile() {
        try {
            // Specify the file path
            File dir = new File(Environment.getExternalStorageDirectory().getPath() + "/WorkoutFiles");
            Log.d("DIR:",Environment.getExternalStorageDirectory().getPath());
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String fileName = getFileName();
            File file = new File(dir, fileName);

            // Create a FileWriter object
            FileWriter fileWriter = new FileWriter(file);

            // Write data to the file
            fileWriter.append("exerName,SetNum,weight,reps,volume\n"); // CSV header

            fileWriter.flush();
            fileWriter.close();

            // Display a toast message to indicate success
            Toast.makeText(this, "CSV file created successfully", Toast.LENGTH_SHORT).show();

            // Start the NewWorkoutActivity and pass the CSV file
            Intent intent = new Intent(CSVFileCreator.this, NewWorkoutActivity.class);
            intent.putExtra("CSV_FILE", file);
            startActivity(intent);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, proceed with file operations
                createCSVFile();
            } else {
                // Permission denied, show a message or request again
                // You can show a dialog explaining why the permission is needed and ask the user to grant it again
            }
        }
    }

    private String getFileName() {
        // Generate a file name based on the current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH:mm:ss");
        return now.format(formatter) + "-workout.csv";
    }
}

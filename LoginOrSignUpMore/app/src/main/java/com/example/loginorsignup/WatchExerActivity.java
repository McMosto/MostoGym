package com.example.loginorsignup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WatchExerActivity extends AppCompatActivity implements ExerciseListInterface{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exerciselist);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        //SearchView searchView = findViewById(R.id.search_bar);
        //searchView.clearFocus();
        ImageButton backButton = findViewById(R.id.backButton);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(WatchExerActivity.this, WorkoutActivity.class);
                startActivity(backIntent);
                finish();
            }
        });


        List<ExerciseListItem> items = new ArrayList<ExerciseListItem>();
        DatasetManager dataset = DatasetManager.getInstance(getApplicationContext());
        List<String[]> data = dataset.getData();
        for (int i = 1; i < 2919;i++)
        {
            String[] exercise = data.get(i);
            String exerName = exercise[0];
            String exerType = exercise[1];
            String exerBodyPart = exercise[2];
            String exerEquiqment = exercise[3];
            String exerLevel = exercise[4];
            int image;
            switch (exerBodyPart) {
                case ("Chest"):
                    image = R.drawable.chest;
                    break;
                case ("Forearms"):
                    image = R.drawable.forearms;
                    break;
                case ("Lats"):
                    image = R.drawable.lats;
                    break;
                case ("Lower back"):
                    image = R.drawable.lowerback;
                    break;
                case ("Neck"):
                    image = R.drawable.neck;
                    break;
                case ("Quadriceps"):
                    image = R.drawable.quads;
                    break;
                case ("Hamstrings"):
                    image = R.drawable.hamstrings;
                    break;
                case ("Calves"):
                    image = R.drawable.calves;
                    break;
                case ("Triceps"):
                    image = R.drawable.triceps;
                    break;
                case ("Traps"):
                    image = R.drawable.traps;
                    break;
                case ("Shoulders"):
                    image = R.drawable.shoulders;
                    break;
                case ("Abdominals"):
                    image = R.drawable.abs;
                    break;
                case ("Glutes"):
                    image = R.drawable.glutes;
                    break;
                case ("Biceps"):
                    image = R.drawable.biceps;
                    break;
                case ("Adductors"):
                    image = R.drawable.adductors;
                    break;
                case ("Abductors"):
                    image = R.drawable.abductors;
                    break;
                default:
                    image = R.drawable.baseline_error_outline_24;
            }
            items.add(new ExerciseListItem(exerName,exerType,exerBodyPart,exerEquiqment,exerLevel,image));

        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ExerciseListAdapter(getApplicationContext(), items,this));

    }

    @Override
    public void onItemClick(int position) {

    }
}

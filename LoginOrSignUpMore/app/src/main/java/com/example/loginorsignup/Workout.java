package com.example.loginorsignup;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Workout extends ExerciseItem {
    private List<ExerciseItem> exercises;
    File csvFile;
    public Workout() {
        super("Workout"); // Default name for workout
        this.exercises = new ArrayList<>();
    }

    public void addExercise(ExerciseItem exercise) {
        exercises.add(exercise);
    }

    public List<ExerciseItem> getExercises() {
        return exercises;
    }
}


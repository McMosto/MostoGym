package com.example.loginorsignup;

import java.util.ArrayList;
import java.util.List;

public class Workout extends Exercise {
    private List<Exercise> exercises;

    public Workout() {
        super("Workout"); // Default name for workout
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public List<Exercise> getExercises() {
        return exercises;
    }
}


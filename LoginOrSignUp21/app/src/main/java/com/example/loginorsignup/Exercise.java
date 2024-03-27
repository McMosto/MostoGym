package com.example.loginorsignup;

import java.util.ArrayList;
import java.util.List;

public class Exercise extends Set {
    protected String name;
    protected List<Set> sets;

    public Exercise(String name) {
        super(0, 0); // Call to super constructor to initialize weight and reps
        this.name = name;
        this.sets = new ArrayList<>();
    }

    public void addSet(Set set) {
        sets.add(set);
    }

    public List<Set> getSets() {
        return sets;
    }

    public String getName() {
        return name;
    }
}

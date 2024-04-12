package com.example.loginorsignup;

import java.util.ArrayList;
import java.util.List;

public class ExerciseItem extends SetItem {
    protected String name;
    protected List<SetItem> sets;

    public ExerciseItem(String name) {
        super(0, 0); // Call to super constructor to initialize weight and reps
        this.name = name;
        this.sets = new ArrayList<>();
    }

    public void addSet(SetItem set) {
        sets.add(set);
    }

    public List<SetItem> getSets() {
        return sets;
    }

    public String getName() {
        return name;
    }
}

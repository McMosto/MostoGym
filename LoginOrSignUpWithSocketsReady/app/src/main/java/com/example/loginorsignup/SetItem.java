package com.example.loginorsignup;

public class SetItem {
    protected int weight;
    protected int reps;

    public SetItem(int weight, int reps) {
        this.weight = weight;
        this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }

    public int getReps() {
        return reps;
    }
}

package com.example.loginorsignup;

public class ExerciseListActivity {

    String name;
    int image;
    String muscle;
    int rating;

    public ExerciseListActivity(String name, int image, String muscle, int rating) {
        this.name = name;
        this.image = image;
        this.muscle = muscle;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getMuscle() {
        return muscle;
    }

    public int getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

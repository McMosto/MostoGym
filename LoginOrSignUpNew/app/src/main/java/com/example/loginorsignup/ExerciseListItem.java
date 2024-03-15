package com.example.loginorsignup;

public class ExerciseListItem {
    String name;
    String type;
    String BodyPart;
    String Equiqment;
    String Level;
    int image;

    public ExerciseListItem(String name, String type, String bodyPart, String equiqment, String level, int image) {
        this.name = name;
        this.type = type;
        BodyPart = bodyPart;
        Equiqment = equiqment;
        Level = level;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getBodyPart() {
        return BodyPart;
    }

    public String getEquiqment() {
        return Equiqment;
    }

    public String getLevel() {
        return Level;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBodyPart(String bodyPart) {
        BodyPart = bodyPart;
    }

    public void setEquiqment(String equiqment) {
        Equiqment = equiqment;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

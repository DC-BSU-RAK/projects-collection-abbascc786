package com.example.fitify;

public class DietModel {

    String name;
    String description;
    String calories;
    String timing;

    public DietModel(String name, String description, String calories, String timing) {
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.timing = timing;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCalories() {
        return calories;
    }

    public String getTiming() {
        return timing;
    }
}
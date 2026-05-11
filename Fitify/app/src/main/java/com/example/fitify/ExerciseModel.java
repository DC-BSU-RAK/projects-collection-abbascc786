package com.example.fitify;

public class ExerciseModel {

    String name, desc, muscle, instructions;
    int image;

    public ExerciseModel(String name, String desc, String muscle, String instructions, int image) {
        this.name = name;
        this.desc = desc;
        this.muscle = muscle;
        this.instructions = instructions;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getMuscle() {
        return muscle;
    }

    public String getInstructions() {
        return instructions;
    }

    public int getImage() {
        return image;
    }
}
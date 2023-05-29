package com.example.gaintracker;

public class ExerciseObject {

    private String exerciseName;
    private String setsCount;
    private String repsCount;
    private String weight;

    public String getExerciseName() {
        return exerciseName;
    }

    public String getSetsCount() {
        return setsCount;
    }

    public String getRepsCount() {
        return repsCount;
    }

    public String getWeight() {
        return weight;
    }

    public ExerciseObject(String exerciseName, String setsCount, String repsCount, String weight) {

        //this.id=id;
        this.exerciseName = exerciseName;
        this.setsCount = setsCount;
        this.repsCount = repsCount;
        this.weight = weight;
    }
}

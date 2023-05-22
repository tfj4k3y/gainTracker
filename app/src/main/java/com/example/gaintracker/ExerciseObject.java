package com.example.gaintracker;

public class ExerciseObject {


    private String exerciseName;
    private String setsCount;
    private String repsCount;
    private String weight;
    private Integer workoutId;

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

    public Integer getWorkoutId() {
        return workoutId;
    }

    public ExerciseObject(String exerciseName, String setsCount, String repsCount, String weight, Integer workoutId) {

        this.exerciseName = exerciseName;
        this.setsCount = setsCount;
        this.repsCount = repsCount;
        this.weight = weight;
        this.workoutId = workoutId;

    }



}

package com.example.gaintracker;

public class ExerciseObject {



    //private long id;
    private String exerciseName;
    private String setsCount;
    private String repsCount;
    private String weight;

    //private int workoutId;

    //public long getId() {
    //    return id;
    //}

    //public int getWorkoutId() {
    //    return workoutId;
    //}

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

    public ExerciseObject(/*long id,*/ String exerciseName, String setsCount, String repsCount, String weight/*, int workoutId*/) {

        //this.id=id;
        this.exerciseName = exerciseName;
        this.setsCount = setsCount;
        this.repsCount = repsCount;
        this.weight = weight;
        //this.workoutId=workoutId;

    }



}

package com.example.gaintracker.database;

import android.provider.BaseColumns;

public final class DatabaseContract {

    private DatabaseContract(){}

    public static class Workout implements BaseColumns{

        public static final String TABLE_NAME = "workout";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_DAY_OF_THE_WEEK = "day_of_the_week";

    }

    public static class Exercises implements BaseColumns{

        public static final String TABLE_NAME = "exercises";
        public static final String COLUMN_NAME_EXERCISE = "exercise_name";
        public static final String COLUMN_NAME_SETS = "sets_count";
        public static final String COLUMN_NAME_REPS = "reps_count";
        public static final String COLUMN_NAME_WEIGHT = "weight";
        public static final String COLUMN_NAME_ID_WORKOUT = "id_workout";

    }
}

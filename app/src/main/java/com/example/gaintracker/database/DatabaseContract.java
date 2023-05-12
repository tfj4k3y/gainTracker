package com.example.gaintracker.database;

import android.provider.BaseColumns;

public final class DatabaseContract {

    private DatabaseContract(){}

    public static class Workout implements BaseColumns{

        public static final String TABLE_NAME = "workout";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_SETS = "";

    }

    public static class Exercises implements BaseColumns{

        public static final String TABLE_NAME = "exercises";
        public static final String COLUMN_NAME_NAZWA = "exercise_name";
        public static final String COLUMN_NAME_SETS = "sets_count";
        public static final String COLUMN_NAME_REPS = "reps_count";
        public static final String COLUMN_NAME_WEIGHT = "ciezar";
        public static final String COLUMN_NAME_ID_TRENINGU = "id_treningu";

    }

}

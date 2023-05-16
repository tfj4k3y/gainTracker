package com.example.gaintracker.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Poniżej przy pomocy dwóch statycznych metod tworzone sa tabele naszej bazy danych

    private static final String SQL_CREATE_WORKOUT_TABLE =
            "CREATE TABLE " + DatabaseContract.Workout.TABLE_NAME + " (" +
                    DatabaseContract.Workout._ID + " INTEGER PRIMARY KEY," +
                    DatabaseContract.Workout.COLUMN_NAME_DATE + " TEXT," +
                    DatabaseContract.Workout.COLUMN_NAME_DAY_OF_THE_WEEK + " TEXT)";

    private static final String SQL_CREATE_EXERCISE_TABLE =
            "CREATE TABLE " + DatabaseContract.Exercises.TABLE_NAME + " (" +
                    DatabaseContract.Exercises._ID + " INTEGER PRIMARY KEY," +
                    DatabaseContract.Exercises.COLUMN_NAME_EXERCISE + " TEXT," +
                    DatabaseContract.Exercises.COLUMN_NAME_SETS + " INTEGER," +
                    DatabaseContract.Exercises.COLUMN_NAME_REPS + " TEXT," +
                    DatabaseContract.Exercises.COLUMN_NAME_WEIGHT + " TEXT," +
                    DatabaseContract.Exercises.COLUMN_NAME_ID_WORKOUT + " INTEGER)";

    //A tu poniżej metody usuwające tabele z bazy danych

    private static final String SQL_DELETE_WORKOUT_TABLE =
            "DROP TABLE IF EXISTS " + DatabaseContract.Workout.TABLE_NAME;

    private static final String SQL_DELETE_EXERCISE_TABLE =
            "DROP TABLE IF EXISTS " + DatabaseContract.Exercises.TABLE_NAME;




    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "GainTracker.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_WORKOUT_TABLE);
        db.execSQL(SQL_CREATE_EXERCISE_TABLE);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

}

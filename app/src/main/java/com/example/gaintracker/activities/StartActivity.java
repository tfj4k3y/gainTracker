package com.example.gaintracker.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.gaintracker.R;
import com.example.gaintracker.database.DatabaseContract;
import com.example.gaintracker.database.DatabaseHelper;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        DatabaseHelper dbHelper = new DatabaseHelper(this);

        //Dodawanie tabeli trening na starcie

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        //values.put(DatabaseContract.Workout.COLUMN_NAME_DATE, date);
        //values.put(DatabaseContract.Workout.COLUMN_NAME_DAY_OF_THE_WEEK, day_of_the_week);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(DatabaseContract.Workout.TABLE_NAME, null, values);

    }
}
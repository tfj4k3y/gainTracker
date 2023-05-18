package com.example.gaintracker.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;

import com.example.gaintracker.R;
import com.example.gaintracker.RecycleviewAdapter;
import com.example.gaintracker.database.DatabaseContract;
import com.example.gaintracker.database.DatabaseHelper;

public class PreviewActivity extends AppCompatActivity {

    String cw[], param[], daty[];
    DatabaseHelper dbHelper = new DatabaseHelper(this);
    RecyclerView recycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);


        //Ogólnie poniżej hardcodowa część aplikacji
        //Tutaj szukamy recyclerviewera w acticity_preview

        recycleView = findViewById(R.id.recycleview);


        //Tutaj wklejamy dane w row_view

        cw = getResources().getStringArray(R.array.exercises);
        param = getResources().getStringArray(R.array.results);
        daty = getResources().getStringArray(R.array.dates);

        RecycleviewAdapter recycleviewAdapter = new RecycleviewAdapter(this, cw, param, daty);
        recycleView.setAdapter(recycleviewAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));


        //Poniżej pobieranie danych z bazy i wrzucanie do recyclerviewera

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                DatabaseContract.Workout.COLUMN_NAME_DATE,
                DatabaseContract.Workout.COLUMN_NAME_DAY_OF_THE_WEEK,
                DatabaseContract.Exercises.COLUMN_NAME_EXERCISE,
                DatabaseContract.Exercises.COLUMN_NAME_SETS,
                DatabaseContract.Exercises.COLUMN_NAME_REPS,
                DatabaseContract.Exercises.COLUMN_NAME_WEIGHT

        };








    }
}
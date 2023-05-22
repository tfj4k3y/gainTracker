package com.example.gaintracker.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gaintracker.R;
import com.example.gaintracker.database.DatabaseContract;
import com.example.gaintracker.database.DatabaseHelper;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        DatabaseHelper dbHelper = new DatabaseHelper(this);

        long trainingId = getIntent().getLongExtra("id", 0);

        Button nextExerciseButton = findViewById(R.id.next_exercise);
        Button endTrainingButton = findViewById(R.id.end_training);

        nextExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText ExerciseName = (EditText) findViewById(R.id.exercise_name);
                String sExerciseName = ExerciseName.getText().toString().trim();

                EditText Sets = (EditText) findViewById(R.id. sets);
                String sSets = ExerciseName.getText().toString().trim();

                EditText Reps = (EditText) findViewById(R.id.reps);
                String sReps = ExerciseName.getText().toString().trim();

                EditText Weight = (EditText) findViewById(R.id.weight);
                String sWeight = ExerciseName.getText().toString().trim();

                //Dodawanie tabeli trening na starcie

                SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(DatabaseContract.Exercises.COLUMN_NAME_EXERCISE, sExerciseName);
                values.put(DatabaseContract.Exercises.COLUMN_NAME_SETS, sSets);
                values.put(DatabaseContract.Exercises.COLUMN_NAME_REPS, sReps);
                values.put(DatabaseContract.Exercises.COLUMN_NAME_WEIGHT, sWeight);
                values.put(DatabaseContract.Exercises.COLUMN_NAME_ID_WORKOUT, trainingId);

                long newRowId = db.insert(DatabaseContract.Exercises.TABLE_NAME, null, values);


            }
        });

        endTrainingButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                System.out.println(trainingId);
                //HAAAAAAAAAAAAALOOOOOOOOOO TUTAJ ZRÓB

            }
        });


    }
}
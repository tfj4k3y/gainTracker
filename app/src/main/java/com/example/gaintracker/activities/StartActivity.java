package com.example.gaintracker.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        int i = (int)trainingId;

        Button nextExerciseButton = findViewById(R.id.next_exercise);
        Button endTrainingButton = findViewById(R.id.end_training);

        nextExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText ExerciseName = (EditText) findViewById(R.id.exercise_name);
                String sExerciseName = ExerciseName.getText().toString().trim();

                EditText Sets = (EditText) findViewById(R.id.sets);
                String sSets = Sets.getText().toString().trim();

                EditText Reps = (EditText) findViewById(R.id.reps);
                String sReps = Reps.getText().toString().trim();

                EditText Weight = (EditText) findViewById(R.id.weight);
                String sWeight = Weight.getText().toString().trim();

                boolean digitsOnlySets = TextUtils.isDigitsOnly(Sets.getText());
                boolean digitsOnlyReps = TextUtils.isDigitsOnly(Reps.getText());

                //Dodawanie tabeli trening na starcie
                //Toast sprawdza, czy pola nie są puste i czy serie i powtórzenia są liczbą

                if(sExerciseName.equals("") || sSets.equals("") || sReps.equals("") || sWeight.equals("") || !digitsOnlySets || !digitsOnlyReps){
                    CharSequence text = "Błąd w formularzu!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast.makeText(view.getContext(), text, duration).show();
                }else {

                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    System.out.println(sExerciseName + " " + sSets);

                    ContentValues values = new ContentValues();
                    values.put(DatabaseContract.Exercises.COLUMN_NAME_EXERCISE, sExerciseName);
                    values.put(DatabaseContract.Exercises.COLUMN_NAME_SETS, sSets);
                    values.put(DatabaseContract.Exercises.COLUMN_NAME_REPS, sReps);
                    values.put(DatabaseContract.Exercises.COLUMN_NAME_WEIGHT, sWeight);
                    values.put(DatabaseContract.Exercises.COLUMN_NAME_ID_WORKOUT, i);

                    long newRowId = db.insert(DatabaseContract.Exercises.TABLE_NAME, null, values);

                    ExerciseName.getText().clear();
                    Sets.getText().clear();
                    Reps.getText().clear();
                    Weight.getText().clear();
                }

            }
        });

        endTrainingButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                EditText ExerciseName = (EditText) findViewById(R.id.exercise_name);
                String sExerciseName = ExerciseName.getText().toString().trim();

                EditText Sets = (EditText) findViewById(R.id. sets);
                String sSets = Sets.getText().toString().trim();

                EditText Reps = (EditText) findViewById(R.id.reps);
                String sReps = Reps.getText().toString().trim();

                EditText Weight = (EditText) findViewById(R.id.weight);
                String sWeight = Weight.getText().toString().trim();

                boolean digitsOnlySets = TextUtils.isDigitsOnly(Sets.getText());
                boolean digitsOnlyReps = TextUtils.isDigitsOnly(Reps.getText());

                //Dodawanie tabeli trening na starcie

                if(sExerciseName.equals("") || sSets.equals("") || sReps.equals("") || sWeight.equals("") || !digitsOnlySets || !digitsOnlyReps){
                    CharSequence text = "Błąd w formularzu!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast.makeText(view.getContext(), text, duration).show();
                }else {

                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put(DatabaseContract.Exercises.COLUMN_NAME_EXERCISE, sExerciseName);
                    values.put(DatabaseContract.Exercises.COLUMN_NAME_SETS, sSets);
                    values.put(DatabaseContract.Exercises.COLUMN_NAME_REPS, sReps);
                    values.put(DatabaseContract.Exercises.COLUMN_NAME_WEIGHT, sWeight);
                    values.put(DatabaseContract.Exercises.COLUMN_NAME_ID_WORKOUT, trainingId);

                    long newRowId = db.insert(DatabaseContract.Exercises.TABLE_NAME, null, values);

                    finish();
                }

            }
        });


    }
}
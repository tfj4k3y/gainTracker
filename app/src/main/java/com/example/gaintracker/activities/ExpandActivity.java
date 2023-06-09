package com.example.gaintracker.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;

import com.example.gaintracker.adapters.ExerciseAdapter;
import com.example.gaintracker.objects.ExerciseObject;
import com.example.gaintracker.R;
import com.example.gaintracker.database.DatabaseContract;
import com.example.gaintracker.database.DatabaseHelper;

import java.util.ArrayList;

public class ExpandActivity extends AppCompatActivity {

    DatabaseHelper dbHelper = new DatabaseHelper(this);
    RecyclerView recycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand);

        long trainingId = getIntent().getLongExtra("id", 0);
        String trainingIdStr = trainingId+"";

        recycleView = findViewById(R.id.exercise_recycler_view);


        //Poniżej pobieranie danych z bazy i wrzucanie do recyclerviewera

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                DatabaseContract.Exercises.COLUMN_NAME_EXERCISE,
                DatabaseContract.Exercises.COLUMN_NAME_SETS,
                DatabaseContract.Exercises.COLUMN_NAME_REPS,
                DatabaseContract.Exercises.COLUMN_NAME_WEIGHT,
                DatabaseContract.Exercises.COLUMN_NAME_ID_WORKOUT
        };



        String selection = DatabaseContract.Exercises.COLUMN_NAME_ID_WORKOUT + " = ?";
        String[] selectionArgs = { trainingIdStr };

        Cursor cursor = db.query(
                DatabaseContract.Exercises.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        ArrayList<ExerciseObject> exerciseObjectArrayList = new ArrayList<>();

        while(cursor.moveToNext()){

            String itemExerciseName = cursor.getString(
                    cursor.getColumnIndexOrThrow(DatabaseContract.Exercises.COLUMN_NAME_EXERCISE));

            String itemSetsCount = cursor.getString(
                    cursor.getColumnIndexOrThrow(DatabaseContract.Exercises.COLUMN_NAME_SETS));

            String itemRepsCount = cursor.getString(
                    cursor.getColumnIndexOrThrow(DatabaseContract.Exercises.COLUMN_NAME_REPS));

            String itemWeight = cursor.getString(
                    cursor.getColumnIndexOrThrow(DatabaseContract.Exercises.COLUMN_NAME_WEIGHT));


            ExerciseObject object1 = new ExerciseObject(itemExerciseName, itemSetsCount, itemRepsCount, itemWeight/*itemWorkoutId*/);
            exerciseObjectArrayList.add(object1);
        }

        ExerciseAdapter exerciseAdapter = new ExerciseAdapter(this, exerciseObjectArrayList);

        recycleView.setAdapter(exerciseAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));


    }
}
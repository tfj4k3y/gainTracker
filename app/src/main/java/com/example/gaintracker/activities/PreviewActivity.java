package com.example.gaintracker.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;

import com.example.gaintracker.ButtonInterface;
import com.example.gaintracker.R;
import com.example.gaintracker.adapters.TrainingAdapter;
import com.example.gaintracker.TreningObject;
import com.example.gaintracker.database.DatabaseContract;
import com.example.gaintracker.database.DatabaseHelper;

import java.util.ArrayList;

public class PreviewActivity extends AppCompatActivity {
    DatabaseHelper dbHelper = new DatabaseHelper(this);
    RecyclerView recycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        recycleView = findViewById(R.id.recycleview);

        //Poniżej pobieranie danych z bazy i wrzucanie do recyclerviewera

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                DatabaseContract.Workout.COLUMN_NAME_DATE,
                DatabaseContract.Workout.COLUMN_NAME_DAY_OF_THE_WEEK
        };

        String sortOrder = DatabaseContract.Workout._ID + (" DESC");

        Cursor cursor = db.query(
                DatabaseContract.Workout.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        ArrayList<TreningObject> treningArrayList = new ArrayList<>();

        while(cursor.moveToNext()){
            String itemDate = cursor.getString(
                    cursor.getColumnIndexOrThrow(DatabaseContract.Workout.COLUMN_NAME_DATE));

            String itemDay = cursor.getString(
                    cursor.getColumnIndexOrThrow(DatabaseContract.Workout.COLUMN_NAME_DAY_OF_THE_WEEK));

            long id = cursor.getLong(
                    cursor.getColumnIndexOrThrow(DatabaseContract.Workout._ID));

            TreningObject object1 = new TreningObject(id, itemDate, itemDay);
            treningArrayList.add(object1);

        }



        TrainingAdapter trainingAdapter = new TrainingAdapter(this, treningArrayList, new ButtonInterface() {
            @Override
            public void buttonOnClick(TreningObject object) {
                Intent intent = new Intent(PreviewActivity.this, ExpandActivity.class);
                long id = object.getId();
                intent.putExtra("id", id);
                startActivity(intent);
            }

            @Override
            public void deleteOnClick(TreningObject id, int position) {
                String selection = DatabaseContract.Workout._ID + " LIKE ?";
                String selectionExercise = DatabaseContract.Exercises.COLUMN_NAME_ID_WORKOUT + " LIKE ?";

                long deleteId = id.getId();
                treningArrayList.remove(deleteId);

                String[] selectionArgs = {deleteId+""};
                String[] selectionExerciseArgs = {deleteId+""};
                db.delete(DatabaseContract.Workout.TABLE_NAME, selection, selectionArgs);
                db.delete(DatabaseContract.Exercises.TABLE_NAME, selectionExercise, selectionExerciseArgs);


            }
        });

        recycleView.setAdapter(trainingAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));

    }
}
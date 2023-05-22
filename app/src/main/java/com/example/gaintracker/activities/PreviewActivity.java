package com.example.gaintracker.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.widget.Button;

import com.example.gaintracker.ButtonInterface;
import com.example.gaintracker.R;
import com.example.gaintracker.RecycleviewAdapter;
import com.example.gaintracker.TreningObject;
import com.example.gaintracker.database.DatabaseContract;
import com.example.gaintracker.database.DatabaseHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PreviewActivity extends AppCompatActivity {

    //List dates, daysOfTheWeek;
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

            System.out.println(itemDate + itemDay);

            TreningObject object1 = new TreningObject(id, itemDate, itemDay);
            treningArrayList.add(object1);

        }

        RecycleviewAdapter recycleviewAdapter = new RecycleviewAdapter(this, treningArrayList, new ButtonInterface() {
            @Override
            public void buttonOnClick(TreningObject object) {
                Intent intent = new Intent(PreviewActivity.this, ExpandActivity.class);
                long id = object.getId();
            }
        }/*dateList, dayList*/);
        recycleView.setAdapter(recycleviewAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));











    }
}
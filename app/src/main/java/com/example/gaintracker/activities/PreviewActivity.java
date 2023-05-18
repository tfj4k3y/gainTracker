package com.example.gaintracker.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;

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
        /*
        //Ogólnie poniżej hardcodowa część aplikacji
        //Tutaj szukamy recyclerviewera w acticity_preview




        //Tutaj wklejamy dane w row_view

        cw = getResources().getStringArray(R.array.exercises);
        param = getResources().getStringArray(R.array.results);
        daty = getResources().getStringArray(R.array.dates);

        RecycleviewAdapter recycleviewAdapter = new RecycleviewAdapter(this, cw, param, daty);
        recycleView.setAdapter(recycleviewAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));*/


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

            System.out.println(itemDate + itemDay);

            TreningObject object1 = new TreningObject(itemDate, itemDay);
            treningArrayList.add(object1);

        }

        /*List<String> dateList = new ArrayList<>();
        while(cursor.moveToNext()){
            String itemDate = cursor.getString(
                    cursor.getColumnIndexOrThrow(DatabaseContract.Workout._ID));
            dateList.add(itemDate);
        }
        cursor.close();

        List<String> dayList = new ArrayList<>();
        while(cursor.moveToNext()){
            String itemDay = cursor.getString(
                    cursor.getColumnIndexOrThrow(DatabaseContract.Workout._ID));
            dayList.add(itemDay);
        }*/
        //cursor.close();

        RecycleviewAdapter recycleviewAdapter = new RecycleviewAdapter(this, treningArrayList/*dateList, dayList*/);
        recycleView.setAdapter(recycleviewAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));











    }
}
package com.example.gaintracker.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gaintracker.R;
import com.example.gaintracker.database.DatabaseContract;
import com.example.gaintracker.database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper dbHelper = new DatabaseHelper(this);

        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });

        Button previewButton = findViewById(R.id.previewButton);
        previewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PreviewActivity.class);

                //Dodawanie tabeli trening na starcie

                SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                //values.put(DatabaseContract.Workout.COLUMN_NAME_DATE, sDate);
                //values.put(DatabaseContract.Workout.COLUMN_NAME_DAY_OF_THE_WEEK, sDay);

                long newRowId = db.insert(DatabaseContract.Workout.TABLE_NAME, null, values);

                startActivity(intent);
            }
        });

        Button settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}
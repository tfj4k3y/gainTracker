package com.example.gaintracker.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.example.gaintracker.R;
import com.example.gaintracker.database.DatabaseHelper;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //DatabaseHelper dbHelper = new DatabaseHelper(getContext());

    }
}
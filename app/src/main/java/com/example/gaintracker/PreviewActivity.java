package com.example.gaintracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class PreviewActivity extends AppCompatActivity {

    String cw[], param[], daty[];
    RecyclerView recycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        recycleView = findViewById(R.id.recycleview);

        cw = getResources().getStringArray(R.array.exercises);
        param = getResources().getStringArray(R.array.results);
        daty = getResources().getStringArray(R.array.dates);

        RecycleviewAdapter recycleviewAdapter = new RecycleviewAdapter(this, cw, param, daty);
        recycleView.setAdapter(recycleviewAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));





    }
}
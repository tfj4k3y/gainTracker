package com.example.gaintracker.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gaintracker.R;

public class ExpandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand);


        //long trainingId = getIntent().getLongExtra("id", 0);
        Button backButton = findViewById(R.id.back_to_preview_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //System.out.println(trainingId);
            }
        });


    }
}
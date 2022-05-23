package com.hanback.sloppy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class How_to_play2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play2);

        Button buttonBack = findViewById(R.id.BackButton);
        buttonBack.setOnClickListener(v -> openSloppyActivity());
    }
    private void openSloppyActivity() { // ini buat ke screen level select
        Intent intent_SA = new Intent(this, SloppyActivity.class);
        startActivity(intent_SA);
    }
    }

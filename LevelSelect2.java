package com.hanback.sloppy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LevelSelect2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select2);

        Button buttonMenu = findViewById(R.id.MenuButton);
        buttonMenu.setOnClickListener(v -> openSloppyActivity());
    }
        private void openSloppyActivity() { // ini buat ke screen level select
            Intent intent_SA = new Intent(this, SloppyActivity.class);
            startActivity(intent_SA);
        }


}
package com.hanback.sloppy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.hanback.ledjni.LedJNI;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


import com.hanback.sloppy.databinding.ActivityMainBinding;

public class SloppyActivity extends AppCompatActivity {
    private char ledData = (char)0;
    private LedJNI ledJNI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.home_bar);

        com.hanback.sloppy.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int threelive = 7;

        // native method
        ledJNI = new LedJNI();
        ledData = (char)threelive; //2 lives
        ledJNI.on(ledData);

        //button to move to subactivity
        Button button = findViewById(R.id.StartButton);
        button.setOnClickListener(v -> openSubActivity());
        // ganti dari sini
        Button button_HTP = findViewById(R.id.HTPButton); // ini buat button di main screen How to Play
        button_HTP.setOnClickListener(v -> openSubActivity_HTP());
        Button button_LS = findViewById(R.id.LevelButton); // ini buat button di main screen level select
        button_LS.setOnClickListener(v -> openSubActivity_LS());
    }
        //sampe sini
    private void openSubActivity() {
        Intent intent = new Intent(this, LevelOne.class);
        startActivity(intent);
    }
    //dari sini
    private void openSubActivity_HTP() { // ini buat ke screen how to play
        Intent intent_LS = new Intent(this, How_to_play2.class);
        startActivity(intent_LS);
    }
    private void openSubActivity_LS() { // ini buat ke screen level select
        Intent intent_LS = new Intent(this, LevelSelect2.class);
        startActivity(intent_LS);
    }
    //sampe sini
}
package com.example.simon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Define needed variables
        var random = (0..3).random()
        val fourColors = arrayOf("Green", "Yellow", "Blue", "Red")
        val allColors: ArrayList<String> = arrayListOf(fourColors[random])
        val start = findViewById<Button>(R.id.Startbtn)
        val activitiesArray = arrayOf(MainActivity::class.java, Green::class.java, Yellow::class.java, Blue::class.java, Red::class.java)

        // Colors Simon says
        for (i in 0..3){
            random = (0..3).random()
            allColors.add(fourColors[random])
        }

        //start button used to begin game

        start.setOnClickListener {
            val intent = Intent(this@MainActivity, activitiesArray[random])
            intent.putStringArrayListExtra("colors",allColors)
            intent.putExtra("count",0)
            intent.putExtra("score",0)
            startActivity(intent)
        }
    }
}
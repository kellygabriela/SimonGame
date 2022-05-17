package com.example.simon

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.ButtonBarLayout

class Green : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_green)

        // Fetch buttons and text areas
        val level = findViewById<TextView>(R.id.Leveltxt)
        val scoreText = findViewById<TextView>(R.id.scoreText)
        val green = findViewById<Button>(R.id.GreenButton)
        val yellow = findViewById<Button>(R.id.YellowButton)
        val red = findViewById<Button>(R.id.RedButton)
        val blue = findViewById<Button>(R.id.BlueButton)
        val restart = findViewById<Button>(R.id.restartBtn)
        val activitiesArray = arrayOf(MainActivity::class.java, Green::class.java, Yellow::class.java, Blue::class.java, Red::class.java)

        //get count, index and color from intent
        var score = intent.getIntExtra("score", -2)
        var count = intent.getIntExtra("count",-3)
        val colors = intent.getStringArrayListExtra("colors")

        //update displayed score
        scoreText.text = score.toString()

        // Update title text
        if(score != count) {
            val temp = "Color: " + (count + 1)
            level.text = temp
        } else {
            val temp = "Simon says " + colors!![count]
            level.text = temp
        }

        fun gameOver(newTitle: String){
            colors!![count] = newTitle
            level.text = newTitle
            restart.visibility = View.VISIBLE
            red.text = newTitle
            yellow.text = newTitle
            green.text = newTitle

        }

        //Update game based on user's choice
        fun onCorrect(answer: String, classNum: Int) {
            if (colors!![count] == answer){
                val intent = Intent(this@Green, activitiesArray[classNum])
                if((count+1)== colors.size)
                    gameOver("YOU WIN")
                else {
                    if (count == score) {
                        count = -1
                        score++
                    }
                    count++

                    intent.putStringArrayListExtra("colors", colors)
                    intent.putExtra("count", count)
                    intent.putExtra("score", score)
                    startActivity(intent)
                }
            }
            else if (restart.visibility != 0){
                gameOver("gameOver")
            }

        }

        // on click listeners for each button
        green.setOnClickListener {
                onCorrect("Green",0)
        }
        yellow.setOnClickListener {
            onCorrect("Yellow",1)
        }
        blue.setOnClickListener {
            onCorrect("Blue",2)
        }
        red.setOnClickListener {
            onCorrect("Red",3)
        }
        restart.setOnClickListener {
            val intent = Intent(this@Green, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
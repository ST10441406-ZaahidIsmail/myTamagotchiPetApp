package com.example.mytamagotchipetapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // declaring start button and implementing logic
        val startButton = findViewById<Button>(R.id.getStartedBtn)
        startButton.setOnClickListener {
            // creating an  explicit intent to go to next activity using a button
            val intent = Intent(this, StartActivity()::class.java)
            startActivity(intent)
        }
    }
}
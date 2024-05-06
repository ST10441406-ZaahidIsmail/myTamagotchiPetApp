package com.example.mytamagotchipetapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.mytamagotchipetapp.R.id.imageViewMainStartup


class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        // creating functionality for hunger, happy and clean actions
        lateinit var hungerBar: ProgressBar
        lateinit var happyBar: ProgressBar
        lateinit var cleanBar: ProgressBar
        lateinit var hungerStatus: TextView
        lateinit var healthStatus: TextView
        lateinit var cleanlinessStatus: TextView


        var feedProgress = 0
        var happyProgress = 0
        var cleanProgress = 0

        // declaring variables
        val feedButton = findViewById<Button>(R.id.feedBtn)
        val resetBtn = findViewById<Button>(R.id.resetBtn)
        val playButton = findViewById<Button>(R.id.playBtn)
        val cleanButton = findViewById<Button>(R.id.cleanBtn)
        val imageViewMain = findViewById<ImageView>(imageViewMainStartup)
        hungerStatus = findViewById<TextView>(R.id.hungerStatus)
        healthStatus = findViewById<TextView>(R.id.healthStatus)
        cleanlinessStatus = findViewById<TextView>(R.id.cleanlinessStatus)


        // setting the first drawable to display before actions
        imageViewMain.setImageResource(R.drawable.main)

        // creating logic for progress bars
        hungerBar = findViewById(R.id.hungerBar)
        happyBar = findViewById(R.id.happyBar)
        cleanBar = findViewById(R.id.cleanBar)


        // creating logic for different variables to be displayed when feed, play and clean actions occur
        feedButton.setOnClickListener {
            if (feedProgress < 100) {
                imageViewMain.setImageResource(R.drawable.munching)
                feedProgress += 50
                hungerBar.progress = feedProgress
                hungerStatus.text = "Hunger: ${feedProgress}%"
            } else {
                // If hunger reaches 100, change the image to indicate that the pet is fed
                imageViewMain.setImageResource(R.drawable.munching_100)
            }

            // Reset image after 7 seconds
            imageViewMain.postDelayed({
                imageViewMain.setImageResource(R.drawable.main)
            }, 7000)
        }

        playButton.setOnClickListener {
            if (happyProgress < 100) {
                imageViewMain.setImageResource(R.drawable.happy_rocky)
                happyProgress += 50
                happyBar.progress = happyProgress
                healthStatus.text = "Health: ${happyProgress}%"
            } else {
                // If happiness reaches 100, change the image to a different state
                imageViewMain.setImageResource(R.drawable.happy_100)
            }

            // Reset image after 7 seconds
            imageViewMain.postDelayed({
                imageViewMain.setImageResource(R.drawable.main)
            }, 7000)
        }

        cleanButton.setOnClickListener {
            if (cleanProgress < 100) {
                imageViewMain.setImageResource(R.drawable.cleaning_rocky)
                cleanProgress += 50
                cleanBar.progress = cleanProgress
                cleanlinessStatus.text = "Clean: ${cleanProgress}%"
            } else {
                // If cleanliness reaches 100, change the image to indicate that the pet is clean
                imageViewMain.setImageResource(R.drawable.clean_100)
            }

            // Reset image to default(main) after 7 seconds
            imageViewMain.postDelayed({
                imageViewMain.setImageResource(R.drawable.main)
            }, 7000)
        }

        // implementing reset button to reset values and return imageview back to default image(main)
        resetBtn.setOnClickListener {
            hungerStatus.text = "0" // initialising textviews that display progress to 0
            healthStatus.text = "0"
            cleanlinessStatus.text = "0"
            hungerBar.progress = 0
            happyBar.progress = 0
            cleanBar.progress = 0
            feedProgress = 0 // initialising progress values to 0
            happyProgress = 0
            cleanProgress = 0
            imageViewMain.setImageResource(R.drawable.main) // resetting image view
        }


    }


}




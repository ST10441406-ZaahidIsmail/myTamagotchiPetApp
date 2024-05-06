package com.example.mytamagotchipetapp

import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith




class StartActivityTest {

    private lateinit var activity: StartActivity
    private lateinit var feedButton: Button
    private lateinit var playButton: Button
    private lateinit var cleanButton: Button
    private lateinit var resetButton: Button
    private lateinit var imageViewMain: ImageView
    private lateinit var hungerStatus: TextView
    private lateinit var healthStatus: TextView
    private lateinit var cleanlinessStatus: TextView
    private lateinit var hungerBar: ProgressBar
    private lateinit var happyBar: ProgressBar
    private lateinit var cleanBar: ProgressBar

    @Before
    fun setup() {

        feedButton = activity.findViewById(R.id.feedBtn)
        playButton = activity.findViewById(R.id.playBtn)
        cleanButton = activity.findViewById(R.id.cleanBtn)
        resetButton = activity.findViewById(R.id.resetBtn)
        imageViewMain = activity.findViewById(R.id.imageViewMainStartup)
        hungerStatus = activity.findViewById(R.id.hungerStatus)
        healthStatus = activity.findViewById(R.id.healthStatus)
        cleanlinessStatus = activity.findViewById(R.id.cleanlinessStatus)
        hungerBar = activity.findViewById(R.id.hungerBar)
        happyBar = activity.findViewById(R.id.happyBar)
        cleanBar = activity.findViewById(R.id.cleanBar)
    }

    @Test
    fun testFeedButtonAction() {
        feedButton.performClick()
        assertEquals(50, hungerBar.progress)
        assertEquals("Hunger: 50%", hungerStatus.text)
    }

    @Test
    fun testPlayButtonAction() {
        playButton.performClick()
        assertEquals(50, happyBar.progress)
        assertEquals("Health: 50%", healthStatus.text)
    }

    private fun assertEquals(i: String, progress: CharSequence?) {
        TODO("Not yet implemented")
    }

    @Test
    fun testCleanButtonAction() {
        cleanButton.performClick()
        assertEquals(50, cleanBar.progress)
        assertEquals("Clean: 50%", cleanlinessStatus.text)
    }

    private fun assertEquals(i: Int, progress: Int) {


    }

    @Test
    fun testResetButtonAction() {
        feedButton.performClick()
        playButton.performClick()
        cleanButton.performClick()
        resetButton.performClick()
        assertEquals(0, hungerBar.progress)
        assertEquals(0, happyBar.progress)
        assertEquals(0, cleanBar.progress)
        assertEquals("0", hungerStatus.text)
        assertEquals("0", healthStatus.text)
        assertEquals("0", cleanlinessStatus.text)
    }
}

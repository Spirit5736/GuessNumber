package com.example.guessnumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class WellcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wellcome)
    }

    fun onMainPage (view: View) {
        val onMainPagePageIntent = Intent (this, MainActivity ::class.java)
        startActivity(onMainPagePageIntent)
    }
}
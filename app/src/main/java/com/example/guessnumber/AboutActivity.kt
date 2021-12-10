package com.example.guessnumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    fun onFirstPage (view: View) {
        val onFirstPageIntent = Intent (this, MainActivity ::class.java)
        startActivity(onFirstPageIntent)
    }
}
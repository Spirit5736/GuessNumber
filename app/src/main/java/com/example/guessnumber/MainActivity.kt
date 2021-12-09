package com.example.guessnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var answer = 0
    var isGameOver = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startOver()
    }

    private fun generateAnswer() {
        answer = Random.nextInt(1, 25)
    }

    private fun startOver() {
        isGameOver = false
        generateAnswer()

        val answerTextView = findViewById<TextView>(R.id.answer)
        answerTextView.text = "##"
    }

    fun btnStartOverTapped(view: View) {
        startOver()
    }

    fun btnSubmitTapped(view: View) {
        val guess = getUsersGuess() ?: -999

        val textView = findViewById<TextView>(R.id.textView)
        if (guess !in 1..25)

        isGameOver = true

        val answerTextView = findViewById<TextView>(R.id.answer)
        answerTextView.text = answer.toString()
    }

    fun getUsersGuess() : Int? {
        val editTextGuess = findViewById<EditText>(R.id.editTextGuess)
        val usersGuess = editTextGuess.text.toString()

        var guessAsInt = 0

        try {
            guessAsInt = usersGuess.toInt()
        }
        catch (e: Exception) {
            return null
        }
        return  guessAsInt
    }
}
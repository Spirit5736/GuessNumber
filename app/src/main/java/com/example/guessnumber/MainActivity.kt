package com.example.guessnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var answer = 0
    var isGameOver = false
    var numOfAttempts = 0

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

        val submitButton = findViewById<Button>(R.id.buttonSubmit)
        submitButton.isEnabled = true

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "Угадай число от 1 до 25"

        val editTextGuess = findViewById<EditText>(R.id.editTextGuess)
        editTextGuess.text.clear()
    }

    fun btnStartOverTapped(view: View) {
        startOver()
    }

    fun btnSubmitTapped(view: View) {
        val guess = getUsersGuess() ?: -999

        val textView = findViewById<TextView>(R.id.textView)
        if (guess !in 1..25) {
            textView.text = "Число должно быть от 1 до 25"
            return
        }

        var message = ""
        numOfAttempts++

        if(guess == answer) {
            message = "Правильно! Вы угадали число за $numOfAttempts попыток"

            isGameOver = true

            val answerTextView = findViewById<TextView>(R.id.answer)
            answerTextView.text = answer.toString()

            val submitButton = findViewById<Button>(R.id.buttonSubmit)
            submitButton.isEnabled = false
        }
        else {
            message = if (guess < answer) "Загаданное число больше" else "Загаданное число меньше"
        }

        textView.text = message
    }

    private fun getUsersGuess() : Int? {
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
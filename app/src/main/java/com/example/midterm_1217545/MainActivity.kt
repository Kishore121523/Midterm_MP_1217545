package com.example.midterm_1217545

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1Field: EditText = findViewById(R.id.number_1)
        val num2Field: EditText = findViewById(R.id.number_2)

        val addBtn: Button = findViewById(R.id.btnAdd)
        val subBtn: Button = findViewById(R.id.btnSub)
        val multBtn: Button = findViewById(R.id.btnMult)
        val divBtn: Button = findViewById(R.id.btnDiv)
        val nextPageQ2Btn: Button = findViewById(R.id.nextPageQ2)

        val resultLabel: TextView = findViewById(R.id.result)
        val result: TextView = findViewById(R.id.sumValue)

        // Setting up click listeners for all buttons
        addBtn.setOnClickListener {
            calculateResult(num1Field, num2Field, resultLabel, result, "add")
        }
        subBtn.setOnClickListener {
            calculateResult(num1Field, num2Field, resultLabel, result, "sub")
        }
        multBtn.setOnClickListener {
            calculateResult(num1Field, num2Field, resultLabel, result, "mult")
        }
        divBtn.setOnClickListener {
            calculateResult(num1Field, num2Field, resultLabel, result, "div")
        }

        // Go to Question 2 intent
        nextPageQ2Btn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun calculateResult(num1Field: EditText, num2Field: EditText, resultLabel: TextView, result: TextView, operation: String) {
        // Getting the value from the selected editText fields and converting it to integer
        val num1 = num1Field.text.toString().toInt()
        val num2 = num2Field.text.toString().toInt()

        // Using WHEN statement we are comparing the text passed in "operation" parameter, and when it matches with one of the four \
        // operations it will perform that specific operation.
        val output = when (operation) {
            "add" -> sum(num1, num2).toString()
            "sub" -> sub(num1, num2).toString()
            "mult" -> mult(num1, num2).toString()
            "div" -> if (num2 != 0) div(num1, num2).toString() else "Error"
            else -> "Invalid operation"
        }

        // Setting the text of the result textView with the value of the output generated
        result.text = output
    }
}

// Functions to calculate the results
fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sub(a: Int, b: Int): Int {
    return a - b
}

fun mult(a: Int, b: Int): Int {
    return a * b
}

fun div(a: Int, b: Int): Float {
    // Checking for division by 0 error
    return if (b != 0) {
        a.toFloat() / b.toFloat()
    } else {
        Float.NaN
    }
}
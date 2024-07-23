package com.example.midterm_1217545

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_activity)

        // Getting the passed data usign intent
        val firstName: String? = intent.getStringExtra("Passed_Name")
        val lastName: String? = intent.getStringExtra("Passed_Lname")
        val phoneNumber: String? = intent.getStringExtra("Passed_Phone")
        val favFood: String? = intent.getStringExtra("Passed_FavFood")

        val backToSecondActivityButton: Button = findViewById(R.id.goToSecondActivity)

        val resultTextView: TextView = findViewById(R.id.resultTextView)

        // Displaying the details send through putExtra
        val resultText = """
            First Name: $firstName
            Last Name: $lastName
            Phone Number: $phoneNumber
            Favorite Food: $favFood
        """.trimIndent()

        resultTextView.text = resultText

        backToSecondActivityButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}

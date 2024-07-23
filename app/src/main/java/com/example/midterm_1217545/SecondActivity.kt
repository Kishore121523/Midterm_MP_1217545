package com.example.midterm_1217545

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val firstName: EditText = findViewById(R.id.fName)
        val lastName: EditText = findViewById(R.id.lName)
        val phoneNumber: EditText = findViewById(R.id.contactNum)
        val favFoodSpinner: Spinner = findViewById(R.id.favFood)
        val signUpButton: Button = findViewById(R.id.goToQ3)

        // Setting up the spinner with an array of values
        val favFoodArray = arrayOf("Poha", "Biriyani", "Dosa", "Idly", "Noodles")
        val adapter = ArrayAdapter(this, R.layout.spinner_item, favFoodArray)
        adapter.setDropDownViewResource(R.layout.spinner_item)
        favFoodSpinner.adapter = adapter

        // Variable to store the selected item
        var selectedFood: String? = null

        // onItemSelectedListener for the spinner data
        favFoodSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedFood = favFoodArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }

        // setOnClickListener for passing the values to the next activity using putExtra
        signUpButton.setOnClickListener {
            val fname = firstName.text.toString()
            val lname = lastName.text.toString()
            val phoneNum = phoneNumber.text.toString()

            val intent = Intent(this, ThirdActivity::class.java).apply {
                putExtra("Passed_Name", fname)
                putExtra("Passed_Lname", lname)
                putExtra("Passed_Phone", phoneNum)
                putExtra("Passed_FavFood", selectedFood)
            }

            startActivity(intent)
        }
    }
}

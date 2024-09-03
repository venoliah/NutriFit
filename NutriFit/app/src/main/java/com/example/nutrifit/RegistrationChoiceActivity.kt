package com.example.nutrifit

//import RegistrationActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.nutrifit.R

class RegistrationChoiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_choice_activity)

        // Find the button for signing up with email
        val registerWithEmailButton = findViewById<Button>(R.id.register_with_email)

        // Set an OnClickListener on the button
        registerWithEmailButton.setOnClickListener {
            // Create an intent to navigate to RegistrationActivity
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}

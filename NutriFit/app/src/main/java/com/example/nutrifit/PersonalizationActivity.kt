package com.example.nutrifit

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class PersonalizationActivity : AppCompatActivity() {

    private lateinit var welcomeTextView: TextView
    private lateinit var consentCheckbox: CheckBox
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personalization)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Find views
        welcomeTextView = findViewById(R.id.welcome_text)
        consentCheckbox = findViewById(R.id.consent_checkbox)

        // Get user email
        val userEmail = auth.currentUser?.email ?: "User"
        welcomeTextView.text = "Welcome, $userEmail"

        // Set click listener for the checkbox
        consentCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Open MyDetailsActivity
                val intent = Intent(this, MyDetailsActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

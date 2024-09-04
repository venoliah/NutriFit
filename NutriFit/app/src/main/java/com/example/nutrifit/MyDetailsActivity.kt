package com.example.nutrifit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ProgressBar
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth

class MyDetailsActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var profileCircle: TextView
    private lateinit var profileEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_details)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        profileCircle = findViewById(R.id.profile_circle)
        profileEmail = findViewById(R.id.profile_email)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Get the user's email from FirebaseAuth
        val email = auth.currentUser?.email ?: "User"

        // Set the first letter in the profile circle
        profileCircle.text = email.first().toString().uppercase()

        // Set the email without the domain
        profileEmail.text = email.substringBefore('@')

        // Set up click listeners
        findViewById<TextView>(R.id.demographic).setOnClickListener { openMainActivity() }
        findViewById<ProgressBar>(R.id.progress_demographic).setOnClickListener { openMainActivity() }

        findViewById<TextView>(R.id.medical).setOnClickListener { openMainActivity() }
        findViewById<ProgressBar>(R.id.progress_medical).setOnClickListener { openMainActivity() }

        findViewById<TextView>(R.id.eating).setOnClickListener { openMainActivity() }
        findViewById<ProgressBar>(R.id.progress_eating).setOnClickListener { openMainActivity() }

        findViewById<TextView>(R.id.nutrition).setOnClickListener { openMainActivity() }
        findViewById<ProgressBar>(R.id.progress_nutrition).setOnClickListener { openMainActivity() }

        findViewById<TextView>(R.id.physical).setOnClickListener { openMainActivity() }
        findViewById<ProgressBar>(R.id.progress_physical).setOnClickListener { openMainActivity() }

        findViewById<Button>(R.id.submit_btn).setOnClickListener { openMainActivity() }
    }

    private fun openMainActivity() {
        val intent = Intent(this, PersonalizedFragmentsActivity::class.java)
        startActivity(intent)
    }
}

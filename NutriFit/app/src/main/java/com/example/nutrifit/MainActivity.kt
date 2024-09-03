package com.example.nutrifit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var signOutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        // Find the sign-out button
        signOutButton = findViewById(R.id.btn_sign_out)

        // Set click listener for sign-out button
        signOutButton.setOnClickListener {
            auth.signOut()
            // Navigate back to LoginActivity after signing out
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Optional: close the MainActivity so the user can't go back to it
        }
    }
}

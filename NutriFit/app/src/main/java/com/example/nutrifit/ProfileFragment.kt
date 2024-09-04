package com.example.nutrifit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var profileCircle: TextView
    private lateinit var profileEmail: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        profileCircle = view.findViewById(R.id.profile_circle)
        profileEmail = view.findViewById(R.id.profile_email)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Get the user's email from FirebaseAuth
        val email = auth.currentUser?.email ?: "User"

        // Set the first letter in the profile circle
        profileCircle.text = email.first().toString().uppercase()

        // Set the email without the domain
        profileEmail.text = email.substringBefore('@')

        return view
    }
}

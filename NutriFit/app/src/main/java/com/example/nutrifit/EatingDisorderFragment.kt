package com.example.nutrifit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment

class EatingDisorderFragment : Fragment() {

    private lateinit var copingMechanismsSpinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_eating_disorder, container, false)

        // Initialize views
        copingMechanismsSpinner = view.findViewById(R.id.coping_mechanisms_spinner)

        // Set up coping mechanisms spinner
        val copingList = listOf("Talking to someone", "Exercise", "Meditation", "Journaling", "Other")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, copingList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        copingMechanismsSpinner.adapter = adapter

        return view
    }
}

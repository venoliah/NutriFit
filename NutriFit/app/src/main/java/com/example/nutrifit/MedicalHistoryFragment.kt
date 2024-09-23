package com.example.nutrifit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment

class MedicalHistoryFragment : Fragment() {

    private lateinit var conditionsSpinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_medical_history, container, false)

        // Initialize views
        conditionsSpinner = view.findViewById(R.id.conditions_spinner)

        // Set up conditions spinner
        val conditionsList = listOf(
            "High Blood Pressure",
            "Diabetes",
            "High Cholesterol",
            "Insomnia",
            "Osteoarthritis",
            "Depression",
            "None"
        )
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, conditionsList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        conditionsSpinner.adapter = adapter

        return view
    }
}

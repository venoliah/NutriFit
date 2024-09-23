package com.example.nutrifit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.GridLayout
import android.widget.RadioButton
import android.widget.Spinner
import androidx.fragment.app.Fragment

class PhysicalActivityFragment : Fragment() {

    private lateinit var exerciseFrequencySpinner: Spinner
    private lateinit var typesOfActivitiesSpinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_physical_activity, container, false)

        // Initialize views
        exerciseFrequencySpinner = view.findViewById(R.id.exercise_frequency_spinner)
        typesOfActivitiesSpinner = view.findViewById(R.id.types_of_activities_spinner)

        // Set up exercise frequency spinner
        val exerciseFrequencyList = listOf("Daily", "Several times a week", "Once a week", "Rarely", "Never")
        val frequencyAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, exerciseFrequencyList)
        frequencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        exerciseFrequencySpinner.adapter = frequencyAdapter

        // Set up types of activities spinner
        val activitiesList = listOf("Running", "Yoga", "Strength Training", "Swimming", "Cycling")
        val activitiesAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, activitiesList)
        activitiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        typesOfActivitiesSpinner.adapter = activitiesAdapter

        return view
    }
}

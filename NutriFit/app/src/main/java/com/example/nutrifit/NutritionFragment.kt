package com.example.nutrifit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.AppCompatSpinner

class NutritionFragment : Fragment() {

    private lateinit var mealsPerDaySpinner: Spinner
    private lateinit var typesOfFoodsSpinner: Spinner
    private lateinit var dietaryRestrictionsSpinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nutrition, container, false)

        // Initialize spinners
        mealsPerDaySpinner = view.findViewById(R.id.meals_per_day_spinner)
        typesOfFoodsSpinner = view.findViewById(R.id.types_of_foods_spinner)
        dietaryRestrictionsSpinner = view.findViewById(R.id.dietary_restrictions_spinner)

        // Set up meals per day spinner
        val mealsList = arrayOf("1", "2", "3", "4", "5", "More than 5")
        val mealsAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, mealsList)
        mealsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mealsPerDaySpinner.adapter = mealsAdapter

        // Set up types of foods spinner
        val foodTypesList = arrayOf("Vegetarian", "Vegan", "High-Protein", "Low-Carb", "Other")
        val foodTypesAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, foodTypesList)
        foodTypesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        typesOfFoodsSpinner.adapter = foodTypesAdapter

        // Set up dietary restrictions spinner
        val dietaryRestrictionsList = arrayOf("None", "Gluten-Free", "Dairy-Free", "Nut-Free", "Other")
        val dietaryRestrictionsAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, dietaryRestrictionsList)
        dietaryRestrictionsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        dietaryRestrictionsSpinner.adapter = dietaryRestrictionsAdapter

        return view
    }
}

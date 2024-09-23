package com.example.nutrifit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment

class DemographicsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_demographics, container, false)

        // Initialize the Spinner here, after the view is inflated
        val ageSpinner = view.findViewById<Spinner>(R.id.age_spinner)

        // Create a list of ages from 18 to 100
        val ageList = (18..100).toList()

        // Create an ArrayAdapter using the ageList
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, ageList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Set the adapter to the Spinner
        ageSpinner.adapter = adapter

        // Handle the selection of the age
        ageSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedAge = ageList[position]
                // Handle the selected age
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle when nothing is selected
            }
        }

        return view
    }
}

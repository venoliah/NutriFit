package com.example.nutrifit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.nutrifit.databinding.ActivityPersonalizedFragmentsBinding

class PersonalizedFragmentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonalizedFragmentsBinding

    private val demographicsFragment = DemographicsFragment()
    private val medicalHistoryFragment = MedicalHistoryFragment()
    private val eatingDisorderFragment = EatingDisorderFragment()
    private val nutritionFragment = NutritionFragment()
    private val physicalActivityFragment = PhysicalActivityFragment()

    // Keep track of the current fragment
    private var currentFragment: Fragment = demographicsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalizedFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Start with the DemographicsFragment as the default
        replaceFragment(demographicsFragment)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.left_arrow -> navigateToPrevious()
                R.id.right_arrow -> navigateToNext()
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        currentFragment = fragment
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

    private fun navigateToPrevious() {
        when (currentFragment) {
            demographicsFragment -> {
                // Go to MyDetailsActivity
                startActivity(Intent(this, MyDetailsActivity::class.java))
                finish()
            }
            medicalHistoryFragment -> replaceFragment(demographicsFragment)
            eatingDisorderFragment -> replaceFragment(medicalHistoryFragment)
            nutritionFragment -> replaceFragment(eatingDisorderFragment)
            physicalActivityFragment -> replaceFragment(nutritionFragment)
        }
    }

    private fun navigateToNext() {
        when (currentFragment) {
            demographicsFragment -> replaceFragment(medicalHistoryFragment)
            medicalHistoryFragment -> replaceFragment(eatingDisorderFragment)
            eatingDisorderFragment -> replaceFragment(nutritionFragment)
            nutritionFragment -> replaceFragment(physicalActivityFragment)
            physicalActivityFragment -> {
                // Go to MyDetailsActivity
                startActivity(Intent(this, MyDetailsActivity::class.java))
                finish()
            }
        }
    }
}

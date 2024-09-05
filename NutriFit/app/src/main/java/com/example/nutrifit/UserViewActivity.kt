package com.example.nutrifit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.nutrifit.databinding.ActivityUserViewBinding

class UserViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserViewBinding.inflate(layoutInflater)
        setContentView(binding.root)  // Corrected the setContentView

        replaceFragment(ChatFragment())  // Start with CameraFragment as default

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(ProfileFragment())
                R.id.cam -> replaceFragment(CameraFragment())
                R.id.chat -> replaceFragment(ChatFragment())
                R.id.workout -> replaceFragment(WorkoutFragment())
                else -> false
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}

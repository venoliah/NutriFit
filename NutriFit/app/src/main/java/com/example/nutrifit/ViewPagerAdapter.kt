package com.example.nutrifit

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 2 // Number of tabs

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NutriChatOfficialFragment() // Fragment for NutriChat
            1 -> NutriBotFragment()  // Fragment for NutriBot
            else -> throw IllegalStateException("Invalid position $position")
        }
    }
}

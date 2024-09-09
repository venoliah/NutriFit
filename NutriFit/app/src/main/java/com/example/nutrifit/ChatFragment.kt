package com.example.nutrifit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class ChatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)

        val viewPager: ViewPager2 = view.findViewById(R.id.view_pager)
        val tabLayout = view.findViewById<com.google.android.material.tabs.TabLayout>(R.id.tab_layout)

        // Set up ViewPager with the adapter
        val adapter = ViewPagerAdapter(requireActivity())
        viewPager.adapter = adapter

        // Link the TabLayout and the ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "NutriChat"
                1 -> "NutriBot"
                else -> null
            }
        }.attach()

        return view
    }
}


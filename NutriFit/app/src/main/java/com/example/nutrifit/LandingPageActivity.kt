package com.example.nutrifit

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class LandingPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landingpage_activity)

        // Initialize ViewPager2 instances
        val viewPager1 = findViewById<ViewPager2>(R.id.view_pager1)
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager2)
        val viewPager3 = findViewById<ViewPager2>(R.id.view_pager3)

        // Image resource IDs
        val foodImages = listOf(
            R.drawable.food1,
            R.drawable.food2,
            R.drawable.food3
        )

        val mentalhealthImages = listOf(
            R.drawable.mentalhealth1,
            R.drawable.mentalhealth2,
            R.drawable.mentalhealth3
        )

        val exerciseImages = listOf(
            R.drawable.exercise1,
            R.drawable.exercise2,
            R.drawable.exercise3
        )

        
        // Create adapters for each ViewPager2
        val carouselAdapter1 = CarouselRVAdapter(foodImages)
        val carouselAdapter2 = CarouselRVAdapter(exerciseImages) // Use different lists if needed
        val carouselAdapter3 = CarouselRVAdapter(mentalhealthImages) // Use different lists if needed

        // Set adapters to ViewPager2 instances
        viewPager1.adapter = carouselAdapter1
        viewPager2.adapter = carouselAdapter2
        viewPager3.adapter = carouselAdapter3

        // Create and set the page transformer
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer((40 * resources.displayMetrics.density).toInt()))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = (0.80f + r * 0.20f)
        }

        viewPager1.setPageTransformer(compositePageTransformer)
        viewPager2.setPageTransformer(compositePageTransformer)
        viewPager3.setPageTransformer(compositePageTransformer)

        findViewById<View>(R.id.register_button).setOnClickListener {
            val intent = Intent(this, RegistrationChoiceActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.login_button).setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
                }
    }
}

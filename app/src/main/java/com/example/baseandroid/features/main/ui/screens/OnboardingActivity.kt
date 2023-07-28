package com.example.baseandroid.features.main.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.baseandroid.R
import com.example.baseandroid.databinding.ActivityOnboardingBinding
import com.example.baseandroid.features.main.adapter.ViewPagerAdapter

class OnboardingActivity : ComponentActivity() {

    lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pagerData = ArrayList<PagerData>()
        pagerData.add(PagerData(R.drawable.logo,
            "Select Nearest Restaurant",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut"))
        pagerData.add(PagerData(R.drawable.logo,
            "Your Drop Location",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut"))
        pagerData.add(PagerData(R.drawable.logo,
            "Delivery",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut"))

        binding.viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.viewpager.adapter = ViewPagerAdapter(pagerData) {

        }

    }

    data class PagerData(
        val images: Int,
        val title: String,
        val decs: String,
    )

}
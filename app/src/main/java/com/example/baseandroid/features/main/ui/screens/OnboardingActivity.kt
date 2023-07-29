package com.example.baseandroid.features.main.ui.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.baseandroid.R
import com.example.baseandroid.databinding.ActivityOnboardingBinding
import com.example.baseandroid.features.main.adapter.ViewPagerAdapter
import com.example.baseandroid.features.main.ui.screens.LoginScreen.LoginActivity
import kotlinx.coroutines.*

class OnboardingActivity : ComponentActivity() {

    lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pagerData = ArrayList<PagerData>()
        pagerData.add(PagerData(
            R.drawable.iv_onboarding_1,
            "Select Nearest Restaurant",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut"))
        pagerData.add(PagerData(R.drawable.logo,
            "Your Drop Location",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut"))
        pagerData.add(PagerData(R.drawable.logo,
            "Delivery",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut"))
        binding.viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        val totalPages = 3
        CoroutineScope(Dispatchers.Main).launch {
            while (isActive) {
                delay(3000)
                if (binding.viewpager.currentItem + 1 > totalPages - 1) {
                    binding.viewpager.currentItem = 0
                } else {
                    binding.viewpager.currentItem++
                }
            }
        }
        binding.viewpager.adapter = ViewPagerAdapter(pagerData) {

        }

        binding.btnGetStarted.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        binding.dotsIndicator.attachTo(binding.viewpager)
    }

    data class PagerData(
        val images: Int,
        val title: String,
        val decs: String,
    )

}
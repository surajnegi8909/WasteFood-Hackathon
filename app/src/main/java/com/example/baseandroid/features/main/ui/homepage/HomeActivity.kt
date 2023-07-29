package com.example.baseandroid.features.main.ui.homepage

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.baseandroid.R
import com.example.baseandroid.databinding.ActivityHomeBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    private var backPressCount = 0
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        changeFragments(HomeFeedFragment())
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.tab_home -> {
                    changeFragments(HomeFeedFragment())
                }

                R.id.tab_history -> {
                    changeFragments(HistoryFeedFragment())
                }

                R.id.tab_profile -> {
                    changeFragments(ProfileFeedFragment())
                }
            }
            true
        }
    }


    override fun onResume() {
        backPressCount = 0
        super.onResume()
    }

    override fun onBackPressed() {
        backPressCount++
        if (backPressCount > 1) onBackPressedDispatcher.onBackPressed()
        else Toast.makeText(this, "Press Again to Quit", Toast.LENGTH_SHORT).show()
        resetBack()
    }

    private fun resetBack() = lifecycleScope.launch {
        delay(2000)
        backPressCount = 0
    }

    private fun changeFragments(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentContainer.id, fragment)
        fragmentTransaction.commit()
    }
}
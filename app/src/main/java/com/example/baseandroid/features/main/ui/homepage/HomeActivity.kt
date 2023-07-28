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
        setContentView(binding.root)
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.tab_home -> {
                    changeFragments(HomeFeedFragment())
//                    viewModel.currentlyActive.add(1)
                }

                R.id.tab_discover -> {
//                    startActivity(Intent(this, SecondActivity::class.java))
                    changeFragments(ExploreFeedFragment())
//                    viewModel.currentlyActive.add(2)
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
        if (backPressCount > 1) super.getOnBackPressedDispatcher().onBackPressed()
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
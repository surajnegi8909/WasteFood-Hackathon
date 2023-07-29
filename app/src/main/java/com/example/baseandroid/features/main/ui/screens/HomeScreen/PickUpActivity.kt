package com.example.baseandroid.features.main.ui.screens.HomeScreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.baseandroid.databinding.ActivityPickUpBinding

class PickUpActivity : AppCompatActivity() {

    lateinit var binding: ActivityPickUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPickUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSummit.setOnClickListener {
            startActivity(Intent(this,DeliveryActivity::class.java))
        }
    }
}
package com.example.baseandroid.features.main.ui.screens.HomeScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.baseandroid.databinding.ActivityDeliveryBinding
import com.example.baseandroid.databinding.ActivityPickUpBinding

class DeliveryActivity : AppCompatActivity() {

    lateinit var binding: ActivityDeliveryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeliveryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSummit.setOnClickListener {


        }
    }
}
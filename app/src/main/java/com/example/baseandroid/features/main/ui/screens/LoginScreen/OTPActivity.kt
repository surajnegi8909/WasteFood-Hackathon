package com.example.baseandroid.features.main.ui.screens.LoginScreen

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.baseandroid.databinding.ActivityOtpactivityBinding
import com.example.baseandroid.features.main.ui.screens.MainActivity


class OTPActivity : AppCompatActivity() {
    lateinit var binding: ActivityOtpactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgContactBack.setOnClickListener {
            super.onBackPressed()
        }


        binding.otpView.otpListener?.onInteractionListener()


        binding.txtResend.setOnClickListener {
            Toast.makeText(this, "OTP sent successfully", Toast.LENGTH_SHORT).show()
        }

        binding.btnSummit.setOnClickListener {
            val otp = binding.otpView.otp.toString()
            if (otp.isNotEmpty()) {
                moveToHomeScreen()
            } else {
                Toast.makeText(this, "Enter OTP", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun moveToHomeScreen() {
        startActivity(Intent(this, MainActivity::class.java))
        finishAffinity()

    }

}
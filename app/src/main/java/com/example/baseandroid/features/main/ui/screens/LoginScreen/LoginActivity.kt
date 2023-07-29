package com.example.baseandroid.features.main.ui.screens.LoginScreen

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.baseandroid.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetOtp.setOnClickListener {
            validate()
        }

    }

    private fun validate(){
        if (TextUtils.isEmpty(binding.editTextPhone.text.toString()) && binding.editTextPhone.text.length !=10) {
            // when mobile number text field is empty
            // displaying a toast message.
            Toast.makeText(this, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show()
        } else {
           getOTPScreen()
        }
    }
    private fun getOTPScreen(){
        val intent = Intent(this,OTPActivity::class.java)
//        intent.putExtra("")
        startActivity(intent)
    }
}
package com.example.baseandroid.features.userRegistration.ui.screens

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import com.example.baseandroid.databinding.ActivityUserRegistrationBinding
import com.example.baseandroid.features.main.ui.screens.MainActivity
import com.github.drjacky.imagepicker.ImagePicker
import com.github.drjacky.imagepicker.constant.ImageProvider

class UserRegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserRegistrationBinding
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val uri = it.data?.data
                // Use the uri to load the image
                // Only if you are not using crop feature:
                binding.ivProfile.setImageURI(uri)

                //////////////
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        changeProfilePicture()
        changeViews()
        submitInfo()


    }

    private fun submitInfo() {
        binding.btnSubmit.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }

    private fun changeViews() {
        binding.radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            if (binding.radioVolunteer.id==i){
                binding.clNgo.visibility = View.GONE
                binding.clVolunteer.visibility = View.VISIBLE
            }
            else{
            binding.clVolunteer.visibility = View.GONE
            binding.clNgo.visibility = View.VISIBLE
        }


        }
    }

    private fun changeProfilePicture() {
        binding.ivEditProfile.setOnClickListener {
            ImagePicker.with(this)
                //...
                .provider(ImageProvider.BOTH) //Or bothCameraGallery()
                .createIntentFromDialog { launcher.launch(it) }
        }
    }
}
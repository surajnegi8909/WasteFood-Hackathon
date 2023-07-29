package com.example.baseandroid

import android.app.Activity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.baseandroid.databinding.ActivityDropUploadBinding
import com.github.drjacky.imagepicker.ImagePicker
import com.github.drjacky.imagepicker.constant.ImageProvider
import de.hdodenhof.circleimageview.CircleImageView

class DropUploadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDropUploadBinding
    private val btnList = listOf<CircleImageView>(
        binding.ivEditProfile,
        binding.ivEditProfile2,
        binding.ivEditProfile3,
        binding.ivEditProfile4
    )
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val uri = it.data?.data
                // Use the uri to load the image
                // Only if you are not using crop feature:
                binding.ivImage.setImageURI(uri)

                //////////////
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDropUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addImage()
    }

    private fun addImage() {

        btnList.forEach { button ->
            button.setOnClickListener {
                ImagePicker.with(this)
                    //...
                    .provider(ImageProvider.BOTH) //Or bothCameraGallery()
                    .createIntentFromDialog { launcher.launch(it) }
            }


        }
    }
}
package com.example.baseandroid.features.main.ui.homepage

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.baseandroid.databinding.FragmentProfileFeedBinding
import com.github.drjacky.imagepicker.ImagePicker
import com.github.drjacky.imagepicker.constant.ImageProvider

class ProfileFeedFragment : Fragment() {
    private lateinit var binding: FragmentProfileFeedBinding
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val uri = it.data?.data
                binding.ivProfile.setImageURI(uri)
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentProfileFeedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeProfilePicture()
        changeViews()
        submitInfo()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun submitInfo() {
        binding.btnSubmit.setOnClickListener {
            Toast.makeText(this.requireActivity(), "Details Saved", Toast.LENGTH_LONG).show()
        }
    }

    private fun changeViews() {
        binding.radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            if (binding.radioVolunteer.id == i) {
                binding.clNgo.visibility = View.GONE
                binding.clVolunteer.visibility = View.VISIBLE
            } else {
                binding.clVolunteer.visibility = View.GONE
                binding.clNgo.visibility = View.VISIBLE
            }


        }
    }

    private fun changeProfilePicture() {
        binding.ivEditProfile.setOnClickListener {
            ImagePicker.with(this.requireActivity())
                .provider(ImageProvider.BOTH) //Or bothCameraGallery()
                .createIntentFromDialog { launcher.launch(it) }
        }
    }
}
package com.example.baseandroid.features.main.ui.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.baseandroid.R

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFeedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFeedFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_feed, container, false)
    }

}
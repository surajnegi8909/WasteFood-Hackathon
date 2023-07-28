package com.example.baseandroid.features.main.ui.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.baseandroid.databinding.FragmentHomeFeedBinding

class HomeFeedFragment : Fragment() {
    private lateinit var binding: FragmentHomeFeedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeFeedBinding.inflate(layoutInflater)
        binding.rvNewsList.layoutManager = LinearLayoutManager(context)
//        binding.rvNewsList.adapter = NewsListAdapter(tempList) {
//            viewModel.setArticle(it)
//        }
        return binding.root
    }
}
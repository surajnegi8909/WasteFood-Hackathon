package com.example.baseandroid.features.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.baseandroid.R
import com.example.baseandroid.databinding.ViewpagerLayoutBinding
import com.example.baseandroid.features.main.ui.screens.OnboardingActivity

class ViewPagerAdapter(
    private var pagerList: ArrayList<OnboardingActivity.PagerData>,
    private val onClick: (OnboardingActivity.PagerData) -> Unit,
) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    class ViewHolder(itemBinding: ViewpagerLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        val image = itemBinding.imgPager
        val txtTitle = itemBinding.txtTitle
        val txtDesc = itemBinding.txtDecs

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ViewpagerLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return pagerList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.txtTitle.text = pagerList[position].title
        holder.txtDesc.text = pagerList[position].decs


            Glide.with(holder.image).load(pagerList[position].images).centerCrop()
                .placeholder(R.drawable.logo).into(holder.image)


        holder.itemView.setOnClickListener {
            onClick(pagerList[position])
        }
    }
}
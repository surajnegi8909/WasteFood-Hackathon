package com.example.baseandroid.features.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.baseandroid.R
import com.example.baseandroid.databinding.HomeFeedListItemBinding
import com.example.baseandroid.features.main.adapter.UserAdapter.ViewHolder
import com.example.baseandroid.features.main.models.UserResponse

class UserAdapter(private val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    private var userList = listOf<UserResponse>()
    fun setUserList(userList : List<UserResponse>){
        this.userList = userList
        notifyDataSetChanged()
    }

    //create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            HomeFeedListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.restaurantName.text = userList[position].name
        holder.location.text = userList[position].location
        holder.distance.text = userList[position].distance
        holder.pickupTime.text = userList[position].pickupTime
        when (userList[position].imageId) {
            1 -> {
                Glide.with(context)
                    .load("https://images.herzindagi.info/image/2023/Jan/best-restaurants-in-noida-3.jpg")
                    .apply(RequestOptions().placeholder(R.drawable.ic_placeholder))
                    .into(holder.image)
            }

            2 -> {
                Glide.with(context)
                    .load("https://imgstaticcontent.lbb.in/lbbnew/wp-content/uploads/sites/1/2017/08/01114540/250717BigChill%40Noida01.jpg")
                    .apply(RequestOptions().placeholder(R.drawable.ic_placeholder))
                    .into(holder.image)
            }

            3 -> {
                Glide.with(context)
                    .load("https://lh3.googleusercontent.com/XM28_UTGqGLvBJ9zErNQebToSOdIzeSZN8LKTlDjAuMByO9_-ZH2bV5B4IBEZ4y8F93dAJt4iQvbQfaEOp7zEJ2dVZA5i_ALh0P0r5XV=h450-rw")
                    .apply(RequestOptions().placeholder(R.drawable.ic_placeholder))
                    .into(holder.image)
            }

            4 -> {
                Glide.with(context)
                    .load("https://imgstaticcontent.lbb.in/lbbnew/wp-content/uploads/sites/1/2017/08/01114540/250717BigChill%40Noida01.jpg")
                    .apply(RequestOptions().placeholder(R.drawable.ic_placeholder))
                    .into(holder.image)
            }

            5 -> {
                Glide.with(context)
                    .load("https://images.herzindagi.info/image/2023/Jan/best-restaurants-in-noida-3.jpg")
                    .apply(RequestOptions().placeholder(R.drawable.ic_placeholder))
                    .into(holder.image)
            }

        }
        if (userList[position].preference) {
            Glide.with(context).load(R.drawable.iv_veg)
                .apply(RequestOptions().placeholder(R.drawable.ic_placeholder))
                .into(holder.preference)
        } else {
            Glide.with(context).load(R.drawable.iv_non_veg)
                .apply(RequestOptions().placeholder(R.drawable.ic_placeholder))
                .into(holder.preference)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return userList.size
    }

    // Holds the views for adding text
    class ViewHolder(private val binding: HomeFeedListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val image = binding.ivRestaurantImage
        val restaurantName = binding.tvRestaurantName
        val location = binding.tvLocation
        val distance = binding.tvDistance
        val pickupTime = binding.tvPickupTime
        val preference = binding.ivFoodPreference
    }
}
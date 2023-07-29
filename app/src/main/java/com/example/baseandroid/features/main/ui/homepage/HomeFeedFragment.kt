package com.example.baseandroid.features.main.ui.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.baseandroid.databinding.FragmentHomeFeedBinding
import com.example.baseandroid.features.main.adapter.UserAdapter
import com.example.baseandroid.features.main.models.UserResponse

class HomeFeedFragment : Fragment() {
    private lateinit var binding: FragmentHomeFeedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeFeedBinding.inflate(layoutInflater)
        binding.rvRestaurantsList.layoutManager = LinearLayoutManager(context)
        val restaurantList = createList()
        val adapterObject = UserAdapter(this.requireActivity())
        adapterObject.setUserList(restaurantList)
        binding.rvRestaurantsList.adapter = adapterObject
        return binding.root
    }

    private fun createList(): List<UserResponse> {
        val list: MutableList<UserResponse> = mutableListOf()

        list.add(
            UserResponse(
                imageId = 3,
                name = "Tasty Treats",
                location = "456 Park Avenue, Chhaproli",
                distance = "2.1km",
                pickupTime = "7:00pm",
                true
            )
        )


        list.add(
            UserResponse(
                imageId = 1,
                name = "Casa Bella",
                location = "789 Oak Street, Chhaproli",
                distance = "3.8km",
                pickupTime = "8:15pm",
                true
            )
        )


        list.add(
            UserResponse(
                imageId = 4,
                name = "Spice Junction",
                location = "222 Pine Road, Chhaproli",
                distance = "1.5km",
                pickupTime = "6:45pm",
                false
            )
        )


        list.add(
            UserResponse(
                imageId = 5,
                name = "Noodle House",
                location = "987 Elm Court, Chhaproli",
                distance = "4.0km",
                pickupTime = "9:00pm",
                true
            )
        )


        list.add(
            UserResponse(
                imageId = 2,
                name = "Mama Mia Pizzeria",
                location = "555 Cedar Lane, Chhaproli",
                distance = "3.2km",
                pickupTime = "7:30pm",
                false
            )
        )


        list.add(
            UserResponse(
                imageId = 3,
                name = "Green Garden",
                location = "111 Maple Avenue, Chhaproli",
                distance = "2.9km",
                pickupTime = "8:45pm",
                false
            )
        )


        list.add(
            UserResponse(
                imageId = 1,
                name = "Sizzling Steaks",
                location = "333 Birch Street, Chhaproli",
                distance = "3.5km",
                pickupTime = "8:30pm",
                true
            )
        )


        list.add(
            UserResponse(
                imageId = 4,
                name = "Asian Fusion",
                location = "777 Oak Avenue, Chhaproli",
                distance = "4.2km",
                pickupTime = "9:15pm",
                true
            )
        )


        list.add(
            UserResponse(
                imageId = 5,
                name = "Cheesy Delights",
                location = "888 Elm Road, Chhaproli",
                distance = "2.7km",
                pickupTime = "7:45pm",
                false
            )
        )

        list.add(
            UserResponse(
                imageId = 2,
                name = "The Burger Joint",
                location = "444 Pine Lane, Chhaproli",
                distance = "3.1km",
                pickupTime = "8:00pm",
                false
            )
        )
        return list
    }
}
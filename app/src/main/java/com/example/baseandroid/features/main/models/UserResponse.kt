package com.example.baseandroid.features.main.models


data class UserResponse(
    val imageId: Int,
    val name: String,
    val location: String,
    val distance: String,
    val pickupTime: String,
    val preference : Boolean
)

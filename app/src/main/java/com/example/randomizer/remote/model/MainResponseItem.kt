package com.example.randomizer.remote.model

import com.google.gson.annotations.SerializedName

data class MainResponseItem(
    val id: Int,
    @SerializedName("user_age")
    val age: Int,
    @SerializedName("user_gender")
    val gender: String,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("user_image")
    val image: String,
    @SerializedName("user_name")
    val name: String,
    @SerializedName("user_target")
    val target: String
)
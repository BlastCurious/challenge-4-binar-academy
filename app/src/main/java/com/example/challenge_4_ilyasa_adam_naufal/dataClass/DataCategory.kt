package com.example.challenge_4_ilyasa_adam_naufal.dataClass


import com.google.gson.annotations.SerializedName

data class DataCategory(
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("nama")
    val nama: String
)
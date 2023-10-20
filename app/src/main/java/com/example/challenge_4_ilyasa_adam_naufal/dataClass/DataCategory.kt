package com.example.challenge_4_ilyasa_adam_naufal.dataClass


import com.google.gson.annotations.SerializedName

data class DataCategory(
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("nama")
    val nama: String,
    @SerializedName("updatedAt")
    val updatedAt: String?
)
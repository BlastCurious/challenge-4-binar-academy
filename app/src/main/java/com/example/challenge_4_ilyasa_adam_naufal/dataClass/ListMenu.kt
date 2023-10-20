package com.example.challenge_4_ilyasa_adam_naufal.dataClass


import com.google.gson.annotations.SerializedName

data class ListMenu(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: List<DataListMenu>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Boolean
)
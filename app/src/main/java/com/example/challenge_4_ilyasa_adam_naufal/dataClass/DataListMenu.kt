package com.example.challenge_4_ilyasa_adam_naufal.dataClass


import com.google.gson.annotations.SerializedName

data class DataListMenu(
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("alamat_resto")
    val alamatResto: String,
    @SerializedName("detail")
    val detail: String,
    @SerializedName("harga")
    val harga: Int,
    @SerializedName("harga_format")
    val hargaFormat: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("nama")
    val nama: String,
    @SerializedName("updatedAt")
    val updatedAt: String?
)
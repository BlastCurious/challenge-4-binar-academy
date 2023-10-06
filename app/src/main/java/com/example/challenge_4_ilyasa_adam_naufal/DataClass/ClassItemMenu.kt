package com.example.challenge_4_ilyasa_adam_naufal.DataClass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemMenu(
	val name: String,
	val price: Int,
	val images: Int) : Parcelable
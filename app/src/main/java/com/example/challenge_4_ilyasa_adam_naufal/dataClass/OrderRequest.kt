package com.example.challenge_4_ilyasa_adam_naufal.dataClass

data class Order (
	val nama : String,
	val qty : Int?,
	val catatan: String?,
	val harga: Int?
)
data class OrderRequest(
	val username: String?,
	val total: Int?,
	val orders: List<Order?>?


)

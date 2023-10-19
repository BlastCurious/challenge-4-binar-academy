package com.example.challenge_4_ilyasa_adam_naufal.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.challenge_4_ilyasa_adam_naufal.database.Cart
import com.example.challenge_4_ilyasa_adam_naufal.database.CartRepo

class CartViewModel(application: Application) : ViewModel() {
	val repository: CartRepo = CartRepo(application)

	val allCartItems: LiveData<List<Cart>> = repository.getAllCartItems()

	fun deleteItemCart(cartId: Long) {
		repository.deleteItemCart(cartId)
	}

	fun updateQuantityItem(cart: Cart) {
		repository.updateQuantityItem(cart)
	}

	fun increment(cart: Cart) {
		val newTotal = cart.itemQuantity + 1
		cart.itemQuantity = newTotal

		cart.totalPrice = cart.priceMenu * newTotal

        updateQuantityItem(cart)
	}


	fun decrement(cart: Cart) {
		val newTotal = cart.itemQuantity - 1
		cart.itemQuantity = newTotal

		cart.totalPrice = cart.priceMenu * newTotal

        updateQuantityItem(cart)
	}


}

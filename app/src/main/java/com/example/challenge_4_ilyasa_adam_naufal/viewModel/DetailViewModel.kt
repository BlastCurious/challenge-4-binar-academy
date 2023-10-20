package com.example.challenge_4_ilyasa_adam_naufal.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challenge_4_ilyasa_adam_naufal.database.cart.Cart
import com.example.challenge_4_ilyasa_adam_naufal.database.cart.CartRepo
import com.example.challenge_4_ilyasa_adam_naufal.dataClass.ItemMenu

class DetailViewModel(application: Application) : ViewModel() {

    private val _counter = MutableLiveData(1)
    val counter: LiveData<Int> = _counter

    private val _totalPrice = MutableLiveData<Int>()
    val totalPrice: LiveData<Int> = _totalPrice

    private val _selectedItem = MutableLiveData<ItemMenu>()

    private val cartRepo: CartRepo

    init {
        cartRepo = CartRepo(application)
    }

    private fun insert(cart: Cart) {
        cartRepo.insert(cart)
    }


    fun initSelectedItem(item: ItemMenu) {
        _selectedItem.value = item
        _totalPrice.value = item.price

    }

    private fun total() {
        val currentAmount = _counter.value ?: 1
        val selectedItem = _selectedItem.value
        if (selectedItem != null) {
            val totalPrice = selectedItem.price * currentAmount
            _totalPrice.value = totalPrice
        }

    }

    fun increment() {
        _counter.value = (_counter.value ?: 1) + 1
        total()
    }


    fun decrement() {
        val currentValues: Int = _counter.value ?: 1
        if (currentValues > 1) {
            _counter.value = currentValues - 1
            total()
        }
    }

    fun addToCart() {
        val selectedItem = _selectedItem.value

        selectedItem?.let {
            val cartItem =
                totalPrice.value?.let { it1 ->
                    counter.value?.let { it2 ->
                        Cart(
                            itemName = it.name,
                            imgId = it.images,
                            priceMenu = it.price,
                            itemQuantity = it2,
                            totalPrice = it1,
                            itemNote = ""
                        )
                    }
                }
            cartItem?.let { it1 -> insert(it1) }
        }
    }

}




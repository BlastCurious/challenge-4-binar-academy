package com.example.challenge_4_ilyasa_adam_naufal.ViewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.challenge_4_ilyasa_adam_naufal.Database.Cart
import com.example.challenge_4_ilyasa_adam_naufal.Database.CartRepo

class CartViewModel(application: Application):ViewModel() {
    val repository: CartRepo = CartRepo(application)

    val allCartItems: LiveData<List<Cart>> = repository.getAllCartItems()

    //fun deleteAllMenu
}
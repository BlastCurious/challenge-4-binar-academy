package com.example.challenge_4_ilyasa_adam_naufal.ViewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailFragmentMenuViewModel::class.java)) {
            return DetailFragmentMenuViewModel(application) as T
        } else if (modelClass.isAssignableFrom(CartViewModel::class.java)) {
            return CartViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
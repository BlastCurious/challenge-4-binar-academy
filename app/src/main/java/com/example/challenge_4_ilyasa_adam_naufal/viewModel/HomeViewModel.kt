package com.example.challenge_4_ilyasa_adam_naufal.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challenge_4_ilyasa_adam_naufal.dataClass.ItemMenu

class HomeViewModel: ViewModel (){
    val isListView = MutableLiveData<Boolean>().apply { value = true }
    val menuItem = MutableLiveData<ArrayList<ItemMenu>>()
}
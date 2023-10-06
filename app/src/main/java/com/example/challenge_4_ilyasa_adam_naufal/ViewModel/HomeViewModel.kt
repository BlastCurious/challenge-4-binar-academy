package com.example.challenge_4_ilyasa_adam_naufal.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challenge_4_ilyasa_adam_naufal.DataClass.ItemMenu

class HomeViewModel: ViewModel (){
    val isListView = MutableLiveData<Boolean>().apply { value = true }
    val menuItem = MutableLiveData<ArrayList<ItemMenu>>()
}
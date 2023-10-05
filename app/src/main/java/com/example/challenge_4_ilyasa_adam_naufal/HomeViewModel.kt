package com.example.challenge_4_ilyasa_adam_naufal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class HomeViewModel: ViewModel (){
	val isListView = MutableLiveData<Boolean>().apply { value = true }

}
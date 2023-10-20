package com.example.challenge_4_ilyasa_adam_naufal.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.challenge_4_ilyasa_adam_naufal.database.profile.ProfileDAO
import com.example.challenge_4_ilyasa_adam_naufal.viewModel.ProfileViewModel

@Suppress("UNCHECKED_CAST")
class ProfileViewModelFactory(private val profileDAO: ProfileDAO): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(profileDAO) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
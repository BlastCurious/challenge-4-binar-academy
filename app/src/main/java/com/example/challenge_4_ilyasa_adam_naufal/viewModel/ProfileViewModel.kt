package com.example.challenge_4_ilyasa_adam_naufal.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challenge_4_ilyasa_adam_naufal.database.profile.Profile
import com.example.challenge_4_ilyasa_adam_naufal.database.profile.ProfileDAO
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileViewModel(private val profileDAO: ProfileDAO): ViewModel() {
	var profileLiveData: LiveData<Profile> = MutableLiveData()

	fun getUserByEmail() {
		val userEmail = Firebase.auth.currentUser?.email

		profileLiveData = userEmail!!.let { profileDAO.getProfile(userEmail) }
	}

}
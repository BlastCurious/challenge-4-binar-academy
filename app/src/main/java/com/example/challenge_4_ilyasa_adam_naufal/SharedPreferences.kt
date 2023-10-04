package com.example.challenge_4_ilyasa_adam_naufal

import android.content.Context

import android.core.content.edit

class SharedPreferences (context:Context) {
	private val sharedPrefrencesName = "SharedPreferenceBinarMart"
	private var preference = context.getSharedPreferences(sharedPrefrencesName, 0)

	var isGrid: Boolean
		set(value) {
			preference.edit{
				putBoolean("IS_Grid",value)
			}
		}
		get () = preference.getBoolean("IS_Grid", false)
}
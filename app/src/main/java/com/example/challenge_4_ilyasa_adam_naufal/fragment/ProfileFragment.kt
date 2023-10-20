package com.example.challenge_4_ilyasa_adam_naufal.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.challenge_4_ilyasa_adam_naufal.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference


class ProfileFragment : Fragment() {

	private lateinit var auth: FirebaseAuth
	private lateinit var databaseReference: DatabaseReference
	// TODO: Rename and change types of parameters
	private var param1: String? = null
	private var param2: String? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		arguments?.let {

		}
	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_profile, container, false)
	}

}
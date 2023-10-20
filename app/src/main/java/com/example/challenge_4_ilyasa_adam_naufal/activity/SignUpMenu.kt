package com.example.challenge_4_ilyasa_adam_naufal.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.challenge_4_ilyasa_adam_naufal.database.profile.Profile
import com.example.challenge_4_ilyasa_adam_naufal.database.profile.ProfileDatabase
import com.example.challenge_4_ilyasa_adam_naufal.databinding.ActivitySingupMenuBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class SignUpMenu : AppCompatActivity() {
	private lateinit var binding: ActivitySingupMenuBinding
	private lateinit var firebaseAuth: FirebaseAuth
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivitySingupMenuBinding.inflate(layoutInflater)
		setContentView(binding.root)

		firebaseAuth = FirebaseAuth.getInstance()

		binding.btnSignup.setOnClickListener {
			val email = binding.etEmailSignup.text.toString()
			val password = binding.etPwSignup.text.toString()

			val emailUser = binding.etEmailSignup.text.toString()
			val addressUser = binding.etAddress.text.toString()
			val mobileUser = binding.etMobile.text.toString()

			if (email.isNotEmpty() && password.isNotEmpty()) {
				firebaseAuth.createUserWithEmailAndPassword(email, password)
					.addOnCompleteListener(this) { task ->
						if (task.isSuccessful) {
							insertProfile(emailUser, addressUser, mobileUser)
							Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()

							val intent = Intent(this, LoginMenu::class.java)
							startActivity(intent)
							finish()
						} else {
							Toast.makeText(this, "Sign Up Unsuccessful", Toast.LENGTH_SHORT).show()
						}
					}
			} else {
				Toast.makeText(this, "Enter Email and Password", Toast.LENGTH_SHORT).show()
			}

			binding.tvLogintext.setOnClickListener {
				startActivity(Intent(this, LoginMenu::class.java))
				finish()
			}
		}
	}

	private fun insertProfile(email: String, address: String, mobile: String) {
		val executorService: ExecutorService = Executors.newSingleThreadExecutor()

		val profile = Profile(email = email, address = address, mobile = mobile)

		val profileDAO = ProfileDatabase.getInstance(application).profileDAO()

		executorService.execute {
			profileDAO.insert(profile)
		}

	}
}

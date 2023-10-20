package com.example.challenge_4_ilyasa_adam_naufal.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.challenge_4_ilyasa_adam_naufal.databinding.ActivityLoginMenuBinding
import com.google.firebase.auth.FirebaseAuth

class LoginMenu : AppCompatActivity() {

	private lateinit var binding: ActivityLoginMenuBinding
	private lateinit var firebaseAuth: FirebaseAuth

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityLoginMenuBinding.inflate(layoutInflater)
		setContentView(binding.root)

		firebaseAuth = FirebaseAuth.getInstance()

		binding.btnLogin.setOnClickListener {
			val email = binding.etEmailLogin.text.toString()
			val password = binding.etPwLogin.text.toString()

			if (email.isNotEmpty() && password.isNotEmpty()) {
				firebaseAuth.createUserWithEmailAndPassword(email, password)
					.addOnCompleteListener(this) { task ->
						if (task.isSuccessful) {
							Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
							val intent = Intent(this, MainActivity::class.java)
							startActivity(intent)
							finish()
						} else {
							Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
						}
					}
			} else {
				Toast.makeText(this, "Please Enter Email and Password", Toast.LENGTH_SHORT).show()
			}

			binding.tvSignup.setOnClickListener {
				startActivity(Intent(this, SignUpMenu::class.java))
				finish()
			}
		}
	}

	override fun onStart() {
		super.onStart()
		val currentUser = firebaseAuth.currentUser
		if (currentUser != null) {
			val intent = Intent(this, MainActivity::class.java)
			startActivity(intent)
			finish()
		}
	}
}
package com.example.challenge_4_ilyasa_adam_naufal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.challenge_4_ilyasa_adam_naufal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		replaceFragment(HomeFragment())

		binding.bottomNavBar.setOnItemSelectedListener {

			when (it.itemId) {

				R.id.home -> replaceFragment(HomeFragment())
				R.id.cart -> replaceFragment(CartFragment())
				R.id.history -> replaceFragment(HistoryFragment())
				R.id.profile -> replaceFragment(ProfileFragment())

				else -> {


				}

			}

			true

		}


	}

	private fun replaceFragment(fragment: Fragment) {

		val fragmentManager = supportFragmentManager
		val fragmentTransaction = fragmentManager.beginTransaction()
		fragmentTransaction.replace(R.id.navContainer, fragment)
		fragmentTransaction.commit()

	}
}
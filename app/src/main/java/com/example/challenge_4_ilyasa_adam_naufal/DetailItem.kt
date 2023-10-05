package com.example.challenge_4_ilyasa_adam_naufal

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.challenge_4_ilyasa_adam_naufal.databinding.FragmentDetailItemBinding

class DetailItem: Fragment() {
	private var _binding: FragmentDetailItemBinding? = null
	private val binding get() = _binding!!

	private val locationUri: String = "https://maps.app.goo.gl/SiFzf18kByYndQqg7"

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentDetailItemBinding.inflate(inflater, container, false)

		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		try  {
			val data = DetailItemArgs.fromBundle(arguments as Bundle)

			binding.nameadd.text = data.nameadd
			binding.priceadd.text = data.priceadd
			binding.imageadd.setImageResource(data.imageadd)

			binding.location.setOnClickListener {
				try {
					val intent = Intent(Intent.ACTION_VIEW, Uri.parse(locationUri))
					startActivity(intent)
				} catch (e: ActivityNotFoundException) {
					Toast.makeText(
						requireContext(),
						"Google Maps tidak terinstall.",
						Toast.LENGTH_SHORT
					).show()
				}
			}

		} catch (e: NullPointerException) {
			Toast.makeText(requireContext(), "Error: $e", Toast.LENGTH_SHORT).show()
		}

	}

	override fun onDestroy() {
		super.onDestroy()
		_binding = null
	}
}
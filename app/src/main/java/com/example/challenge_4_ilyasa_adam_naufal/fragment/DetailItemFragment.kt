package com.example.challenge_4_ilyasa_adam_naufal.fragment

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.challenge_4_ilyasa_adam_naufal.dataClass.ItemMenu
import com.example.challenge_4_ilyasa_adam_naufal.R
import com.example.challenge_4_ilyasa_adam_naufal.viewModel.DetailViewModel
import com.example.challenge_4_ilyasa_adam_naufal.viewmodelfactory.ViewModelFactory
import com.example.challenge_4_ilyasa_adam_naufal.databinding.FragmentDetailItemBinding

class DetailItemFragment: Fragment() {
	private var _binding: FragmentDetailItemBinding? = null
	private val binding get() = _binding!!

	private val locationUri: String = "https://maps.app.goo.gl/SiFzf18kByYndQqg7"

	private lateinit var viewModel: DetailViewModel

	private var item: ItemMenu? = null

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentDetailItemBinding.inflate(inflater, container, false)
		setUpCartViewModel()

		viewModel.totalPrice.observe(viewLifecycleOwner) {
			binding.btnadd2.text = "Tambah Ke Keranjang -Rp.$it "

		}

		setData()
		addToCart()
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		try  {
			btnBack()
			wViewModel()

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

	private fun btnBack() {
		binding.btnback.setOnClickListener {
			requireActivity().onBackPressed()
		}
	}

	private fun addToCart() {
		binding.btnadd2.setOnClickListener {
			viewModel.addToCart()

			findNavController().navigate(R.id.action_detailItem_to_cartFragment)
		}
	}

	private fun setUpCartViewModel() {
		val viewModelFactory = ViewModelFactory(requireActivity().application)
		viewModel = ViewModelProvider(this, viewModelFactory)[DetailViewModel::class.java]
	}

	private fun setData() {
		@Suppress("DEPRECATION")
		item = arguments?.getParcelable("item")

		item?.let {
			binding.imageadd.setImageResource(it.images)
			binding.nameadd.text = item?.name
			binding.priceadd.text = item?.price.toString()

			viewModel.initSelectedItem(it)
		}
	}

	private fun wViewModel() {
		val observer = Observer<Int> {
			binding.quantity.text = it.toString()
		}

		viewModel.counter.observe(viewLifecycleOwner, observer)

		binding.btnadd1.setOnClickListener {
			viewModel.increment()
		}

		binding.reduce.setOnClickListener {
			viewModel.decrement()
		}
	}

	override fun onDestroy() {
		super.onDestroy()
		_binding = null
	}
}
package com.example.challenge_4_ilyasa_adam_naufal.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge_4_ilyasa_adam_naufal.Adapter.CartAdapter
import com.example.challenge_4_ilyasa_adam_naufal.DataClass.ItemMenu
import com.example.challenge_4_ilyasa_adam_naufal.ViewModel.CartViewModel
import com.example.challenge_4_ilyasa_adam_naufal.ViewModel.ViewModelFactory
import com.example.challenge_4_ilyasa_adam_naufal.databinding.FragmentCartBinding


class CartFragment : Fragment() {
	private lateinit var binding: FragmentCartBinding
	private lateinit var cartViewModel: CartViewModel
	private lateinit var cartAdapter: CartAdapter
	private var item: ItemMenu? = null

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		binding =FragmentCartBinding.inflate(inflater, container, false)
		setUpCartViewModel()

		cartAdapter = CartAdapter(cartViewModel)
		binding.rvCart.setHasFixedSize(true)
		binding.rvCart.layoutManager = LinearLayoutManager(requireContext())
		binding.rvCart.adapter = cartAdapter

		cartViewModel.allCartItems.observe(viewLifecycleOwner) {
			cartAdapter.setData(it)

			var total_price = 0
			it.forEach{item ->
					total_price += item.totalPrice
				}
				val priceText = "Rp. $total_price"
				binding.resultTotalPrice.text = priceText
			}

		return binding.root
	}

	private fun setUpCartViewModel() {
		val viewModelFactory = ViewModelFactory(requireActivity().application)
		cartViewModel = ViewModelProvider(this, viewModelFactory)[CartViewModel::class.java]
	}

}
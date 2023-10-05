package com.example.challenge_4_ilyasa_adam_naufal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge_4_ilyasa_adam_naufal.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

	/*private lateinit var sharedPreferences : SharedPreferences
	private val sharedPrefName = "sharedpreflayout"*/

	private lateinit var homeViewModel: HomeViewModel
	private var _binding: FragmentHomeBinding? = null
	private val binding get() = _binding!!
	private var isGrid: Boolean = true
	private var layoutType = true

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		// Inflate the layout for this fragment
		_binding = FragmentHomeBinding.inflate(inflater, container, false)
		homeViewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]

		homeViewModel.isListView.observe(viewLifecycleOwner) {
			isGrid = it
			setupChangeLayout()
			setupRecyclerView(it)
			pickItem()
		}
		catView()
		setupRecyclerView(isGrid)
		return binding.root

	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		catView()

		pickItem()
	}

	// List Kategori
	private val listKategori = arrayListOf(
		Category("Drink", R.drawable.foodiesfeed_com_strawberry_milk_splash),
		Category("Fast Food", R.drawable.foodiesfeed_com_fried_chicken_commercial),
		Category("Western", R.drawable.foodiesfeed_com_french_fries_with_ketchup_top_view),
		Category("Europe", R.drawable.foodiesfeed_com_pizza_ready_for_baking),
		Category("Asian", R.drawable.foodiesfeed_com_crispy_spicy_chicken_wings)
	)

	// List Menu
	private val listMenu = arrayListOf(
		ItemMenu("Grilled Chicken", "Rp 75.000", R.drawable.foodiesfeed_com_grilled_whole_chicken),
		ItemMenu("Cheese Burger", "Rp 45.000", R.drawable.foodiesfeed_com_cheeseburger),
		ItemMenu("Sushi", "Rp 20.000", R.drawable.foodiesfeed_com_salmon_sushi_maki),
		ItemMenu("Spaghetti", "Rp 35.000", R.drawable.foodiesfeed_com_cherry_tomatoes_spaghetti),
		ItemMenu("Dimsum", "Rp 40.000", R.drawable.foodiesfeed_com_xiaolongbao_dumplings),
		ItemMenu("Chicken Satay", "Rp 30.000", R.drawable.foodiesfeed_com_grilling_chicken_satay)
	)

	private fun setupRecyclerView(isGrid: Boolean) {

		if (isGrid) {
			binding.recycleviewVertical.layoutManager = LinearLayoutManager(requireActivity())
			binding.recycleviewVertical.adapter = MenuAdapter(listMenu, gridType = true)
			binding.gridlist.setImageDrawable(
				ContextCompat.getDrawable(
					requireActivity(), R.drawable.baseline_grid_view_24
				)
			)
		} else {
			binding.recycleviewVertical.layoutManager = GridLayoutManager(requireActivity(), 2)
			binding.recycleviewVertical.adapter = MenuAdapter(listMenu, gridType = false)
			binding.gridlist.setImageDrawable(
				ContextCompat.getDrawable(
					requireActivity(), R.drawable.baseline_view_list_24
				)
			)
		}

	}

	private fun setupChangeLayout() {

		val currentLayout = homeViewModel.isListView.value

		binding.gridlist.setOnClickListener {
			isGrid=!isGrid

			setupRecyclerView(isGrid)
			val newLayoutValue = !currentLayout!!
			setupRecyclerView(newLayoutValue)

			homeViewModel.isListView.value = newLayoutValue
			pickItem()
		}


	}


	// RecycleViewCategory
	private fun catView() {
		binding.recycleviewHorizontal.layoutManager =
			LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
		binding.recycleviewHorizontal.adapter = CategoryAdapter(listKategori)
	}

	private fun pickItem() {
		if(isGrid){

			layoutType = true
		} else {

			layoutType = false
		}
		val adapter = MenuAdapter(listMenu, gridType = layoutType, onItemClick = { selectedItem ->

			val actionToDetailFragment =
				HomeFragmentDirections.actionHomeFragmentToDetailItem()
			actionToDetailFragment.nameadd = selectedItem.name
			actionToDetailFragment.priceadd = selectedItem.price
			actionToDetailFragment.imageadd = selectedItem.images

			findNavController().navigate(actionToDetailFragment)
		})

		binding.recycleviewVertical.adapter = adapter
	}

	private fun saveData() {

	}

}
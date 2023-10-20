package com.example.challenge_4_ilyasa_adam_naufal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.challenge_4_ilyasa_adam_naufal.dataClass.DataCategory
import com.example.challenge_4_ilyasa_adam_naufal.databinding.CategoryItemMenuBinding

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

	private val diffCallBack = object : DiffUtil.ItemCallback<DataCategory>() {
		override fun areItemsTheSame(
			oldItem: DataCategory,
			newItem: DataCategory
		): Boolean = oldItem.id == newItem.id

		override fun areContentsTheSame(
			oldItem: DataCategory,
			newItem: DataCategory
		): Boolean = oldItem == newItem
	}

	private val differ = AsyncListDiffer(this, diffCallBack)

	fun submitCategoryMenuResponse(value: List<DataCategory>) = differ.submitList(value)

	// Membuat Holder
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
		val inflater = LayoutInflater.from(parent.context)
		return ViewHolder(CategoryItemMenuBinding.inflate(inflater, parent, false))
	}

	override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
		val data = differ.currentList[position]
		data.let { holder.bind(data) }

	}

	override fun getItemCount(): Int {
		return differ.currentList.size
	}

	inner class ViewHolder(
		private var binding:
		CategoryItemMenuBinding
	) : RecyclerView.ViewHolder(binding.root) {
		fun bind(dataCategory: DataCategory) {
			binding.apply {
				titleCat.text = dataCategory.nama
				Glide.with(this.categoryImageMenu)
					.load(dataCategory.imageUrl)
					.fitCenter()
					.into(binding.categoryImageMenu)
			}
		}
	}
}
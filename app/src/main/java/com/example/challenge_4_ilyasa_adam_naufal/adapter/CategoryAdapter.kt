package com.example.challenge_4_ilyasa_adam_naufal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.challenge_4_ilyasa_adam_naufal.R
import com.example.challenge_4_ilyasa_adam_naufal.dataClass.DataCategory
import com.example.challenge_4_ilyasa_adam_naufal.databinding.CategoryItemMenuBinding

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

	// Membuat Holder
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.category_item_menu, parent, false)
		return ViewHolder(view)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val (name, image) = listkategori[position]
		holder.name.text = name
		holder.image.setImageResource(image)

	}

	override fun getItemCount(): Int {
		return listkategori.size
	}

	inner class ViewHolder(
		private var binding:
		CategoryItemMenuBinding
	) : RecyclerView.ViewHolder(binding.root) {
		fun bind(dataCategory: DataCategory) {
			binding.apply {
				titleCat.text = data.nama
				Glide.with(this.categoryImageMenu)
					.load(data.imageUrl)
					.fitCenter()
					.into(binding.categoryImageMenu)
			}
		}
	}
}
package com.example.horizontalscrollapp_exm8.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.horizontalscrollapp_exm8.databinding.ScrollItemBinding
import com.example.horizontalscrollapp_exm8.domain.model.Item

class ItemsPagerAdapter : ListAdapter<Item, ItemsPagerAdapter.ItemsViewHolder>(ItemsDiffUtil) {

    object ItemsDiffUtil : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemsViewHolder(
        ScrollItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind()
    }

    inner class ItemsViewHolder(private val binding: ScrollItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val item = currentList[adapterPosition]

        }
    }
}
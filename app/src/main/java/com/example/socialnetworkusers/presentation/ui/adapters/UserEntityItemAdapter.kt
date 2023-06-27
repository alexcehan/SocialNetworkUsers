package com.example.socialnetworkusers.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.socialnetworkusers.data.pojos.UserEntityFromApiResponse
import com.example.socialnetworkusers.databinding.UserItemBinding

class UserEntityItemAdapter(val clickListener: (userEntityFromApiResponse: UserEntityFromApiResponse) -> Unit):ListAdapter<UserEntityFromApiResponse, UserEntityItemAdapter.UserEntityItemViewHolder>(UserEntityDiffItemCallBack())  {

    override fun onBindViewHolder(holder: UserEntityItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserEntityItemViewHolder = UserEntityItemViewHolder.inflateFrom(parent)

    class UserEntityItemViewHolder(val binding: UserItemBinding): RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun inflateFrom(parent: ViewGroup): UserEntityItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = UserItemBinding.inflate(layoutInflater, parent, false)

                return UserEntityItemViewHolder(binding)
            }
        }

        fun bind(item: UserEntityFromApiResponse, clickListener: (userEntityFromApiResponse: UserEntityFromApiResponse) -> Unit) {
            binding.user = item
            binding.root.setOnClickListener { clickListener(item) }
        }
    }
}
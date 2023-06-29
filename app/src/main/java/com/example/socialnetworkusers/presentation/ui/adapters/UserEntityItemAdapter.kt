package com.example.socialnetworkusers.presentation.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.socialnetworkusers.data.pojos.UserEntityFromApiResponse
import com.example.socialnetworkusers.data.repository.MemoryCache
import com.example.socialnetworkusers.databinding.UserItemBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception


class UserEntityItemAdapter(private val context: Context,private val clickListener: (userEntityFromApiResponse: UserEntityFromApiResponse) -> Unit):ListAdapter<UserEntityFromApiResponse, UserEntityItemAdapter.UserEntityItemViewHolder>(UserEntityDiffItemCallBack())  {


    override fun onBindViewHolder(holder: UserEntityItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(context, item, clickListener)


//        Picasso.get().apply {
//            // Clear disk cache
//            val cacheField = this@apply.javaClass.getDeclaredField("cache")
//            cacheField.isAccessible = true
//            val cache = cacheField.get(this@apply) as Cache
//            cache.clear()
//
//            // Clear memory cache
//
//        }
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

        fun bind(context: Context, item: UserEntityFromApiResponse, clickListener: (userEntityFromApiResponse: UserEntityFromApiResponse) -> Unit) {
            binding.user = item
            binding.root.setOnClickListener { clickListener(item) }

            if(item.id % 2 == 0) {
                binding.userImage.text = getInitialsOfTheName(item.name)

            } else {
                val imageView = ImageView(context)


                if (checkIfFIleExistsInMemoryCache(item.id)) {
                    binding.userImage.background = MemoryCache.get("image_${item.id}")!!

                } else {
                    Picasso.get()
                        .load("https://picsum.photos/200/200?id=${item.id}")
                        .into(imageView, object : Callback {
                            override fun onSuccess() {
                                MemoryCache.put("image_${item.id}", imageView.drawable)
                                binding.userImage.background = imageView.drawable
                            }

                            override fun onError(e: Exception?) {
                                binding.userImage.text = getInitialsOfTheName(item.name)
                            }
                        })

                }
            }
        }

        private fun getInitialsOfTheName(name: String): String {
            val firstNameInitial = name.split(" ")[0][0].uppercase()
            val lastNameInitial: String = name.split(" ")[1][0].uppercase()

            return "${firstNameInitial}${lastNameInitial}"
        }

        private fun checkIfFIleExistsInMemoryCache(userId: Int): Boolean {
            return MemoryCache.get("image_${userId}") != null
        }












    }
}
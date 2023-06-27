package com.example.socialnetworkusers.presentation.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.socialnetworkusers.data.pojos.UserEntityFromApiResponse

class UserEntityDiffItemCallBack : DiffUtil.ItemCallback<UserEntityFromApiResponse>() {

    override fun areItemsTheSame(
        oldItem: UserEntityFromApiResponse,
        newItem: UserEntityFromApiResponse
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: UserEntityFromApiResponse,
        newItem: UserEntityFromApiResponse
    ): Boolean {
        return oldItem == newItem
    }
}
package com.example.socialnetworkusers.data.pojos

data class UserEntityFromApiResponse(
    val email: String,
    val gender: String,
    val id: Int,
    val name: String,
    val status: String
): java.io.Serializable
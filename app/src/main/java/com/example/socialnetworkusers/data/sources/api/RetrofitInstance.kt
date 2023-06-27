package com.example.socialnetworkusers.data.sources.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: UsersApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://gorest.co.in")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UsersApi::class.java)
    }
}
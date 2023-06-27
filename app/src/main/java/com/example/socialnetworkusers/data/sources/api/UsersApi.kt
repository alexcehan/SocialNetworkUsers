package com.example.socialnetworkusers.data.sources.api

import com.example.socialnetworkusers.data.pojos.GorestApiResponsePostsList
import com.example.socialnetworkusers.data.pojos.GorestApiResponseUsersList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersApi {

    @GET("/public/v2/users")
    suspend fun getAllUsersFromApi(): Response<GorestApiResponseUsersList>


    @GET("/public/v2/users/{userId}/posts")
    suspend fun getAllPostsByUserId(@Path("userId")userdId: Int): Response<GorestApiResponsePostsList>
}
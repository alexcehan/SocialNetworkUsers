package com.example.socialnetworkusers.domain.repository

import com.example.socialnetworkusers.data.pojos.GorestApiResponsePostsList
import com.example.socialnetworkusers.data.pojos.GorestApiResponseUsersList
import kotlinx.coroutines.flow.Flow

interface ApiRepository {

    suspend fun fetchAllUsersListFromApi(): Flow<GorestApiResponseUsersList>

    suspend fun fetchAllPostsByUserId(userId: Int): Flow<GorestApiResponsePostsList>
}
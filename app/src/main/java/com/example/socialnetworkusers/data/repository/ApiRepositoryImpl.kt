package com.example.socialnetworkusers.data.repository

import com.example.socialnetworkusers.data.pojos.GorestApiResponsePostsList
import com.example.socialnetworkusers.data.pojos.GorestApiResponseUsersList
import com.example.socialnetworkusers.data.sources.api.UsersApi
import com.example.socialnetworkusers.domain.repository.ApiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ApiRepositoryImpl (private val usersApi: UsersApi) : ApiRepository{

    override suspend fun fetchAllUsersListFromApi(): Flow<GorestApiResponseUsersList> {
        return flow {
            val response = usersApi.getAllUsersFromApi()

            if(response.isSuccessful) {
                val data = response.body()
                emit(data!!)
            }
        }
    }

    override suspend fun fetchAllPostsByUserId(userId: Int): Flow<GorestApiResponsePostsList> {
        return flow {
            val response = usersApi.getAllPostsByUserId(userId)

            if (response.isSuccessful) {
                val data = response.body()
                emit(data!!)
            }
        }
    }
}
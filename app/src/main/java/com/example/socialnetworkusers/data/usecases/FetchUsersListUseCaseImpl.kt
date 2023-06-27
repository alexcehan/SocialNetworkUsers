package com.example.socialnetworkusers.data.usecases

import com.example.socialnetworkusers.data.pojos.GorestApiResponseUsersList
import com.example.socialnetworkusers.domain.repository.ApiRepository
import kotlinx.coroutines.flow.Flow

class FetchUsersListUseCaseImpl(private val repository: ApiRepository): FetchUsersListUseCase {

    override suspend fun invoke(): Flow<GorestApiResponseUsersList> {
        return repository.fetchAllUsersListFromApi()
    }
}
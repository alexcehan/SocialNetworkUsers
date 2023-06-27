package com.example.socialnetworkusers.data.usecases

import com.example.socialnetworkusers.data.pojos.GorestApiResponsePostsList
import com.example.socialnetworkusers.domain.repository.ApiRepository
import kotlinx.coroutines.flow.Flow

class FetchPostsListByUserIdUseCaseImpl(private val repository: ApiRepository) :
    FetchPostsListByUserIdUseCase {

    override suspend fun invoke(userId: Int): Flow<GorestApiResponsePostsList> {
        return repository.fetchAllPostsByUserId(userId)
    }
}
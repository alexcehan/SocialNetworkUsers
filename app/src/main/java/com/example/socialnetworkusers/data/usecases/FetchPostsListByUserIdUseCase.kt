package com.example.socialnetworkusers.data.usecases

import com.example.socialnetworkusers.data.pojos.GorestApiResponsePostsList
import kotlinx.coroutines.flow.Flow


interface FetchPostsListByUserIdUseCase {

    suspend operator fun invoke(userId: Int): Flow<GorestApiResponsePostsList>
}
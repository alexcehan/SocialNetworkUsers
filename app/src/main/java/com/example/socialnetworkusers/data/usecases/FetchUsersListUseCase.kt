package com.example.socialnetworkusers.data.usecases

import com.example.socialnetworkusers.data.pojos.GorestApiResponseUsersList
import kotlinx.coroutines.flow.Flow

interface FetchUsersListUseCase {

    suspend operator fun invoke(): Flow<GorestApiResponseUsersList>
}
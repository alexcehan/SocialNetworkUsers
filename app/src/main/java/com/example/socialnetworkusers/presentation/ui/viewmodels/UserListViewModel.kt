package com.example.socialnetworkusers.presentation.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialnetworkusers.data.pojos.UserEntityFromApiResponse
import com.example.socialnetworkusers.data.repository.ApiRepositoryImpl
import com.example.socialnetworkusers.data.sources.api.RetrofitInstance
import com.example.socialnetworkusers.data.usecases.FetchUsersListUseCaseImpl
import kotlinx.coroutines.launch

class UserListViewModel: ViewModel() {

    private val api = RetrofitInstance.api
    private val repository = ApiRepositoryImpl(api)
    private val fetchUsersListUseCase = FetchUsersListUseCaseImpl(repository)

    private val _navigateToUserDetails = MutableLiveData<UserEntityFromApiResponse?>()
    val navigateToUserDetails = _navigateToUserDetails

    private var _usersList = MutableLiveData<List<UserEntityFromApiResponse>>()
    val usersList = _usersList


    fun getUserListFromApi() {
        viewModelScope.launch {
            fetchUsersListUseCase.invoke().collect {
                result ->
                _usersList.value = result.filter { userEntityFromApiResponse -> userEntityFromApiResponse.status == "active" }
            }


        }
    }

    fun onUserClicked(userEntityFromApiResponse: UserEntityFromApiResponse) {
        _navigateToUserDetails.value = userEntityFromApiResponse
    }

    fun onUserNavigated() {
        _navigateToUserDetails.value = null
    }







}
package com.example.socialnetworkusers.presentation.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialnetworkusers.data.pojos.UserEntityFromApiResponse
import com.example.socialnetworkusers.data.repository.ApiRepositoryImpl
import com.example.socialnetworkusers.data.sources.api.RetrofitInstance
import com.example.socialnetworkusers.data.usecases.FetchPostsListByUserIdUseCaseImpl
import kotlinx.coroutines.launch

class UserPostsViewModel() : ViewModel() {

    lateinit var userEntity: UserEntityFromApiResponse

    val api = RetrofitInstance.api
    private val repository = ApiRepositoryImpl(api)
    private val fetchPostsListByUserIdUseCase = FetchPostsListByUserIdUseCaseImpl(repository)

    private var _postTitle = MutableLiveData<String>()
    private var _postBody = MutableLiveData<String>()

    val postTitle = _postTitle
    val postBody = _postBody

    fun getUserFirstPost() {
        viewModelScope.launch {
            fetchPostsListByUserIdUseCase.invoke(userEntity.id).collect{

                result ->
                if (result.isEmpty()) {
                    _postBody.value = ""
                    _postTitle.value = ""
                } else {
                    _postTitle.value = result.get(0).title
                    _postBody.value = result.get(0).body
                }


            }
        }

    }




}
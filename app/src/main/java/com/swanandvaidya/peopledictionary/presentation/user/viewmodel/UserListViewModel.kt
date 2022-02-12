package com.swanandvaidya.peopledictionary.presentation.user.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.swanandvaidya.peopledictionary.data.User
import com.swanandvaidya.peopledictionary.domain.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    var userList: LiveData<List<User>> = repository.getUserList()

}
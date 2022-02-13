package com.swanandvaidya.peopledictionary.viewmodels.userlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.swanandvaidya.peopledictionary.data.User
import com.swanandvaidya.peopledictionary.domain.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(repository: UserRepository) : ViewModel() {

    var userList: LiveData<List<User>> = repository.getUserList()
}
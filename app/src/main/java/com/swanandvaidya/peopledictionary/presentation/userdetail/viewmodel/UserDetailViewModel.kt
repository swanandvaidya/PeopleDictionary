package com.swanandvaidya.peopledictionary.presentation.userdetail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swanandvaidya.peopledictionary.data.User
import com.swanandvaidya.peopledictionary.domain.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    private var _isValidUser = MutableLiveData<Boolean>()
    val isValidUser = _isValidUser

    fun saveUser(userName: String, mobileNumber: String) {
        val user = User(userName, mobileNumber)
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveUser(user)
        }
    }

    fun validateUser(userName: String, mobileNumber: String) {
        _isValidUser.value = userName.isNotEmpty() && mobileNumber.isNotEmpty()
    }
}
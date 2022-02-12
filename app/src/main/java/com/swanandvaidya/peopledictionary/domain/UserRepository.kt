package com.swanandvaidya.peopledictionary.domain

import com.swanandvaidya.peopledictionary.data.User
import com.swanandvaidya.peopledictionary.data.dao.UserDao
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {

    fun getUserList() = userDao.getAllUsers()

    suspend fun saveUser(user: User) {
        userDao.saveUser(user)
    }
}
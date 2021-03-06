package com.swanandvaidya.peopledictionary.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.swanandvaidya.peopledictionary.data.User

@Dao
interface UserDao {

    @Query("SELECT * FROM UserTable")
    fun getAllUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: User)
}
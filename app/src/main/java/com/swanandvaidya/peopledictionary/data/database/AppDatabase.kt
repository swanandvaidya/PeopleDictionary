package com.swanandvaidya.peopledictionary.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.swanandvaidya.peopledictionary.data.User
import com.swanandvaidya.peopledictionary.data.dao.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao
}
package com.swanandvaidya.peopledictionary.di

import android.content.Context
import androidx.room.Room
import com.swanandvaidya.peopledictionary.data.database.AppDatabase
import com.swanandvaidya.peopledictionary.data.dao.UserDao
import com.swanandvaidya.peopledictionary.util.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Provides database instance
    @Singleton
    @Provides
    fun providesDbInstance(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppConstants.DB_NAME
        ).build()

    @Singleton
    @Provides
    fun getUserDao(db: AppDatabase): UserDao = db.userDao()
}
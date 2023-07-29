package com.example.hiltproject.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun getFakerDb(@ApplicationContext context: Context) : FakerDb{
        return Room.databaseBuilder(context , FakerDb::class.java , "FakerDB").build()
    }

}
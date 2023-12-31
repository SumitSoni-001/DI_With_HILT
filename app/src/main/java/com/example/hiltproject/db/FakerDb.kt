package com.example.hiltproject.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hiltproject.models.Products

@Database(entities = [Products::class] , version = 1)
abstract class FakerDb : RoomDatabase() {

    abstract fun getFakerDao() : FakerDao

}
package com.example.hiltproject.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.hiltproject.models.Products

@Dao
interface FakerDao {

    @Insert(onConflict = REPLACE)
    suspend fun addProducts(products : List<Products>)

    @Query("SELECT * FROM Products")
    fun getProducts() : List<Products>

}
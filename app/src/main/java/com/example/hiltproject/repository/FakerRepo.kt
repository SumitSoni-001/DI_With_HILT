package com.example.hiltproject.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hiltproject.db.FakerDb
import com.example.hiltproject.models.Products
import com.example.hiltproject.retrofit.FakerApi
import javax.inject.Inject

class FakerRepo @Inject constructor(private val fakerApi: FakerApi , private val fakerDb: FakerDb) {

    private var productsLiveData = MutableLiveData<List<Products>>()
    val productsData : LiveData<List<Products>>
    get() = productsLiveData

    suspend fun getProducts() {
        val result = fakerApi.getProducts()
        if (result.isSuccessful && result.body() != null){
            fakerDb.getFakerDao().addProducts(result.body()!!)
            productsLiveData.postValue(result.body())
        }
    }

}
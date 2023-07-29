package com.example.hiltproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltproject.models.Products
import com.example.hiltproject.repository.FakerRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
class FakerViewModel(private val fakerRepo: FakerRepo) : ViewModel() {
    val productsData : LiveData<List<Products>>
    get() = fakerRepo.productsData

    init {
        viewModelScope.launch {
            fakerRepo.getProducts()
        }
    }

}
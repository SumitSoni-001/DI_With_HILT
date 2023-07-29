package com.example.hiltproject.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hiltproject.repository.FakerRepo
import javax.inject.Inject

class FakerViewModelFactory @Inject constructor(private val fakerRepo: FakerRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FakerViewModel(fakerRepo) as T
    }
}
package com.example.dagger2mvvmroomdb.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dagger2mvvmroomdb.repository.ProductRepository
import javax.inject.Inject

class MainViewModelFactory  @Inject constructor(private val map:Map<Class<*>, @JvmSuppressWildcards ViewModel>):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return map[modelClass] as T
    }
}
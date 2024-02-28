package com.example.dagger2mvvmroomdb.repository

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dagger2mvvmroomdb.db.FakerDB
import com.example.dagger2mvvmroomdb.models.Product
import com.example.dagger2mvvmroomdb.retrofit.FakerAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerAPI: FakerAPI,private val fakerDB: FakerDB) {
    private val _products = MutableLiveData<List<Product>>()
    val products : LiveData<List<Product>>
    get() = _products

    @SuppressLint("SuspiciousIndentation")
    suspend fun getProducts(){
    val result = fakerAPI.getProducts()
        if(result.isSuccessful && result.body() != null){
            fakerDB.getFakerDAO().addProducts(result.body()!!)
            _products.postValue(result.body())
        }
    }
}
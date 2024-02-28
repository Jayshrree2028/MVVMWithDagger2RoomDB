package com.example.dagger2mvvmroomdb.retrofit

import com.example.dagger2mvvmroomdb.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {
    @GET("products")
    suspend fun getProducts():Response<List<Product>>
}
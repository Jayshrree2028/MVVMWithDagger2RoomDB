package com.example.dagger2mvvmroomdb.di

import com.example.dagger2mvvmroomdb.retrofit.FakerAPI
import com.example.dagger2mvvmroomdb.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun provideFakerAPI(retrofit: Retrofit): FakerAPI{
        // What Retrofit will do is look at the FakeAPI interface and provide the body of all the methods it finds.
        return retrofit.create(FakerAPI::class.java)
    }
}
package com.example.dagger2mvvmroomdb.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dagger2mvvmroomdb.models.Product

@Database(entities = [Product::class], version = 1)
abstract class FakerDB : RoomDatabase(){
    abstract fun getFakerDAO() : FakerDAO
}
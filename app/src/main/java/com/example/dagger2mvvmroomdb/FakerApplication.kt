package com.example.dagger2mvvmroomdb

import android.app.Application
import com.example.dagger2mvvmroomdb.di.ApplicationComponent
import com.example.dagger2mvvmroomdb.di.DaggerApplicationComponent
import dagger.Component

class FakerApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}
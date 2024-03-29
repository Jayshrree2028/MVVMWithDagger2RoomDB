package com.example.dagger2mvvmroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dagger2mvvmroomdb.db.FakerDB
import com.example.dagger2mvvmroomdb.viewmodels.MainViewModel
import com.example.dagger2mvvmroomdb.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

//    @Inject
//    lateinit var fakerDB1: FakerDB

//    @Inject
//    lateinit var fakerDB2: FakerDB

    @Inject
    lateinit var mainViewModelsFactory: MainViewModelFactory
    private val products: TextView
    get() = findViewById(R.id.products)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //We have passing MainActivity to application Components
        ( application as FakerApplication).applicationComponent.inject(this)
        mainViewModel = ViewModelProvider(this,mainViewModelsFactory).get(MainViewModel::class.java)
        mainViewModel.productsLiveData.observe(this, Observer {
            products.text= it.joinToString { x-> x.title + "\n\n" }
        })
    }
}
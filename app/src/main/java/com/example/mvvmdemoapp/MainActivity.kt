package com.example.mvvmdemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemoapp.api.ApiClient
import com.example.mvvmdemoapp.api.ApiInterface
import com.example.mvvmdemoapp.repository.QuoteRepository
import com.example.mvvmdemoapp.viewmodels.MainViewFactory
import com.example.mvvmdemoapp.viewmodels.MainViewModel
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    lateinit var maniViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val qouteService = ApiClient.getInstance().create(ApiInterface::class.java)
        val repository = QuoteRepository(qouteService)
        maniViewModel = ViewModelProvider(this,MainViewFactory(repository))[MainViewModel::class.java]

        maniViewModel.qoutes.observe(this) {
            Log.d("KAMAL", it.results.toString())
        }
    }
}
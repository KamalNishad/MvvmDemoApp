package com.example.mvvmdemoapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmdemoapp.api.ApiInterface
import com.example.mvvmdemoapp.models.QuoteList

class QuoteRepository(private val apiInterface: ApiInterface) {

    private val qoutesLiveData = MutableLiveData<QuoteList>()

    val qoutes:LiveData<QuoteList>
    get() = qoutesLiveData

    suspend fun getQuote(page:Int){
        val result = apiInterface.getQoutes(page)
        if (result?.body()!=null){
            qoutesLiveData.postValue(result.body())
        }
    }
}
package com.example.mvvmdemoapp.api

import com.example.mvvmdemoapp.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/quotes")
    suspend fun getQoutes(@Query("page") page:Int) : Response<QuoteList>
}
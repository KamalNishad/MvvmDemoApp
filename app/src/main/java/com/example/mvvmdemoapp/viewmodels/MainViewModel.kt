package com.example.mvvmdemoapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmdemoapp.models.QuoteList
import com.example.mvvmdemoapp.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val repository: QuoteRepository) : ViewModel() {

    init{
        viewModelScope.launch(Dispatchers.IO){
            repository.getQuote(1)
        }
    }

    val qoutes : LiveData<QuoteList>
    get() = repository.qoutes
}
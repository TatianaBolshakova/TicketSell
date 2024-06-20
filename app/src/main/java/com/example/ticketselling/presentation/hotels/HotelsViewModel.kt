package com.example.ticketselling.presentation.hotels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HotelsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Страница в разработке"
    }
    val text: LiveData<String> = _text
}
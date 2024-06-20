package com.example.ticketselling.presentation.briefly

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BrieflyViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Страница в разработке"
    }
    val text: LiveData<String> = _text
}
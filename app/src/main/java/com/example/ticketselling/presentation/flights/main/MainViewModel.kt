package com.example.ticketselling.presentation.flights.main

import android.util.Log

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ItemsTips
import com.example.domain.models.ItemsTickets
import com.example.domain.models.ItemsTicketsOffers
import com.example.domain.usecase.LoadOffersUseCase
import com.example.domain.usecase.LoadTicketsOffersUseCase
import com.example.domain.usecase.LoadTicketsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val loadOffersUseCase: LoadOffersUseCase,

    ) : ViewModel() {

    private val _offers = MutableStateFlow<List<ItemsTips>>(emptyList())
    val offers = _offers.asStateFlow()

    fun loadOffers() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                loadOffersUseCase.getOffers()
            }.fold(
                onSuccess = { _offers.value = it },
                onFailure = { Log.d("MainViewModel", it.message ?: "") }
            )
        }
    }
}
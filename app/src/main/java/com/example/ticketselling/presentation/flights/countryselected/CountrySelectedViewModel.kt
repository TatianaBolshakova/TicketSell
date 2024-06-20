package com.example.ticketselling.presentation.flights.countryselected


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ItemsTicketsOffers
import com.example.domain.usecase.LoadTicketsOffersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class CountrySelectedViewModel (
    private val loadTicketsOffersUseCase: LoadTicketsOffersUseCase,
) : ViewModel() {

    private val _ticketsOffers = MutableStateFlow<List<ItemsTicketsOffers>>(emptyList())
    val ticketsOffers = _ticketsOffers.asStateFlow()

    fun loadTicketsOffers(){
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                loadTicketsOffersUseCase.getTicketsOffers()
            }.fold(
                onSuccess = {_ticketsOffers.value = it},
                onFailure = { Log.d("CountrySelectedViewModel", it.message ?: "")}
            )
        }
    }
}
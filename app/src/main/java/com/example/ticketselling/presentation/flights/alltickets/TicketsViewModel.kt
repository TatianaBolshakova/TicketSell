package com.example.ticketselling.presentation.flights.alltickets


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ItemsTickets
import com.example.domain.usecase.LoadTicketsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class TicketsViewModel(
    private val loadTicketsUseCase: LoadTicketsUseCase
) : ViewModel() {

    private val _tickets = MutableStateFlow<List<ItemsTickets>>(emptyList())
    val tickets = _tickets.asStateFlow()

    fun loadTickets() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                loadTicketsUseCase.getTickets()
            }.fold(
                onSuccess = { _tickets.value = it },
                onFailure = { Log.d("TicketsViewModel", it.message ?: "") }
            )
        }
    }
}
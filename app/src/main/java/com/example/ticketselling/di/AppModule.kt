package com.example.ticketselling.di

import com.example.ticketselling.presentation.flights.alltickets.TicketsViewModel
import com.example.ticketselling.presentation.flights.countryselected.CountrySelectedViewModel
import com.example.ticketselling.presentation.flights.main.MainViewModel
import com.example.ticketselling.presentation.flights.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel(
            loadOffersUseCase = get() ,
        )
    }
    viewModel<SearchViewModel> {
        SearchViewModel()
    }
    viewModel<CountrySelectedViewModel> {
        CountrySelectedViewModel(
            loadTicketsOffersUseCase = get(),
        )
    }
    viewModel<TicketsViewModel> {
        TicketsViewModel(
            loadTicketsUseCase = get()
        )
    }
}
package com.example.ticketselling.di

import com.example.domain.usecase.LoadOffersUseCase
import com.example.domain.usecase.LoadTicketsOffersUseCase
import com.example.domain.usecase.LoadTicketsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<LoadOffersUseCase> {
        LoadOffersUseCase(repository = get())
    }
    factory<LoadTicketsUseCase> {
        LoadTicketsUseCase(repository = get())
    }
    factory<LoadTicketsOffersUseCase> {
        LoadTicketsOffersUseCase(repository = get())
    }
}
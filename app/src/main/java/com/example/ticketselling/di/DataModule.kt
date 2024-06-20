package com.example.ticketselling.di

import com.example.data.repository.RepositoryImpl
import com.example.domain.repository.Repository
import org.koin.dsl.module

val dataModule = module {
    single<Repository> {
        RepositoryImpl()
    }
}
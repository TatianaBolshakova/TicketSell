package com.example.domain.usecase


import com.example.domain.models.ItemsTicketsOffers
import com.example.domain.repository.Repository

class LoadTicketsOffersUseCase(
    private val repository: Repository
) {
    suspend fun getTicketsOffers(): List<ItemsTicketsOffers> = repository.getTicketsOffers()
}
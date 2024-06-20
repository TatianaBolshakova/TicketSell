package com.example.domain.usecase

import com.example.domain.models.ItemsTips
import com.example.domain.repository.Repository

class LoadOffersUseCase(
    private val repository: Repository
) {
    suspend fun getOffers(): List<ItemsTips> = repository.getOffers()
}
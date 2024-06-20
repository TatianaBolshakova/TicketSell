package com.example.domain.usecase

import com.example.domain.models.ItemsTickets
import com.example.domain.repository.Repository

class LoadTicketsUseCase(
    private val repository: Repository
) {
    suspend fun getTickets(): List<ItemsTickets> {

println("{{{{{{{{{{{{{{{{{{{{{{{${repository.getTickets()}")

        return repository.getTickets()
    }
}

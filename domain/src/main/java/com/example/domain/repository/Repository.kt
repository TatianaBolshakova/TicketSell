package com.example.domain.repository

import com.example.domain.models.ItemsTips
import com.example.domain.models.ItemsTickets
import com.example.domain.models.ItemsTicketsOffers

interface Repository {

    suspend fun getOffers(): List<ItemsTips>

    suspend fun getTicketsOffers(): List<ItemsTicketsOffers>

    suspend fun getTickets():  List <ItemsTickets>
}
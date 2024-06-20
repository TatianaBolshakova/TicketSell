package com.example.data.repository

import com.example.data.api.Api
import com.example.data.api.RetrofitClient
import com.example.data.models.mapper.mapItemsOffersDtoToDomain
import com.example.data.models.mapper.mapItemsTicketsDtoToDomain
import com.example.data.models.mapper.mapTicketsOffersToDomain
import com.example.domain.models.ItemsTips
import com.example.domain.models.ItemsTickets
import com.example.domain.models.ItemsTicketsOffers
import com.example.domain.repository.Repository


class RepositoryImpl : Repository {
    override suspend fun getOffers(): List<ItemsTips> {
        return RetrofitClient
            .getInstance()
            .create(Api::class.java)
            .getOffers()
            .offers.mapItemsOffersDtoToDomain()
    }

    override suspend fun getTicketsOffers(): List<ItemsTicketsOffers> {
        return RetrofitClient
            .getInstance()
            .create(Api::class.java)
            .getTicketsOffers()
            .ticketsOffers.mapTicketsOffersToDomain()
    }

    override suspend fun getTickets(): List<ItemsTickets> {

        return RetrofitClient
            .getInstance()
            .create(Api::class.java)
            .getTickets()
            .tickets.mapItemsTicketsDtoToDomain()
    }
}
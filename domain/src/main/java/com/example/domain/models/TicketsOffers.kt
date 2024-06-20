package com.example.domain.models

data class TicketsOffers(
    val ticketsOffers: List<Any>
)

data class ItemsTicketsOffers(
    val id: Int,
    val title: String,
    val timeRange: List<String>,
    val price: ValuePrice
)


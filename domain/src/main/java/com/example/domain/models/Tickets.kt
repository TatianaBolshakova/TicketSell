package com.example.domain.models


data class Tickets(
    val tickets: List<Any>
)

data class Departure(
    val town: String,
    val date: String,
    val airport: String
)

data class Arrival(
    val town: String,
    val date: String,
    val airport: String
)

data class Luggage(
    val hasHandLuggage: Boolean?,
    val price: ValuePrice?
)

data class HandLuggage(
    val hasHandLuggage: Boolean?,
    val size: String?
)

data class ItemsTickets(
    val id: Int?,
    val badge: String?,
    val priceDomain: ValuePrice?,
    val providerName: String?,
    val company: String?,
    val departure: Departure?,
    val arrival: Arrival?,
    val hasTransfer: Boolean?,
    val hasVisaTransfer: Boolean?,
    val luggage: Luggage?,
    val handLuggage: HandLuggage?,
    val isReturnable: Boolean?,
    val isExchangable: Boolean?
)

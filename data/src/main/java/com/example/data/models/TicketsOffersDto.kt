package com.example.data.models

import com.google.gson.annotations.SerializedName

data class TicketsOffersDto(
    @SerializedName("tickets_offers")
    val ticketsOffers: List<ItemsTicketsOffersDto>
)

data class ItemsTicketsOffersDto(
    val id: Int,
    val title: String,
    @SerializedName("time_range")
    val timeRange: List<String>,
    val price: ValuePriceDto
)


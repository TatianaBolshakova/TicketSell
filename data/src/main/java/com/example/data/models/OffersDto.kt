package com.example.data.models

data class OffersDto(
    val offers: List<ItemsOffersDto>
)

data class ValuePriceDto(
    val value: Int?
)

data class ItemsOffersDto(
    val id: Int,
    val title: String,
    val town: String,
    val price: ValuePriceDto?
)


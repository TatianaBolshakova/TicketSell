package com.example.domain.models

data class Offers(
    val offers: List<Any>
)

data class ValuePrice(
    val value: Int
)

data class ItemsTips(
    val id: Int,
    val title: String,
    val town: String,
    val priceDomain: ValuePrice
)


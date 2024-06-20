package com.example.data.models

import com.google.gson.annotations.SerializedName

data class TicketsDto(
    val tickets: List<ItemsTicketsDto>
)
data class DepartureDto(
    val town: String,
    val date: String,
    val airport: String
)
data class ArrivalDto(
    val town: String,
    val date: String,
    val airport: String
)
data class LuggageDto(
    @SerializedName("has_hand_luggage")
    val hasHandLuggage: Boolean,
    val price: ValuePriceDto?
)
data class HandLuggageDto(
    @SerializedName("has_hand_luggage")
    val hasHandLuggage: Boolean,
    val size: String
)
data class ItemsTicketsDto(
    val id: Int,
    val badge: String,
    @SerializedName("price")
    val priceDto: ValuePriceDto?,
    @SerializedName("provider_name")
    val providerName: String,
    val company: String,
    @SerializedName("departure")
    val departureDto: DepartureDto,
    @SerializedName("arrival")
    val arrivalDto: ArrivalDto,
    @SerializedName("has_transfer")
    val hasTransfer: Boolean,
    @SerializedName("has_visa_transfer")
    val hasVisaTransfer: Boolean,
    @SerializedName("luggage")
    val luggageDto: LuggageDto,
    @SerializedName("hand_luggage")
    val handLuggageDto: HandLuggageDto?,
    @SerializedName("is_returnable")
    val isReturnable: Boolean,
    @SerializedName("is_exchangable")
    val isExchangable:Boolean

)

package com.example.data.models.mapper

import com.example.data.models.ArrivalDto
import com.example.data.models.DepartureDto
import com.example.data.models.HandLuggageDto
import com.example.data.models.ItemsOffersDto
import com.example.data.models.ItemsTicketsDto
import com.example.data.models.ItemsTicketsOffersDto
import com.example.data.models.LuggageDto
import com.example.data.models.OffersDto
import com.example.data.models.TicketsDto
import com.example.data.models.TicketsOffersDto
import com.example.data.models.ValuePriceDto
import com.example.domain.models.Arrival
import com.example.domain.models.Departure
import com.example.domain.models.HandLuggage
import com.example.domain.models.ItemsTips
import com.example.domain.models.ItemsTickets
import com.example.domain.models.ItemsTicketsOffers
import com.example.domain.models.Luggage
import com.example.domain.models.Offers
import com.example.domain.models.Tickets
import com.example.domain.models.TicketsOffers
import com.example.domain.models.ValuePrice

fun OffersDto.mapToDomain() = Offers(
   offers = offers
)

fun ItemsOffersDto.mapItemsOffersDtoToDomain() = price?.mapPriceToDomain()?.let {
    ItemsTips(
        id = id,
        title = title,
        town = town,
        priceDomain = it

    )
}
fun List<ItemsOffersDto>.mapItemsOffersDtoToDomain(): List<ItemsTips>{
    return buildList {
        this@mapItemsOffersDtoToDomain.forEach{
            it.mapItemsOffersDtoToDomain()?.let { it1 -> add(it1) }
        }
    }
}

fun ValuePriceDto.mapPriceToDomain() = value?.let {
    ValuePrice(
        value = it
    )
}



fun TicketsDto.mapItemsTicketsDtoToDomain() = Tickets(
    tickets = tickets
)
fun List<ItemsTicketsDto>.mapItemsTicketsDtoToDomain(): List<ItemsTickets>{
    return buildList {
        this@mapItemsTicketsDtoToDomain.forEach{
            add(it.mapItemsTicketsDtoToDomain())
        }
    }
}
fun ItemsTicketsDto.mapItemsTicketsDtoToDomain() = ItemsTickets(
    id = id,
    badge = badge,
    priceDomain = priceDto?.mapPriceToDomain(),
    providerName = providerName,
    company = company,
    departure = departureDto.mapDepartureToDomain(),
    arrival = arrivalDto.mapArrivalToDomain(),
    hasTransfer = hasTransfer,
    hasVisaTransfer = hasVisaTransfer,
    luggage = luggageDto.mapLuggageToDomain(),
    handLuggage = handLuggageDto?.mapHandLuggageToDomain(),
    isReturnable = isReturnable,
    isExchangable = isExchangable
)




fun TicketsOffersDto.mapToDomain() = TicketsOffers(
    ticketsOffers = ticketsOffers
)
fun List<ItemsTicketsOffersDto>.mapTicketsOffersToDomain(): List<ItemsTicketsOffers>{
    return buildList {
        this@mapTicketsOffersToDomain.forEach{
            it.mapTicketsOffersToDomain()?.let { it1 -> add(it1) }
        }
    }
}
fun ItemsTicketsOffersDto.mapTicketsOffersToDomain() = price.mapPriceToDomain()?.let {
    ItemsTicketsOffers(
        id = id,
        title = title,
        timeRange = timeRange,
        price = it
    )
}
fun DepartureDto.mapDepartureToDomain() = Departure(
    town = town,
    date = date,
    airport = airport
)
fun ArrivalDto.mapArrivalToDomain() = Arrival(
    town = town,
    date = date,
    airport = airport
)

fun LuggageDto.mapLuggageToDomain() = Luggage(
    hasHandLuggage = hasHandLuggage,
    price = price?.mapPriceToDomain()
)

fun HandLuggageDto.mapHandLuggageToDomain() = HandLuggage(
    hasHandLuggage = hasHandLuggage,
    size = size
)

package com.example.data.api

import com.example.data.models.OffersDto
import com.example.data.models.TicketsDto
import com.example.data.models.TicketsOffersDto
import retrofit2.http.GET


interface Api {

    //“Главная. Первый вход”.
    //https://run.mocky.io/v3/ad9a46ba-276c-4a81-88a6-c068e51cce3a

    @GET("/v3/ad9a46ba-276c-4a81-88a6-c068e51cce3a")
    suspend fun getOffers(
    ): OffersDto

    // “Поиск. Выбрана страна”.
    //https://run.mocky.io/v3/38b5205d-1a3d-4c2f-9d77-2f9d1ef01a4a

    @GET("/v3/38b5205d-1a3d-4c2f-9d77-2f9d1ef01a4a")
    suspend fun getTicketsOffers(): TicketsOffersDto


    //  “Посмотреть все билеты”.
    //https://run.mocky.io/v3/c0464573-5a13-45c9-89f8-717436748b69

    @GET("/v3/c0464573-5a13-45c9-89f8-717436748b69")
    suspend fun getTickets(): TicketsDto
}


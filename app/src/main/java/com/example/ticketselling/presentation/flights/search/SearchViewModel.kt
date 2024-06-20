package com.example.ticketselling.presentation.flights.search


import androidx.lifecycle.ViewModel


class SearchViewModel  : ViewModel() {

    val titlesTips = listOf(
        "Сложный маршрут",
        "Куда угодно",
        "Выходные",
        "Горячие билеты"
    )
    val titlesPopulars = listOf(
        "Сочи",
        "Стамбул",
        "Пхукет",
    )
}

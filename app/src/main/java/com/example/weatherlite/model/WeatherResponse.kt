package com.example.weatherlite.model

data class WeatherResponse(
    val current: Current,
    val location: Location,
    val request: Request
)
package com.example.weatherlite.api

import com.example.weatherlite.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("current")
    suspend fun getCurrentWeather(
        @Query("access_key") access_key: String = RetrofitFactory.API_KEY,
        @Query("query") query: String
    ): WeatherResponse
}
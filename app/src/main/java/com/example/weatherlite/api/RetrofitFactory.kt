package com.example.weatherlite.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    const val API_KEY = "2ea8a032e080b6ce8bb41b4726ac3325"
    const val API_URL = "http://api.weatherstack.com/"

    val retrofitBuilder: Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val weatherService: WeatherService by lazy{
        retrofitBuilder
            .create(WeatherService::class.java)
    }
}
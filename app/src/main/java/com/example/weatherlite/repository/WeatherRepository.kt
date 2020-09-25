package com.example.weatherlite.repository

import androidx.lifecycle.LiveData
import com.example.weatherlite.api.RetrofitFactory
import com.example.weatherlite.model.WeatherResponse
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class WeatherRepository {

    private val job: CompletableJob? = null

    fun getCurrentWeather(location: String): LiveData<WeatherResponse>{
        val job = Job()
        return object : LiveData<WeatherResponse>(){
            override fun onActive() {
                super.onActive()
                job.let {
                    CoroutineScope(IO + job).launch {
                        val currentWeather = RetrofitFactory.weatherService.getCurrentWeather("", location)
                        withContext(Main){
                            value = currentWeather
                            job.complete()
                        }
                    }
                }
            }
        }
    }

    fun cancelJob(){
        job?.cancel()
    }
}
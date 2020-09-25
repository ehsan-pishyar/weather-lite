package com.example.weatherlite.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.weatherlite.model.WeatherResponse
import com.example.weatherlite.repository.WeatherRepository

class WeatherViewModel(private val repository: WeatherRepository): ViewModel() {

    private val _location: MutableLiveData<String> = MutableLiveData()

    val currentWeather: LiveData<WeatherResponse> = Transformations
        .switchMap(_location){
            repository.getCurrentWeather(_location.toString())
        }

    fun setLocation(location: String){
        if (_location.value == location){
            return
        }
        _location.value = location
    }

    fun cancelJob(){
        repository.cancelJob()
    }
}
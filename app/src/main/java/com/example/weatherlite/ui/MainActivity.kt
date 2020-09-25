package com.example.weatherlite.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherlite.R
import com.example.weatherlite.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        setLocation("Tehran")
        initUi()
    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
    }

    private fun initUi(){
        viewModel.currentWeather.observe(this, Observer {
            TODO()
        })
    }

    private fun setLocation(location: String){
        viewModel.setLocation(location)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJob()
    }
}
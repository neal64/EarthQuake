package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.Result
import com.example.myapplication.repository.EarthQuakesRepository

class HomeViewModel (val repository : EarthQuakesRepository) : ViewModel() {

    suspend fun getEarthQuakesData(): Result {
        return repository.getEarthQuakes()
    }
}
package com.example.myapplication

import com.example.myapplication.model.Earthquakes

sealed class Result {
    data class Success(val data: MutableList<Earthquakes>) : Result()
    data class Error(val exception: Exception) : Result()
}
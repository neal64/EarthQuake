package com.example.myapplication.model

data class Earthquakes(
    val datetime: String,
    val depth: Double,
    val magnitude: Double,
    val lng: Double,
    val lat: Double
)
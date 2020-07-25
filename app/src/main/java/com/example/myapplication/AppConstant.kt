package com.example.myapplication

object AppConstant {
    val EARTH_QUAKE_URL =
        "http://api.geonames.org/earthquakesJSON?formatted=true&north=44.1&south=-9.9&east=-22.4&west=55.2&username=mkoppelman"

    //Bundle Names
    val LAT = "lat"
    val LNG = "lng"

    //JSON Keys
    val EARTH_QUAKES = "earthquakes"
    val DATE_TIME = "datetime"
    val DEPTH = "depth"
    val MANG = "magnitude"
}
package com.example.myapplication.repository

import com.example.myapplication.ResponseParser
import com.example.myapplication.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL


class EarthQuakesRepository (val url : URL) {

    suspend fun getEarthQuakes(): Result {
        return withContext(Dispatchers.IO) {
            (url.openConnection() as? HttpURLConnection)?.run {
                try {
                    connect()
                    val code: Int = getResponseCode()
                    if (code == HttpURLConnection.HTTP_OK) {
                        Result.Success(ResponseParser.parse(inputStream))
                    } else {
                        Result.Error(Exception("Error Code $code"))
                    }
                } catch (ex: Exception) {
                    Result.Error(Exception("Error Code ${ex.printStackTrace()}"))
                }
            }
        } as Result
    }
}
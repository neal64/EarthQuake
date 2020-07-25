package com.example.myapplication

import android.util.Log
import com.example.myapplication.model.Earthquakes
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception

object ResponseParser {
    fun parse(inputStream: InputStream): MutableList<Earthquakes> {
        val model: MutableList<Earthquakes> = ArrayList()
        try {
            val br = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
            val sb = StringBuilder()
            var line: String? = null
            while (br.readLine().also({ line = it }) != null) {
                sb.append("$line")
            }
            val jsonObject = JSONObject(sb.toString())
            val isArray = jsonObject.getString(AppConstant.EARTH_QUAKES)
            val jsonArray = JSONArray(isArray)
            for (i in 0 until jsonArray.length()) {
                val obj = JSONObject(jsonArray.get(i).toString())
                model.add(
                    Earthquakes(
                        obj.getString(AppConstant.DATE_TIME),
                        obj.getDouble(AppConstant.DEPTH),
                        obj.getDouble(AppConstant.LNG),
                        obj.getDouble(AppConstant.MANG),
                        obj.getDouble(AppConstant.LAT)
                    )
                )
            }
        }catch (e : Exception){
            Log.d("SampleApp", "Parsing Error ${e.printStackTrace()}")
        }

        return model
    }
}

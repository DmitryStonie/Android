package com.example.lab1

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.serialization.json.Json
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL
import java.net.URLConnection


class MyViewModel : ViewModel() {
    private val isStarted = MutableLiveData(false)
    private var value: MutableLiveData<ArrayList<Valute>> = MutableLiveData<ArrayList<Valute>>()
    fun getValue(): LiveData<ArrayList<Valute>> {
        return value
    }

    fun execute() {
        if (!isStarted.value!!) {
            isStarted.postValue(true)
            val runnable = Runnable {
                getJson()
            }
            val thread = Thread(runnable)
            thread.start()
        }
    }

    fun getJson(){
        val url: URL = URL("https://www.cbr-xml-daily.ru/daily_json.js")
        val httpURLConnection: URLConnection? = url.openConnection();
        val inputStream: InputStream = httpURLConnection!!.getInputStream()
        val bufferedReader: BufferedReader = BufferedReader(InputStreamReader(inputStream))
        var line: String? = bufferedReader.readLine()
        var data: String = ""

        while (line != null) {
            data += line
            line = bufferedReader.readLine()
        }

        var valutes: ArrayList<Valute> = ArrayList<Valute>()
        if (data.isNotEmpty()) {
            val jsonObject = JSONObject(data)
            val valutesObject = jsonObject.getJSONObject("Valute")
            for (key in valutesObject.keys()) {
                val valute = valutesObject.getJSONObject(key)
                valutes.add(Json.decodeFromString<Valute>(valute.toString()))
                Log.w("Adsasd", Json.decodeFromString<Valute>(valute.toString()).Name)
            }
        }

        value.postValue(valutes)
        Log.w("Adsasd", "Sended everything")
    }
}
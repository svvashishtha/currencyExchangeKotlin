package com.example.daynight.network

import com.example.daynight.models.ExchangeRateResponse
import com.google.gson.Gson
import javax.inject.Inject

class ExchangeRepo  @Inject constructor(private val retrofitBuilder: RetrofitBuilder)  {
    private val jsonString = "{\"rates\":{\"CAD\":1.5041,\"HKD\":9.2307,\"ISK\":152.1,\"PHP\":57.78,\"DKK\":7.4366,\"HUF\":367.48,\"CZK\":26.226,\"AUD\":1.543},\"base\":\"EUR\",\"date\":\"2021-03-10\"}"
    fun getExchangeRate(): ExchangeRateResponse {
        return Gson().fromJson(jsonString, ExchangeRateResponse::class.java)
    }
}
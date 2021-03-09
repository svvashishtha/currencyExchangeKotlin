package com.example.daynight.network

import com.example.daynight.models.ExchangeRateResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeService {
    @GET("latest")
    suspend fun getExchangeRates(@Query("base") base : String = "EUR"): ExchangeRateResponse

}
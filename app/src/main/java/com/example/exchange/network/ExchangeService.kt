package com.example.exchange.network

import com.example.exchange.BuildConfig
import com.example.exchange.models.ExchangeRateResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeService {
    @GET("latest")
    suspend fun getExchangeRates(
        @Query("base") base: String = "EUR",
        @Query("access_key") accessKey: String = BuildConfig.accessKey
    ): ExchangeRateResponse
}
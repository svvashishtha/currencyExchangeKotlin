package com.example.daynight.network

import com.example.daynight.models.ExchangeRateResponse
import javax.inject.Inject

class ExchangeRepo  @Inject constructor(private val retrofitBuilder: RetrofitBuilder)  {
    suspend fun getExchangeRate(): ExchangeRateResponse {
        return retrofitBuilder.getExchangeRetrofitClient().getExchangeRates()
    }
}
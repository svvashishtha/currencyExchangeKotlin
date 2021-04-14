package com.example.exchange.network

import com.example.exchange.models.ExchangeRateResponse
import javax.inject.Inject

class ExchangeRepo @Inject constructor(private val retrofitBuilder: RetrofitBuilder) {
    suspend fun getExchangeRate(): ExchangeRateResponse {
        return retrofitBuilder.getExchangeRetrofitClient().getExchangeRates()
    }
}
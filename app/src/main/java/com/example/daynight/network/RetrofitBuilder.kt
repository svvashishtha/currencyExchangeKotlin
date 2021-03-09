package com.example.daynight.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RetrofitBuilder @Inject constructor(){

    fun getExchangeRetrofitClient(): ExchangeService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.exchangeratesapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

       return retrofit.create(ExchangeService::class.java)
    }
}
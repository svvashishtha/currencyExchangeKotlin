package com.example.daynight.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class RetrofitBuilder @Inject constructor() {

    fun getExchangeRetrofitClient(): ExchangeService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.exchangeratesapi.io/")
            .client(getHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ExchangeService::class.java)
    }

    private fun getHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }
}
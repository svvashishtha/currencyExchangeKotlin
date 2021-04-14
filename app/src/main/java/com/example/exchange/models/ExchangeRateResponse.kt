package com.example.exchange.models

import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ExchangeRateResponse(
    val base: String?,
    val date: String?,
    val rates: Rate?,
    val success: Boolean?,
    val error: ErrorObject?
) {
}

data class Rate(
    @SerializedName("CAD")
    @Expose
    val cAD: Double? = null,

    @SerializedName("HKD")
    @Expose
    val hKD: Double? = null,

    @SerializedName("ISK")
    @Expose
    val iSK: Double? = null,

    @SerializedName("PHP")
    @Expose
    val pHP: Double? = null,

    @SerializedName("DKK")
    @Expose
    val dKK: Double? = null,

    @SerializedName("HUF")
    @Expose
    val hUF: Double? = null,

    @SerializedName("CZK")
    @Expose
    val cZK: Double? = null,

    @SerializedName("GBP")
    @Expose
    val gBP: Double? = null,

    @SerializedName("RON")
    @Expose
    val rON: Double? = null,

    @SerializedName("SEK")
    @Expose
    val sEK: Double? = null,

    @SerializedName("IDR")
    @Expose
    val iDR: Double? = null,

    @SerializedName("INR")
    @Expose
    val iNR: Double? = null,

    @SerializedName("BRL")
    @Expose
    val bRL: Double? = null,

    @SerializedName("RUB")
    @Expose
    val rUB: Double? = null,

    @SerializedName("HRK")
    @Expose
    val hRK: Double? = null,

    @SerializedName("JPY")
    @Expose
    val jPY: Double? = null,

    @SerializedName("THB")
    @Expose
    val tHB: Double? = null,

    @SerializedName("CHF")
    @Expose
    val cHF: Double? = null,

    @SerializedName("EUR")
    @Expose
    val eUR: Double? = null,

    @SerializedName("MYR")
    @Expose
    val mYR: Double? = null,

    @SerializedName("BGN")
    @Expose
    val bGN: Double? = null,

    @SerializedName("TRY")
    @Expose
    val tRY: Double? = null,

    @SerializedName("CNY")
    @Expose
    val cNY: Double? = null,

    @SerializedName("NOK")
    @Expose
    val nOK: Double? = null,

    @SerializedName("NZD")
    @Expose
    val nZD: Double? = null,

    @SerializedName("ZAR")
    @Expose
    val zAR: Double? = null,

    @SerializedName("USD")
    @Expose
    val uSD: Double? = null,

    @SerializedName("MXN")
    @Expose
    val mXN: Double? = null,

    @SerializedName("SGD")
    @Expose
    val sGD: Double? = null,

    @SerializedName("AUD")
    @Expose
    val aUD: Double? = null,

    @SerializedName("ILS")
    @Expose
    val iLS: Double? = null,

    @SerializedName("KRW")
    @Expose
    val kRW: Double? = null,

    @SerializedName("PLN")
    @Expose
    val pLN: Double? = null,
)

data class ErrorObject(val code: String, val type: String, val info: String) {
    override fun toString(): String {
        return Gson().toJson(this).toString()
    }
}


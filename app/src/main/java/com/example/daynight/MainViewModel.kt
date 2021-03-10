package com.example.daynight

import android.util.ArrayMap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daynight.models.ExchangeRateResponse
import com.example.daynight.network.RetrofitBuilder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val retrofitBuilder: RetrofitBuilder) : ViewModel() {

    private var currency1: String = "CAD"
    private var currency2: String = "CAD"
    val currencyStrings = MutableLiveData<MutableList<String>?>()
    private val currencyStringsMap = ArrayMap<String, Double>()
    val currentExchangeRate = MutableLiveData<Double>()
    private var amountToExchange = 0.0
    private var conversionMode = 1
    fun getExchangeRate() {
        viewModelScope.launch {
            val rateLD = retrofitBuilder.getExchangeRetrofitClient().getExchangeRates()
            currencyStrings.value = getCurrencyStringList(rateLD)!!
        }
    }

    private fun getCurrencyStringList(exchangeRateResponse: ExchangeRateResponse): MutableList<String> {
        val currencyList = mutableListOf<String>()
        if (exchangeRateResponse.rates.cAD?.isFinite() == true && exchangeRateResponse.rates.cAD > 0) {
            currencyList.add("CAD")
            currencyStringsMap["CAD"] = exchangeRateResponse.rates.cAD
        }
        if (exchangeRateResponse.rates.hKD?.isFinite() == true && exchangeRateResponse.rates.hKD > 0) {
            currencyList.add("HKD")
            currencyStringsMap["HKD"] = exchangeRateResponse.rates.hKD
        }
        if (exchangeRateResponse.rates.iSK?.isFinite() == true && exchangeRateResponse.rates.iSK > 0) {
            currencyList.add("ISK")
            currencyStringsMap["ISK"] = exchangeRateResponse.rates.iSK
        }
        if (exchangeRateResponse.rates.pHP?.isFinite() == true && exchangeRateResponse.rates.pHP > 0) {
            currencyList.add("PHP")
            currencyStringsMap["PHP"] = exchangeRateResponse.rates.pHP
        }
        if (exchangeRateResponse.rates.dKK?.isFinite() == true && exchangeRateResponse.rates.dKK > 0) {
            currencyList.add("DKK")
            currencyStringsMap["DKK"] = exchangeRateResponse.rates.dKK
        }
        if (exchangeRateResponse.rates.hUF?.isFinite() == true && exchangeRateResponse.rates.hUF > 0) {
            currencyList.add("HUF")
            currencyStringsMap["HUF"] = exchangeRateResponse.rates.hUF
        }
        if (exchangeRateResponse.rates.cZK?.isFinite() == true && exchangeRateResponse.rates.cZK > 0) {
            currencyList.add("CZK")
            currencyStringsMap["CZK"] = exchangeRateResponse.rates.cZK
        }
        if (exchangeRateResponse.rates.gBP?.isFinite() == true && exchangeRateResponse.rates.gBP > 0) {
            currencyList.add("GBP")
            currencyStringsMap["GBP"] = exchangeRateResponse.rates.gBP
        }
        if (exchangeRateResponse.rates.rON?.isFinite() == true && exchangeRateResponse.rates.rON > 0) {
            currencyList.add("RON")
            currencyStringsMap["RON"] = exchangeRateResponse.rates.rON
        }
        if (exchangeRateResponse.rates.sEK?.isFinite() == true && exchangeRateResponse.rates.sEK > 0) {
            currencyList.add("SEK")
            currencyStringsMap["SEK"] = exchangeRateResponse.rates.sEK
        }
        if (exchangeRateResponse.rates.iDR?.isFinite() == true && exchangeRateResponse.rates.iDR > 0) {
            currencyList.add("IDR")
            currencyStringsMap["IDR"] = exchangeRateResponse.rates.iDR
        }
        if (exchangeRateResponse.rates.iNR?.isFinite() == true && exchangeRateResponse.rates.iNR > 0) {
            currencyList.add("INR")
            currencyStringsMap["INR"] = exchangeRateResponse.rates.iNR
        }
        if (exchangeRateResponse.rates.bRL?.isFinite() == true && exchangeRateResponse.rates.bRL > 0) {
            currencyList.add("BRL")
            currencyStringsMap["BRL"] = exchangeRateResponse.rates.bRL
        }
        if (exchangeRateResponse.rates.rUB?.isFinite() == true && exchangeRateResponse.rates.rUB > 0) {
            currencyList.add("RUB")
            currencyStringsMap["RUB"] = exchangeRateResponse.rates.rUB
        }
        if (exchangeRateResponse.rates.hRK?.isFinite() == true && exchangeRateResponse.rates.hRK > 0) {
            currencyList.add("HRK")
            currencyStringsMap["HRK"] = exchangeRateResponse.rates.hRK
        }
        if (exchangeRateResponse.rates.jPY?.isFinite() == true && exchangeRateResponse.rates.jPY > 0) {
            currencyList.add("JPY")
            currencyStringsMap["JPY"] = exchangeRateResponse.rates.jPY
        }
        if (exchangeRateResponse.rates.tHB?.isFinite() == true && exchangeRateResponse.rates.tHB > 0) {
            currencyList.add("THB")
            currencyStringsMap["THB"] = exchangeRateResponse.rates.tHB
        }
        if (exchangeRateResponse.rates.cHF?.isFinite() == true && exchangeRateResponse.rates.cHF > 0) {
            currencyList.add("CHF")
            currencyStringsMap["CHF"] = exchangeRateResponse.rates.cHF
        }
        if (exchangeRateResponse.rates.eUR?.isFinite() == true && exchangeRateResponse.rates.eUR > 0) {
            currencyList.add("EUR")
            currencyStringsMap["EUR"] = exchangeRateResponse.rates.eUR
        }
        if (exchangeRateResponse.rates.mYR?.isFinite() == true && exchangeRateResponse.rates.mYR > 0) {
            currencyList.add("MYR")
            currencyStringsMap["MYR"] = exchangeRateResponse.rates.mYR
        }
        if (exchangeRateResponse.rates.bGN?.isFinite() == true && exchangeRateResponse.rates.bGN > 0) {
            currencyList.add("BGN")
            currencyStringsMap["BGN"] = exchangeRateResponse.rates.bGN
        }
        if (exchangeRateResponse.rates.tRY?.isFinite() == true && exchangeRateResponse.rates.tRY > 0) {
            currencyList.add("TRY")
            currencyStringsMap["TRY"] = exchangeRateResponse.rates.tRY
        }
        if (exchangeRateResponse.rates.cNY?.isFinite() == true && exchangeRateResponse.rates.cNY > 0) {
            currencyList.add("CNY")
            currencyStringsMap["CNY"] = exchangeRateResponse.rates.cNY
        }
        if (exchangeRateResponse.rates.nOK?.isFinite() == true && exchangeRateResponse.rates.nOK > 0) {
            currencyList.add("NOK")
            currencyStringsMap["NOK"] = exchangeRateResponse.rates.nOK
        }
        if (exchangeRateResponse.rates.nZD?.isFinite() == true && exchangeRateResponse.rates.nZD > 0) {
            currencyList.add("NZD")
            currencyStringsMap["NZD"] = exchangeRateResponse.rates.nZD
        }
        if (exchangeRateResponse.rates.zAR?.isFinite() == true && exchangeRateResponse.rates.zAR > 0) {
            currencyList.add("ZAR")
            currencyStringsMap["ZAR"] = exchangeRateResponse.rates.zAR
        }
        if (exchangeRateResponse.rates.uSD?.isFinite() == true && exchangeRateResponse.rates.uSD > 0) {
            currencyList.add("USD")
            currencyStringsMap["USD"] = exchangeRateResponse.rates.uSD
        }
        if (exchangeRateResponse.rates.mXN?.isFinite() == true && exchangeRateResponse.rates.mXN > 0) {
            currencyList.add("MXN")
            currencyStringsMap["MXN"] = exchangeRateResponse.rates.mXN
        }
        if (exchangeRateResponse.rates.sGD?.isFinite() == true && exchangeRateResponse.rates.sGD > 0) {
            currencyList.add("SGD")
            currencyStringsMap["SGC"] = exchangeRateResponse.rates.sGD
        }
        if (exchangeRateResponse.rates.aUD?.isFinite() == true && exchangeRateResponse.rates.aUD > 0) {
            currencyList.add("AUD")
            currencyStringsMap["AUD"] = exchangeRateResponse.rates.aUD
        }
        if (exchangeRateResponse.rates.kRW?.isFinite() == true && exchangeRateResponse.rates.kRW > 0) {
            currencyList.add("KRW")
            currencyStringsMap["KRW"] = exchangeRateResponse.rates.kRW
        }
        if (exchangeRateResponse.rates.pLN?.isFinite() == true && exchangeRateResponse.rates.pLN > 0) {
            currencyList.add("PLN")
            currencyStringsMap["PLN"] = exchangeRateResponse.rates.pLN
        }
        if (exchangeRateResponse.rates.iLS?.isFinite() == true && exchangeRateResponse.rates.iLS > 0) {
            currencyList.add("ILS")
            currencyStringsMap["ILS"] = exchangeRateResponse.rates.iLS
        }
        return currencyList
    }

    fun setSelectedCurrency1(position: Int) {
        currency1 = currencyStrings.value?.get(position) ?: "CAD"
        getExchangeValue(amountToExchange)
    }

    fun setSelectedCurrency2(position: Int) {
        currency2 = currencyStrings.value?.get(position) ?: "CAD"
        getExchangeValue(amountToExchange)
    }

    fun getExchangeValue(amount: Double) {
        amountToExchange = amount
        if (conversionMode == 1) {
            currentExchangeRate.value =
                amount * currencyStringsMap[currency1]!! / currencyStringsMap[currency2]!!
        } else {
            currentExchangeRate.value =
                amount * currencyStringsMap[currency2]!! / currencyStringsMap[currency1]!!
        }
    }

    fun setConversionMode(i: Int) {
        // 1
        // currency1 / currency2
        //2
        // currency2 / currency1
        conversionMode = i
    }
}
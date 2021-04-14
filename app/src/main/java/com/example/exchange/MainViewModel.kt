package com.example.exchange

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exchange.CurrencyUtils.Companion.getCurrencyStringList
import com.example.exchange.network.ExchangeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val exchangeRepo: ExchangeRepo) :
    ViewModel() {

    private var currency1: String = "CAD"
    private var currency2: String = "CAD"
    val currencyStrings = MutableLiveData<MutableList<String>?>()
    val errorString = MutableLiveData<String>()
    private var currencyStringsMap = HashMap<String, Double>()
    val currentExchangeRate = MutableLiveData<Double>()
    private var amountToExchange = 0.0
    private var conversionMode = 1

    fun getExchangeRate() {
        viewModelScope.launch {
            val rateLD = exchangeRepo.getExchangeRate()
            if (rateLD.rates !=null) {
                rateLD.rates?.let{
                    val pair = getCurrencyStringList(it)
                    currencyStrings.value = pair.first
                    currencyStringsMap = pair.second
                }

            }else{
                rateLD.error?.let{
                    errorString.value = it.toString()
                }
            }
        }
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
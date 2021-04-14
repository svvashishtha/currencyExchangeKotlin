package com.example.exchange

import com.example.exchange.models.Rate

class CurrencyUtils {
    companion object {
        fun getCurrencyStringList(rate: Rate): Pair<MutableList<String>, HashMap<String, Double>> {

            val currencyList = mutableListOf<String>()
            val currencyStringsMap = HashMap<String, Double>()
            if (rate.cAD?.isFinite() == true && rate.cAD > 0) {
                currencyList.add("CAD")
                currencyStringsMap["CAD"] = rate.cAD
            }
            if (rate.hKD?.isFinite() == true && rate.hKD > 0) {
                currencyList.add("HKD")
                currencyStringsMap["HKD"] = rate.hKD
            }
            if (rate.iSK?.isFinite() == true && rate.iSK > 0) {
                currencyList.add("ISK")
                currencyStringsMap["ISK"] = rate.iSK
            }
            if (rate.pHP?.isFinite() == true && rate.pHP > 0) {
                currencyList.add("PHP")
                currencyStringsMap["PHP"] = rate.pHP
            }
            if (rate.dKK?.isFinite() == true && rate.dKK > 0) {
                currencyList.add("DKK")
                currencyStringsMap["DKK"] = rate.dKK
            }
            if (rate.hUF?.isFinite() == true && rate.hUF > 0) {
                currencyList.add("HUF")
                currencyStringsMap["HUF"] = rate.hUF
            }
            if (rate.cZK?.isFinite() == true && rate.cZK > 0) {
                currencyList.add("CZK")
                currencyStringsMap["CZK"] = rate.cZK
            }
            if (rate.gBP?.isFinite() == true && rate.gBP > 0) {
                currencyList.add("GBP")
                currencyStringsMap["GBP"] = rate.gBP
            }
            if (rate.rON?.isFinite() == true && rate.rON > 0) {
                currencyList.add("RON")
                currencyStringsMap["RON"] = rate.rON
            }
            if (rate.sEK?.isFinite() == true && rate.sEK > 0) {
                currencyList.add("SEK")
                currencyStringsMap["SEK"] = rate.sEK
            }
            if (rate.iDR?.isFinite() == true && rate.iDR > 0) {
                currencyList.add("IDR")
                currencyStringsMap["IDR"] = rate.iDR
            }
            if (rate.iNR?.isFinite() == true && rate.iNR > 0) {
                currencyList.add("INR")
                currencyStringsMap["INR"] = rate.iNR
            }
            if (rate.bRL?.isFinite() == true && rate.bRL > 0) {
                currencyList.add("BRL")
                currencyStringsMap["BRL"] = rate.bRL
            }
            if (rate.rUB?.isFinite() == true && rate.rUB > 0) {
                currencyList.add("RUB")
                currencyStringsMap["RUB"] = rate.rUB
            }
            if (rate.hRK?.isFinite() == true && rate.hRK > 0) {
                currencyList.add("HRK")
                currencyStringsMap["HRK"] = rate.hRK
            }
            if (rate.jPY?.isFinite() == true && rate.jPY > 0) {
                currencyList.add("JPY")
                currencyStringsMap["JPY"] = rate.jPY
            }
            if (rate.tHB?.isFinite() == true && rate.tHB > 0) {
                currencyList.add("THB")
                currencyStringsMap["THB"] = rate.tHB
            }
            if (rate.cHF?.isFinite() == true && rate.cHF > 0) {
                currencyList.add("CHF")
                currencyStringsMap["CHF"] = rate.cHF
            }
            if (rate.eUR?.isFinite() == true && rate.eUR > 0) {
                currencyList.add("EUR")
                currencyStringsMap["EUR"] = rate.eUR
            }
            if (rate.mYR?.isFinite() == true && rate.mYR > 0) {
                currencyList.add("MYR")
                currencyStringsMap["MYR"] = rate.mYR
            }
            if (rate.bGN?.isFinite() == true && rate.bGN > 0) {
                currencyList.add("BGN")
                currencyStringsMap["BGN"] = rate.bGN
            }
            if (rate.tRY?.isFinite() == true && rate.tRY > 0) {
                currencyList.add("TRY")
                currencyStringsMap["TRY"] = rate.tRY
            }
            if (rate.cNY?.isFinite() == true && rate.cNY > 0) {
                currencyList.add("CNY")
                currencyStringsMap["CNY"] = rate.cNY
            }
            if (rate.nOK?.isFinite() == true && rate.nOK > 0) {
                currencyList.add("NOK")
                currencyStringsMap["NOK"] = rate.nOK
            }
            if (rate.nZD?.isFinite() == true && rate.nZD > 0) {
                currencyList.add("NZD")
                currencyStringsMap["NZD"] = rate.nZD
            }
            if (rate.zAR?.isFinite() == true && rate.zAR > 0) {
                currencyList.add("ZAR")
                currencyStringsMap["ZAR"] = rate.zAR
            }
            if (rate.uSD?.isFinite() == true && rate.uSD > 0) {
                currencyList.add("USD")
                currencyStringsMap["USD"] = rate.uSD
            }
            if (rate.mXN?.isFinite() == true && rate.mXN > 0) {
                currencyList.add("MXN")
                currencyStringsMap["MXN"] = rate.mXN
            }
            if (rate.sGD?.isFinite() == true && rate.sGD > 0) {
                currencyList.add("SGD")
                currencyStringsMap["SGC"] = rate.sGD
            }
            if (rate.aUD?.isFinite() == true && rate.aUD > 0) {
                currencyList.add("AUD")
                currencyStringsMap["AUD"] = rate.aUD
            }
            if (rate.kRW?.isFinite() == true && rate.kRW > 0) {
                currencyList.add("KRW")
                currencyStringsMap["KRW"] = rate.kRW
            }
            if (rate.pLN?.isFinite() == true && rate.pLN > 0) {
                currencyList.add("PLN")
                currencyStringsMap["PLN"] = rate.pLN
            }
            if (rate.iLS?.isFinite() == true && rate.iLS > 0) {
                currencyList.add("ILS")
                currencyStringsMap["ILS"] = rate.iLS
            }
            return Pair(currencyList, currencyStringsMap)
        }
    }
}
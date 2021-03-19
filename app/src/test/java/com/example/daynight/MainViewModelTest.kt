package com.example.daynight

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.daynight.network.ExchangeRepo
import com.example.daynight.network.RetrofitBuilder
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.robolectric.annotation.Config

@Config(manifest=Config.NONE)
@RunWith(AndroidJUnit4::class)
class MainViewModelTest {
    val repo = ExchangeRepo(RetrofitBuilder())
    val viewModel = MainViewModel(repo)

    @Before
    fun setup() {
        runBlocking {
            viewModel.getExchangeRate()
        }
    }

    @Test
    fun test_currencyString_isPopulated() {
        //now currencyStrings should be populated
        val currencyString = viewModel.currencyStrings.value
        assert(currencyString != null)
        assert(currencyString?.contains("CAD") ?: false)
        assert(currencyString?.contains("HKD") ?: false)
        assert(currencyString?.contains("ISK") ?: false)
        assert(currencyString?.contains("PHP") ?: false)
        assert(currencyString?.contains("DKK") ?: false)
        assert(currencyString?.contains("HUF") ?: false)
        assert(currencyString?.contains("CZK") ?: false)
        assert(currencyString?.contains("AUD") ?: false)


    }

    @Test
    fun test_setSelectedCurrency() {
        viewModel.getExchangeValue(1.0)
        val currencyString = viewModel.currencyStrings.value
        val index = currencyString?.indexOf("PHP")
        assert(index != null)
        viewModel.setSelectedCurrency1(index!!)
        //selected currency should be php,
        val exchangedValue = viewModel.currentExchangeRate.value
        assert(exchangedValue != null)
        val exchangedValueString = String.format("%.2f",exchangedValue)
        assert(exchangedValueString == "38.41")
    }

    @Test
    fun testPutting_1_inFirstTextBoxAnd_setSelcetedCurrency1(){
        viewModel.setConversionMode(2)
        viewModel.getExchangeValue(1.0)
        val currencyString = viewModel.currencyStrings.value
        val index = currencyString?.indexOf("PHP")
        assert(index != null)
        viewModel.setSelectedCurrency1(index!!)
        //selected currency should be php,
        val exchangedValue = viewModel.currentExchangeRate.value
        assert(exchangedValue != null)
        val exchangedValueString = String.format("%.2f",exchangedValue)
        assert(exchangedValueString == "0.03")
    }

    @Test
    fun testPutting_1_inFirstTextBoxAnd_setSelcetedCurrency2(){
        viewModel.setConversionMode(2)
        viewModel.getExchangeValue(1.0)
        val currencyString = viewModel.currencyStrings.value
        val index = currencyString?.indexOf("PHP")
        assert(index != null)
        viewModel.setSelectedCurrency2(index!!)
        //selected currency should be php,
        val exchangedValue = viewModel.currentExchangeRate.value
        assert(exchangedValue != null)
        val exchangedValueString = String.format("%.2f",exchangedValue)
        assert(exchangedValueString == "38.41")
    }

    @Test
    fun test_setConversionMode(){
        viewModel.setConversionMode(1)

        viewModel.getExchangeValue(1.0)
        val currencyString = viewModel.currencyStrings.value
        val index = currencyString?.indexOf("PHP")
        assert(index != null)
        viewModel.setSelectedCurrency2(index!!)
        //selected currency should be php,
        val exchangedValue1 = viewModel.currentExchangeRate.value
        assert(exchangedValue1 != null)
        val exchangedValueString1 = String.format("%.2f",exchangedValue1)
        assert(exchangedValueString1 == "0.03")

        viewModel.setConversionMode(2)
        viewModel.getExchangeValue(1.0)
        val exchangedValue2 = viewModel.currentExchangeRate.value
        assert(exchangedValue2 != null)
        val exchangedValueString2 = String.format("%.2f",exchangedValue2)
        assert(exchangedValueString2 == "38.41")

    }
}
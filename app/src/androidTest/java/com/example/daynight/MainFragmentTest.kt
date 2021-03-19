package com.example.daynight

import android.util.ArrayMap
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.example.daynight.CurrencyUtils.Companion.getCurrencyStringList
import com.example.daynight.network.ExchangeRepo
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@LargeTest
@HiltAndroidTest
class MainFragmentTest {
    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var repo: ExchangeRepo
    private val currencyStrings: MutableList<String> = mutableListOf<String>()
    private var currencyStringsMap = ArrayMap<String, Double>()

    @Before
    fun getCurrencyStrings() {
        hiltRule.inject()
        runBlocking {
            val pair = getCurrencyStringList(repo.getExchangeRate())
            currencyStrings.addAll(pair.first)
            currencyStringsMap = pair.second
        }
    }

    @Test
    fun checkListInSpinner1() {
        onView(withId(R.id.spinner_1)).perform(click())
        currencyStrings.forEach {
            onView(withText(it)).check(matches(isDisplayed()))
        }

    }

    @Test
    fun checkListInSpinner2() {
        onView(withId(R.id.spinner_2)).perform(click())
        currencyStrings.forEach {
            onView(withText(it)).check(matches(isDisplayed()))
        }

    }

    @Test
    fun checkCADConvertsToCAD() {
        onView(withId(R.id.text_area_1)).perform(typeText("1"))
        val convertedString = 1.0
        onView(withId(R.id.text_area_2)).check(
            matches(
                withText(
                    String.format(
                        "%.2f",
                        convertedString
                    )
                )
            )
        )
    }

    @Test
    fun checkCADConvertsToISK() {
        onView(withId(R.id.spinner_1)).perform(click())
        onView(withText("CAD")).perform(click())
        onView(withId(R.id.spinner_2)).perform(click())
        onView(withText("ISK")).perform(click())
        val exchangeRate = currencyStringsMap["ISK"]!! / currencyStringsMap["CAD"]!!
        val amountToExchange = 10
        val convertedString = amountToExchange * exchangeRate
        onView(withId(R.id.text_area_1)).perform(typeText(amountToExchange.toString()))
        onView(withId(R.id.text_area_2)).check(
            matches(
                withText(
                    String.format(
                        "%.2f",
                        convertedString
                    )
                )
            )
        )
    }
}

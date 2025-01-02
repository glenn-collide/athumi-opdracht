package be.athumi.strategy

import be.athumi.Wine

interface WineYearRateStrategy {

    fun calculatePriceAdjustment (wine: Wine): Int

    fun calculateYearAdjustment(wine: Wine): Int
}
package be.athumi.strategy

import be.athumi.Wine

object FixedWineYearRateStrategy : WineYearRateStrategy {

    override fun calculatePriceAdjustment(wine: Wine): Int {
        return 0
    }

    override fun calculateYearAdjustment(wine: Wine): Int {
        return 0
    }
}
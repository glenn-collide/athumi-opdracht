package be.athumi.strategy

import be.athumi.Wine

abstract class VariableWineYearRateStrategy : WineYearRateStrategy {

    abstract fun calculateVariablePriceAdjustment(wine: Wine): Int

    override fun calculatePriceAdjustment(wine: Wine): Int {
        var calculateVariablePriceAdjustment = calculateVariablePriceAdjustment(wine)

        if (wine.price + calculateVariablePriceAdjustment > 100) {
            calculateVariablePriceAdjustment = 100 - wine.price
        }

        if (wine.price + calculateVariablePriceAdjustment < 0) {
            calculateVariablePriceAdjustment = 0 - wine.price
        }

        return calculateVariablePriceAdjustment
    }

    override fun calculateYearAdjustment(wine: Wine): Int {
        return -1
    }
}
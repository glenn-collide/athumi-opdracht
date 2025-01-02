package be.athumi.strategy

import be.athumi.Wine

object EcoBrewedWineYearRateStrategy : VariableWineYearRateStrategy() {

    override fun calculateVariablePriceAdjustment(wine: Wine): Int {
        return DefaultWineYearRateStrategy.calculateVariablePriceAdjustment(wine) * 2
    }
}
package be.athumi.strategy

import be.athumi.Wine

object ConservatoWineYearRateStrategy : VariableWineYearRateStrategy() {

    override fun calculateVariablePriceAdjustment(wine: Wine): Int {
        return if (wine.expiresInYears < 1) 2 else 1
    }
}
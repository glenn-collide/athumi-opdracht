package be.athumi.strategy

import be.athumi.Wine

object EventWineYearRateStrategy : VariableWineYearRateStrategy() {
    override fun calculateVariablePriceAdjustment(wine: Wine): Int {
        var amount = 1
        if (wine.expiresInYears < 8) amount += 1
        if (wine.expiresInYears < 3) amount += 2
        if (wine.expiresInYears < 1) amount = -wine.price

        return amount
    }
}
package be.athumi

import be.athumi.strategy.ConservatoWineYearRateStrategy
import be.athumi.strategy.DefaultWineYearRateStrategy
import be.athumi.strategy.EcoBrewedWineYearRateStrategy
import be.athumi.strategy.EventWineYearRateStrategy
import be.athumi.strategy.FixedWineYearRateStrategy
import be.athumi.strategy.WineType
import be.athumi.strategy.WineYearRateStrategy

class WineShop(var items: List<Wine>) {

    fun next() {
        for (wine in items) {
            val wineYearRateStrategy = getWineYearRateStrategy(wine)

            val priceAdjustmentAmount = wineYearRateStrategy.calculatePriceAdjustment(wine)
            val yearAdjustmentAmount = wineYearRateStrategy.calculateYearAdjustment(wine)

            wine.price += priceAdjustmentAmount
            wine.expiresInYears += yearAdjustmentAmount
        }
    }

    private fun getWineYearRateStrategy(wine: Wine): WineYearRateStrategy {
        return when (getWineType(wine)) {
            WineType.DEFAULT -> DefaultWineYearRateStrategy
            WineType.CONSERVATO -> ConservatoWineYearRateStrategy
            WineType.EVENT -> EventWineYearRateStrategy
            WineType.ALEXANDER -> FixedWineYearRateStrategy
            WineType.ECO_BRILLIANT -> EcoBrewedWineYearRateStrategy
        }
    }

    private fun getWineType(wine: Wine): WineType {
        return WineType.findByWineName(wine.name) ?: WineType.DEFAULT
    }
}
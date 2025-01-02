package be.athumi

import be.athumi.strategy.ConservatoStrategy
import be.athumi.strategy.DefaultWineStrategy
import be.athumi.strategy.EventWineStrategy

class WineShop(var items: List<Wine>) {

    private val wineStrategies: Map<String, (Wine) -> Unit> = mapOf(
        "Conservato" to { wine: Wine -> ConservatoStrategy.adjust(wine) },
        "Event" to { wine: Wine -> EventWineStrategy.adjust(wine) },
        "Wine brewed by Alexander the Great" to { _ -> }
    )

    fun next() {
        for (wine in items) {
            val calculateNextYear = wineStrategies.entries
                .firstOrNull { wine.name.contains(it.key) }?.value
                ?: { w: Wine -> DefaultWineStrategy.adjust(w) }

            calculateNextYear(wine)

            if (wine.price < 0) {
                wine.price = 0
            }
        }
    }
}
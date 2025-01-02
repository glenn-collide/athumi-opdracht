package be.athumi.strategy

import be.athumi.Wine

object EcoBrewedStrategy {

    fun adjust(wine: Wine) {
        if (wine.price > 0) wine.price -= 2
        wine.expiresInYears -= 1
        if (wine.expiresInYears < 0) wine.price -=2
    }
}
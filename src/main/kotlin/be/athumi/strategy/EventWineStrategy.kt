package be.athumi.strategy

import be.athumi.Wine

object EventWineStrategy {

    fun adjust(wine: Wine) {
        if (wine.expiresInYears < 8) wine.price += 1
        if (wine.expiresInYears < 3) wine.price += 2
        wine.expiresInYears -= 1
        wine.price += 1
        if (wine.expiresInYears < 0) wine.price = 0
        if (wine.price > 100) wine.price = 100
    }
}
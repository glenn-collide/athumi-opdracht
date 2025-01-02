package be.athumi.strategy

import be.athumi.Wine

object DefaultWineStrategy {

    fun adjust(wine: Wine) {
        if (wine.price > 0) wine.price -= 1
        wine.expiresInYears -= 1
        if (wine.expiresInYears < 0) wine.price -=1
    }
}
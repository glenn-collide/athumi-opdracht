package be.athumi.strategy

import be.athumi.Wine

object ConservatoStrategy  {

    fun adjust(wine: Wine) {
        if (wine.price < 100) wine.price += 1
        wine.expiresInYears -= 1
        if (wine.expiresInYears < 0) wine.price +=1
    }
}
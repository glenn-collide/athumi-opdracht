package be.athumi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WineShopThreeYearSimulationTest {

    @Test
    fun `Simulate 3 years for various wines`() {
        // Initial setup for the wines
        val wines = mutableListOf(
            Wine(name = "Standard Wine", price = 20, expiresInYears = 10),
            Wine(name = "Bourdeaux Conservato", price = 0, expiresInYears = 2),
            Wine(name = "Another Standard Wine", price = 7, expiresInYears = 5),
            Wine(name = "Wine brewed by Alexander the Great", price = 150, expiresInYears = 0),
            Wine(name = "Wine brewed by Alexander the Great", price = 80, expiresInYears = 10),
            Wine(name = "Event Wine", price = 20, expiresInYears = 15),
            Wine(name = "Event Wine", price = 49, expiresInYears = 10),
            Wine(name = "Event Wine", price = 49, expiresInYears = 5),
            Wine(name = "Eco Brilliant Wine", price = 6, expiresInYears = 3)
        )

        val shop = WineShop(wines)

        // Simulate 3 years
        repeat(3) {
            shop.next()
        }

        // Expected results after 3 years
        val expectedWines = listOf(
            Wine(name = "Standard Wine", price = 17, expiresInYears = 7),
            Wine(name = "Bourdeaux Conservato", price = 4, expiresInYears = -1),
            Wine(name = "Another Standard Wine", price = 4, expiresInYears = 2),
            Wine(name = "Wine brewed by Alexander the Great", price = 150, expiresInYears = 0),
            Wine(name = "Wine brewed by Alexander the Great", price = 80, expiresInYears = 10),
            Wine(name = "Event Wine", price = 23, expiresInYears = 12),
            Wine(name = "Event Wine", price = 52, expiresInYears = 7),
            Wine(name = "Event Wine", price = 55, expiresInYears = 2),
            Wine(name = "Eco Brilliant Wine", price = 3, expiresInYears = 0)
        )

        // Assertions for each wine
        for (i in wines.indices) {
            assertEquals(expectedWines[i].price, wines[i].price, "Price mismatch for wine at index $i")
            assertEquals(expectedWines[i].expiresInYears, wines[i].expiresInYears, "Expiration mismatch for wine at index $i")
        }
    }
}
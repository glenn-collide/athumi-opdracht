package be.athumi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WineShopTest {

    @Test
    fun `Standard wine price and expiration decrease`() {
        val wine = Wine(name = "Standard Wine", price = 10, expiresInYears = 5)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertEquals(4, wine.expiresInYears)
        assertEquals(9, wine.price)
    }

    @Test
    fun `Standard wine price degrades twice as fast after expiration`() {
        val wine = Wine(name = "Standard Wine", price = 10, expiresInYears = 0)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertEquals(-1, wine.expiresInYears)
        assertEquals(8, wine.price)
    }

    @Test
    fun `Price never goes negative`() {
        val wine = Wine(name = "Standard Wine", price = 1, expiresInYears = 0)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertEquals(0, wine.price)
    }

    @Test
    fun `Price can not be negative`() {
        val wine = Wine(name = "Standard Wine", price = -1, expiresInYears = 0)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertEquals(0, wine.price)
    }

    @Test
    fun `Bourgogne Conservato wine price increases over time`() {
        val wine = Wine(name = "Bourgogne Conservato", price = 20, expiresInYears = 10)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertEquals(21, wine.price)
    }

    @Test
    fun `Bourgogne Conservato wine price increases twice as fast after expiration`() {
        val wine = Wine(name = "Bourgogne Conservato", price = 20, expiresInYears = 0)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertEquals(22, wine.price)
    }

    @Test
    fun `Price never exceeds 100 for cellar wine already 100`() {
        val wine = Wine(name = "Bourgogne Conservato", price = 100, expiresInYears = 10)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertEquals(100, wine.price)
    }

    @Test
    fun `Alexander wine does not change price or expire`() {
        val wine = Wine(name = "Wine brewed by Alexander the Great", price = 80, expiresInYears = 10)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertEquals(10, wine.expiresInYears)
        assertEquals(80, wine.price)
    }

    @Test
    fun `Event wine price increases by 1 before 7 years`() {
        val wine = Wine(name = "Event Wine", price = 30, expiresInYears = 8)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertEquals(7, wine.expiresInYears)
        assertEquals(31, wine.price)
    }

    @Test
    fun `Event wine price increases by 2 when 7 years or less remain`() {
        val wine = Wine(name = "Event Wine", price = 30, expiresInYears = 7)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertEquals(6, wine.expiresInYears)
        assertEquals(32, wine.price)
    }

    @Test
    fun `Event wine price increases to 100 when 7 years or less remain but price was 99`() {
        val wine = Wine(name = "Event Wine", price = 99, expiresInYears = 7)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertEquals(6, wine.expiresInYears)
        assertEquals(100, wine.price)
    }

    @Test
    fun `Event wine price increases by 4 when 2 years or less remain`() {
        val wine = Wine(name = "Event Wine", price = 30, expiresInYears = 2)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertEquals(1, wine.expiresInYears)
        assertEquals(34, wine.price)
    }

    @Test
    fun `Event wine price increases to 100 when 2 years or less remain but price was 97`() {
        val wine = Wine(name = "Event Wine", price = 97, expiresInYears = 2)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertEquals(1, wine.expiresInYears)
        assertEquals(100, wine.price)
    }

    @Test
    fun `Event wine price increases to 100 when 2 years or less remain but price was 98`() {
        val wine = Wine(name = "Event Wine", price = 98, expiresInYears = 2)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertEquals(1, wine.expiresInYears)
        assertEquals(100, wine.price)
    }

    @Test
    fun `Event wine price drops to zero after expiration`() {
        val wine = Wine(name = "Event Wine", price = 30, expiresInYears = 0)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertEquals(-1, wine.expiresInYears)
        assertEquals(0, wine.price)
    }

    //   TODO:Implement Eco Brilliant Wine logic
    @Test
    fun `Eco Brilliant Wine degrades twice as fast after expiration`() {
        val wine = Wine(name = "Eco Brilliant Wine", price = 20, expiresInYears = 0)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertEquals(-1, wine.expiresInYears)
        assertEquals(16, wine.price)
    }

    //   TODO:Implement Eco Brilliant Wine logic
    @Test
    fun `Eco Brilliant Wine degrades twice as fast`() {
        val wine = Wine(name = "Eco Brilliant Wine", price = 20, expiresInYears = 5)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertEquals(4, wine.expiresInYears)
        assertEquals(18, wine.price)
    }
}
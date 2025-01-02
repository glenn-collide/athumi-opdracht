package be.athumi.strategy

enum class WineType(val wineName: String) {
    DEFAULT("default"),
    CONSERVATO("Conservato"),
    EVENT("Event"),
    ALEXANDER("Wine brewed by Alexander the Great"),
    ECO_BRILLIANT("Eco Brilliant Wine");

    companion object {
        fun findByWineName(wineName: String): WineType? {
            return entries.find { wineName.contains(it.wineName) }
        }
    }
}
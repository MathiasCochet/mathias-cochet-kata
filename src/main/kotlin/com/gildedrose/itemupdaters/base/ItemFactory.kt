package com.gildedrose.itemupdaters.base

object ItemFactory {
    private const val AGED_BRIE = "Aged Brie"
    private const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
    private const val SULFURAS = "Sulfuras, Hand of Ragnaros"
    private const val CONJURED = "Conjured Mana Cake"

    val agedItems = setOf(AGED_BRIE)
    val eventItems = setOf(BACKSTAGE_PASSES)
    val immutableItems = setOf(SULFURAS)
    val dwindlingItems = setOf(CONJURED)
}
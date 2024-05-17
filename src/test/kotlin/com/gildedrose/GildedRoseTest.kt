package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {
    //This is a simplified golden master test because I'm also going to be adding item specific tests And i will also be using the texttest.
    @Test
    fun `Simplified golden master test`() {
        val items: List<Item> = listOf(
            Item("+5 Dexterity Vest", 10, 20),
            Item("Aged Brie", 2, 0),
            Item("Elixir of the Mongoose", 5, 7),
            Item("Sulfuras, Hand of Ragnaros", 0, 80),
            Item("Sulfuras, Hand of Ragnaros", -1, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            Item("Conjured Mana Cake", 3, 6)
        )

        val gildedRoseApplication = GildedRose(items)

        repeat(5) {
            gildedRoseApplication.updateQuality()
        }

        assertEquals("+5 Dexterity Vest", items[0].name)
        assertEquals(5, items[0].sellIn)
        assertEquals(15, items[0].quality)

        assertEquals("Aged Brie", items[1].name)
        assertEquals(-3, items[1].sellIn)
        assertEquals(8, items[1].quality)

        assertEquals("Elixir of the Mongoose", items[2].name)
        assertEquals(0, items[2].sellIn)
        assertEquals(2, items[2].quality)

        assertEquals("Sulfuras, Hand of Ragnaros", items[3].name)
        assertEquals(0, items[3].sellIn)
        assertEquals(80, items[3].quality)

        assertEquals("Sulfuras, Hand of Ragnaros", items[4].name)
        assertEquals(-1, items[4].sellIn)
        assertEquals(80, items[4].quality)

        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[5].name)
        assertEquals(10, items[5].sellIn)
        assertEquals(25, items[5].quality)

        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[6].name)
        assertEquals(5, items[6].sellIn)
        assertEquals(50, items[6].quality)

        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[7].name)
        assertEquals(0, items[7].sellIn)
        assertEquals(50, items[7].quality)

        assertEquals("Conjured Mana Cake", items[8].name)
        assertEquals(-2, items[8].sellIn)
        assertEquals(0, items[8].quality)
    }
}



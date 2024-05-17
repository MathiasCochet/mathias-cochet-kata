package com.gildedrose.itemupdaters

import com.gildedrose.Item
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DefaultItemUpdaterTest {

    private lateinit var defaultItemUpdater: DefaultItemUpdater

    private val defaultItemName = "+5 Dexterity Vest"
    private val defaultItem = Item(defaultItemName, 10, 10)

    @BeforeEach
    fun setup() {
        defaultItemUpdater = DefaultItemUpdater()
    }

    @Test
    fun `When updateItem is called for a default item the sellin value and quality value decrease by one as long as the sellin value is positive`() {
        defaultItemUpdater.updateItem(defaultItem)

        assertEquals(9, defaultItem.sellIn)
        assertEquals(9, defaultItem.quality)
    }

    @Test
    fun `When updateItem is called for a default item with a negative sellIn value the quality value should decrease by 2`() {
        val item = Item(defaultItemName, -2, 10)

        defaultItemUpdater.updateItem(item)

        assertEquals(8, item.quality)
    }

    @Test
    fun `When updateItem is called for a default item the quality value should decrease up until a quality value of 0 is reached`() {
        val item = Item(defaultItemName, 10, 0)

        defaultItemUpdater.updateItem(item)

        assertEquals(0, item.quality)
    }

    @Test
    fun `When updateItem is called for a default item that is past its sellIn deadline the quality value should decrease up until a quality value of 0 is reached`() {
        val item = Item(defaultItemName, -1, 1)

        defaultItemUpdater.updateItem(item)

        assertEquals(0, item.quality)
    }

    @Test
    fun `Test passing the sellIn deadline`() {
        val item = Item(defaultItemName, 2, 10)

        defaultItemUpdater.updateItem(item)

        assertEquals(1, item.sellIn)
        assertEquals(9, item.quality)

        defaultItemUpdater.updateItem(item)

        assertEquals(0, item.sellIn)
        assertEquals(8, item.quality)

        defaultItemUpdater.updateItem(item)

        assertEquals(-1, item.sellIn)
        assertEquals(6, item.quality)
    }
}
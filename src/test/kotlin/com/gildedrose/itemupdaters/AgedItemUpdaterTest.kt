package com.gildedrose.itemupdaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.base.ItemFactory.AGED_BRIE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AgedItemUpdaterTest {

    private lateinit var agedItemUpdater: AgedItemUpdater
    private val agedItem = Item(AGED_BRIE, 10, 10)

    @BeforeEach
    fun setUp() {
        agedItemUpdater = AgedItemUpdater()
    }


    @Test
    fun `When updateItem is called for an aged item the sellin value should decrease and quality value should increase by one`() {
        agedItemUpdater.updateItem(agedItem)

        assertEquals(9, agedItem.sellIn)
        assertEquals(11, agedItem.quality)
    }

    @Test
    fun `When updateItem is called for an aged item with a negative sellIn value the quality value should increase by 2`() {
        val item = Item(AGED_BRIE, -2, 10)

        agedItemUpdater.updateItem(item)

        assertEquals(12, item.quality)
    }

    @Test
    fun `When updateItem is called for an aged item the quality value should increase by 2 up until a quality value of 50 is reached`() {
        val item = Item(AGED_BRIE, -2, 49)

        agedItemUpdater.updateItem(item)

        assertEquals(50, item.quality)
    }

    @Test
    fun `When updateItem is called for an aged item the quality value should increase by 1 up until a quality value of 50 is reached`() {
        val item = Item(AGED_BRIE, 10, 49)

        agedItemUpdater.updateItem(item)

        assertEquals(50, item.quality)
    }
}
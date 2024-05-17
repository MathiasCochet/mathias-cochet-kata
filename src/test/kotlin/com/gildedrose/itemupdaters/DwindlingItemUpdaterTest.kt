package com.gildedrose.itemupdaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.base.ItemFactory.CONJURED
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DwindlingItemUpdaterTest {

    private lateinit var dwindlingItemUpdater: DwindlingItemUpdater

    private val dwindlingItem = Item(CONJURED, 10, 10)

    @BeforeEach
    fun setUp() {
        dwindlingItemUpdater = DwindlingItemUpdater()
    }

    @Test
    fun `When updateItem is called for a dwindling item the sellIn value should decrease by 1 and the quality value should decrease by 2`() {
        dwindlingItemUpdater.updateItem(dwindlingItem)

        Assertions.assertEquals(8, dwindlingItem.quality)
        Assertions.assertEquals(9, dwindlingItem.sellIn)
    }

    @Test
    fun `When updateItem is called for a dwindling item the quality value should decrease up until a quality value of 0 is reached`() {
        val item = Item(CONJURED, 10, 0)

        dwindlingItemUpdater.updateItem(item)

        Assertions.assertEquals(0, item.quality)
    }

    @Test
    fun `When updateItem is called for a dwindling item the quality value should decrease up until a quality value of 0 is reached, even when decrease amount is less then 2`() {
        val item = Item(CONJURED, -1, 1)

        dwindlingItemUpdater.updateItem(item)

        Assertions.assertEquals(0, item.quality)
    }
}
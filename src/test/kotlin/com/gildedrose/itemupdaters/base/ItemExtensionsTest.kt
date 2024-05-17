package com.gildedrose.itemupdaters.base

import com.gildedrose.Item
import com.gildedrose.itemupdaters.*
import com.gildedrose.itemupdaters.base.ItemFactory.AGED_BRIE
import com.gildedrose.itemupdaters.base.ItemFactory.BACKSTAGE_PASSES
import com.gildedrose.itemupdaters.base.ItemFactory.CONJURED
import com.gildedrose.itemupdaters.base.ItemFactory.SULFURAS
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ItemExtensionsTest {

    @Test
    fun `When an item is Aged brie the AgedItemUpdater should be returned`() {
        val item = Item(AGED_BRIE, 10, 10)

        val itemUpdater = item.getItemUpdater()

        assertTrue(itemUpdater is AgedItemUpdater)
    }

    @Test
    fun `When an item is a Backstage pass the EventItemUpdater should be returned`() {
        val item = Item(BACKSTAGE_PASSES, 10, 10)

        val itemUpdater = item.getItemUpdater()

        assertTrue(itemUpdater is EventItemUpdater)
    }

    @Test
    fun `When an item is Sulfuras the ImmutableUpdater should be returned`() {
        val item = Item(SULFURAS, 10, 10)

        val itemUpdater = item.getItemUpdater()

        assertTrue(itemUpdater is ImmutableItemUpdater)
    }

    @Test
    fun `When an item is a Conjured item the DwindlingItemUpdater should be returned`() {
        val item = Item(CONJURED, 10, 10)

        val itemUpdater = item.getItemUpdater()

        assertTrue(itemUpdater is DwindlingItemUpdater)
    }

    @Test
    fun `When an item is an unknown item the DefaultItemUpdater should be returned`() {
        val item = Item("+5 Dexterity Vest", 10, 10)

        val itemUpdater = item.getItemUpdater()

        assertTrue(itemUpdater is DefaultItemUpdater)
    }

}
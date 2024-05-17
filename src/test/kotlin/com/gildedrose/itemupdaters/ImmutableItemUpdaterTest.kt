package com.gildedrose.itemupdaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.base.ItemFactory.SULFURAS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ImmutableItemUpdaterTest {

    private lateinit var immutableItemUpdater: ImmutableItemUpdater

    @BeforeEach
    fun setUp() {
        immutableItemUpdater = ImmutableItemUpdater()
    }

    @Test
    fun `When updateItem is called for a immutableItem the sellIn and quality should not change`() {
        val item = Item(SULFURAS, 10, 80)

        immutableItemUpdater.updateItem(item)

        assertEquals(10, item.sellIn)
        assertEquals(80, item.quality)
    }
}
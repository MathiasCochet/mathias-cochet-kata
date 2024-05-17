package com.gildedrose.itemupdaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.base.ItemFactory.BACKSTAGE_PASSES
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class EventItemUpdaterTest {
    private lateinit var eventItemUpdater: EventItemUpdater

    @BeforeEach
    fun setUp() {
        eventItemUpdater = EventItemUpdater()
    }

    @Test
    fun `When updateItem is called for an event item and the sellIn value is above 10 days the quality value should increase by 1`() {
        val item = Item(BACKSTAGE_PASSES, 11, 10)

        eventItemUpdater.updateItem(item)

        assertEquals(11, item.quality)
        assertEquals(10, item.sellIn)
    }

    @Test
    fun `When updateItem is called for an event item and the sellIn value is within 10 days the quality value should increase by 2`() {
        val item = Item(BACKSTAGE_PASSES, 11, 10)

        eventItemUpdater.updateItem(item)

        assertEquals(11, item.quality)

        eventItemUpdater.updateItem(item)

        assertEquals(13, item.quality)
    }

    @Test
    fun `When updateItem is called for an event item and the sellIn value is within 5 days the quality value should increase by 3`() {
        val item = Item(BACKSTAGE_PASSES, 6, 10)

        eventItemUpdater.updateItem(item)

        assertEquals(12, item.quality)

        eventItemUpdater.updateItem(item)

        assertEquals(15, item.quality)
    }

    @Test
    fun `When updateItem is called for an event item and the sellIn value is below 0 the quality value should be 0`() {
        val item = Item(BACKSTAGE_PASSES, 1, 10)

        eventItemUpdater.updateItem(item)

        assertEquals(0, item.sellIn)
        assertEquals(13, item.quality)

        eventItemUpdater.updateItem(item)

        assertEquals(-1, item.sellIn)
        assertEquals(0, item.quality)
    }

    @Test
    fun `When updateItem is called for an event item and the and the sellIn value is above 10 days should not increase above 50`() {
        val item = Item(BACKSTAGE_PASSES, 11, 50)

        eventItemUpdater.updateItem(item)

        assertEquals(50, item.quality)
    }

    @Test
    fun `When updateItem is called for an event item and the and the sellIn value is within 10 days should not increase above 50`() {
        val item = Item(BACKSTAGE_PASSES, 9, 49)

        eventItemUpdater.updateItem(item)

        assertEquals(50, item.quality)
    }

    @Test
    fun `When updateItem is called for an event item and the and the sellIn value is within 5 days should not increase above 50`() {
        val item = Item(BACKSTAGE_PASSES, 4, 49)

        eventItemUpdater.updateItem(item)

        assertEquals(50, item.quality)
    }
}
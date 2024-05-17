package com.gildedrose.itemupdaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.base.BaseItemUpdater

class EventItemUpdater : BaseItemUpdater() {

    companion object {
        private val eventVeryNearRange = IntRange(0, 4)
        private val eventNearRange = IntRange(5, 9)

        private const val NORMAL_INCREMENT = 1
        private const val EVENT_NEAR_INCREMENT = 2
        private const val EVENT_VERY_NEAR_INCREMENT = 3
    }

    override fun updateItem(item: Item) {
        super.updateItem(item)

        item.apply {
            quality = getIncrementValue(sellIn)
                ?.let { minOf(quality + it, MAXIMUM_QUALITY_VALUE) }
                ?: MINIMUM_QUALITY_VALUE
        }

    }

    private fun getIncrementValue(sellin: Int): Int? {
        if (sellin < SELLIN_EXPIRY) return null;

        return when (sellin) {
            in eventVeryNearRange -> EVENT_VERY_NEAR_INCREMENT
            in eventNearRange -> EVENT_NEAR_INCREMENT
            else -> NORMAL_INCREMENT
        }
    }
}
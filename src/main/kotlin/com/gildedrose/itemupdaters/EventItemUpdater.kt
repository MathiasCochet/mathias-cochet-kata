package com.gildedrose.itemupdaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.base.BaseItemUpdater

class EventItemUpdater : BaseItemUpdater() {

    companion object {
        private const val EVENT_NEAR = 10
        private const val EVENT_VERY_NEAR = 5

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
        if (sellin < 0) return null;

        return when {
            sellin < EVENT_VERY_NEAR -> EVENT_VERY_NEAR_INCREMENT
            sellin < EVENT_NEAR -> EVENT_NEAR_INCREMENT
            else -> NORMAL_INCREMENT
        }
    }
}
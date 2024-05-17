package com.gildedrose.itemupdaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.base.BaseItemUpdater

class DefaultItemUpdater : BaseItemUpdater() {

    companion object {
        private const val NORMAL_DECREMENT = 1
        private const val EXPIRED_DECREMENT = 2
    }

    override fun updateItem(item: Item) {
        super.updateItem(item)

        item.apply {
            quality = maxOf(
                quality - getDecrementValue(sellIn),
                MINIMUM_QUALITY_VALUE,
            )
        }
    }

    private fun getDecrementValue(sellin: Int): Int {
        return if (sellin >= 0) NORMAL_DECREMENT else EXPIRED_DECREMENT
    }
}
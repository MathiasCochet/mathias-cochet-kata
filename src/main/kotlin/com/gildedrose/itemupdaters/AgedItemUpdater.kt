package com.gildedrose.itemupdaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.base.BaseItemUpdater

class AgedItemUpdater : BaseItemUpdater() {

    companion object {
        private const val NORMAL_INCREMENT = 1
        private const val EXPIRED_INCREMENT = 2
    }

    override fun updateItem(item: Item) {
        super.updateItem(item)

        item.apply {
            quality = minOf(
                quality + getIncrementValue(sellIn),
                MAXIMUM_QUALITY_VALUE,
            )
        }
    }

    private fun getIncrementValue(sellin: Int): Int {
        return if (sellin >= 0) NORMAL_INCREMENT else EXPIRED_INCREMENT
    }
}
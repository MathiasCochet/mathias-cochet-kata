package com.gildedrose.itemupdaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.base.BaseItemUpdater

class DwindlingItemUpdater : BaseItemUpdater() {

    companion object {
        private const val NORMAL_DECREMENT = 2
    }

    override fun updateItem(item: Item) {
        super.updateItem(item)

        item.apply {
            quality = maxOf(quality - NORMAL_DECREMENT, MINIMUM_QUALITY_VALUE)
        }

    }
}
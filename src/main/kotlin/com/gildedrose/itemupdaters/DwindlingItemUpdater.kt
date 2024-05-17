package com.gildedrose.itemupdaters

import com.gildedrose.Item
import com.gildedrose.itemupdaters.base.BaseItemUpdater

class DwindlingItemUpdater : BaseItemUpdater() {

    override fun updateItem(item: Item) {
        super.updateItem(item)

        item.apply {
            quality = maxOf(quality - 2, MINIMUM_QUALITY_VALUE)
        }

    }
}
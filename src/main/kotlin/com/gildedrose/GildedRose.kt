package com.gildedrose

import com.gildedrose.itemupdaters.base.getItemUpdater

class GildedRose(private var items: List<Item>) {

    fun updateQuality() = items.forEach { item ->
        val itemUpdater = item.getItemUpdater()
        itemUpdater.updateItem(item)
    }
}


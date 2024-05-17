package com.gildedrose.itemupdaters.base

import com.gildedrose.Item
import com.gildedrose.itemupdaters.DefaultItemUpdater

fun Item.getItemUpdater(): ItemUpdater {
    return DefaultItemUpdater() // TODO add item updater selector.
}
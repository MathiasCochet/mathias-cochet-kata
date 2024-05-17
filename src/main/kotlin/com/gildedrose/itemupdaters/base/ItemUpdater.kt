package com.gildedrose.itemupdaters.base

import com.gildedrose.Item

interface ItemUpdater {
    fun updateItem(item: Item)
}

abstract class BaseItemUpdater: ItemUpdater {

    internal companion object {
        private const val SELLIN_UPDATE_INTERVAL = -1
    }

    override fun updateItem(item: Item) {
        decreaseSellInValue(item)
    }

    private fun decreaseSellInValue(item: Item) {
        item.sellIn += SELLIN_UPDATE_INTERVAL
    }
}
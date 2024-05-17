package com.gildedrose.itemupdaters.base

import com.gildedrose.Item
import com.gildedrose.itemupdaters.*
import com.gildedrose.itemupdaters.base.ItemFactory.agedItems
import com.gildedrose.itemupdaters.base.ItemFactory.dwindlingItems
import com.gildedrose.itemupdaters.base.ItemFactory.eventItems
import com.gildedrose.itemupdaters.base.ItemFactory.immutableItems

fun Item.getItemUpdater(): ItemUpdater = when {
    agedItems.contains(this.name) -> AgedItemUpdater()
    eventItems.contains(this.name) -> EventItemUpdater()
    immutableItems.contains(this.name) -> ImmutableItemUpdater()
    dwindlingItems.contains(this.name) -> DwindlingItemUpdater()
    else -> DefaultItemUpdater()
}

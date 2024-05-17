package com.gildedrose

import com.gildedrose.itemupdaters.AgedItemUpdater
import com.gildedrose.itemupdaters.DefaultItemUpdater
import com.gildedrose.itemupdaters.DwindlingItemUpdater
import com.gildedrose.itemupdaters.base.ItemUpdater
import com.gildedrose.itemupdaters.base.getItemUpdater

class GildedRose(private var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            val item = items[i]
            val itemUpdater: ItemUpdater = item.getItemUpdater()

            if (itemUpdater is DefaultItemUpdater
                || itemUpdater is AgedItemUpdater
                || itemUpdater is DwindlingItemUpdater
            ) {
                itemUpdater.updateItem(item)
            } else {
                //Legacy code
                if (items[i].name != "Aged Brie" && items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                    if (items[i].quality > 0) {
                        if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                            items[i].quality = items[i].quality - 1
                        }
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1

                        if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                            if (items[i].sellIn < 11) {
                                if (items[i].quality < 50) {
                                    items[i].quality = items[i].quality + 1
                                }
                            }

                            if (items[i].sellIn < 6) {
                                if (items[i].quality < 50) {
                                    items[i].quality = items[i].quality + 1
                                }
                            }
                        }
                    }
                }

                if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                    items[i].sellIn = items[i].sellIn - 1
                }

                if (items[i].sellIn < 0) {
                    if (items[i].name != "Aged Brie") {
                        if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                            if (items[i].quality > 0) {
                                if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                                    items[i].quality = items[i].quality - 1
                                }
                            }
                        } else {
                            items[i].quality = items[i].quality - items[i].quality
                        }
                    } else {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1
                        }
                    }
                }
            }
        }
    }

}


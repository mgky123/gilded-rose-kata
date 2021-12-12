package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            String itemname = items[i].name;
            int quality = items[i].quality;

            if (itemname.equals(AGED_BRIE)) {
                if (quality < 50) {
                    items[i].quality = items[i].quality + 1;
                }
            } else if (itemname.equals(BACKSTAGE_PASSES)) {
                items[i].quality = items[i].quality + 1;

                if (items[i].sellIn < 11) {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }

                if (items[i].sellIn < 6) {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            } else {
                if (items[i].quality > 0) {
                    if (itemname.equals(SULFURAS)) {
                    } else {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            }

            if (!itemname.equals(SULFURAS)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (itemname.equals(AGED_BRIE)) {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                } else if (itemname.equals(BACKSTAGE_PASSES)) {
                    items[i].quality = items[i].quality - items[i].quality;
                } else if (items[i].quality > 0) {
                    if (itemname.equals(SULFURAS)) {
                        continue;
                    }
                    items[i].quality = items[i].quality - 1;
                }
            }
        }
    }
}

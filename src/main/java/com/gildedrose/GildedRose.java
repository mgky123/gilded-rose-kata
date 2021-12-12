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
        calcQuality();
        calcSellIn();
    }

    private void calcQuality() {
        for (Item item : items) {
            if (isAgedBrie(item)) {
                calcAgedBrie(item);
            } else if (isBackstagePasses(item)) {
                clacBackstagePasses(item);
            } else if (isSulfuras(item)) {
                clacSulfuras();
            } else {
                calcNormalItem(item);
            }
        }
    }

    private void calcSellIn() {
        for (Item item : items) {
            if (!isSulfuras(item)) {
                item.sellIn = item.sellIn - 1;
            }
        }
    }


    private void calcNormalItem(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        if (item.sellIn < 1) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }

    private void clacSulfuras() {
        // Sulfuras is Epic so do nothing
    }

    private void clacBackstagePasses(Item item) {
        item.quality = item.quality + 1;

        if (item.sellIn < 11) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }

        if (item.sellIn < 6) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }

        if (item.sellIn < 1) {
            item.quality = item.quality - item.quality;
        }
    }

    private void calcAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        if (item.sellIn < 1) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals(SULFURAS);
    }

    private boolean isBackstagePasses(Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }
}

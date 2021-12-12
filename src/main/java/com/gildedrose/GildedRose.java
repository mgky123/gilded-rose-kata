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
                new AgedBrieItem(item).updateQuality();
            } else if (isBackstagePasses(item)) {
                new BackstagePassesItem(item).updateQuality();
            } else if (isSulfuras(item)) {
                new SulfurasItem(item).updateQuality();
            } else {
                new NormalItem(item).updateQuality();
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

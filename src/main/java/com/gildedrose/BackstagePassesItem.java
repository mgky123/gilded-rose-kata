package com.gildedrose;

public class BackstagePassesItem {
    private Item item;

    protected BackstagePassesItem(Item item){
        this.item = item;
    }

    protected void updateQuality(){
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
}

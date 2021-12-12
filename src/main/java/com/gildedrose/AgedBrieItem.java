package com.gildedrose;

public class AgedBrieItem {
    private Item item;

    protected AgedBrieItem(Item item){
        this.item = item;
    }

    protected void updateQuality(){
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        if (item.sellIn < 1) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }
}

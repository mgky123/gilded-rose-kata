package com.gildedrose;

public class NormalItem {
    protected Item item;

    protected NormalItem(Item item){
        this.item = item;
    }

    protected void updateQuality(){
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        if (item.sellIn < 1) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }
}

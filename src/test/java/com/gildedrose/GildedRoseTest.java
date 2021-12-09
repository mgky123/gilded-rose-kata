package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void NormalItem_ZeroBase() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void AgedBrieItem_ZeroBase() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(2, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void AgedBrieItem_MaxQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void AgedBrieItem_OutdatedItemMaxQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void BackstagePassesItem_ZeroBase() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void BackstagePassesItem_MoreThanElevenDays() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(11, app.items[0].quality);
        assertEquals(11, app.items[0].sellIn);
    }

    @Test
    void BackstagePassesItem_LessThanElevenDaysMaxValue() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void BackstagePassesItem_LessThanSixDaysMaxValue() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void SulfurasItem_ZeroBase() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void SulfurasItem_QualityOnly() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(10, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void SulfurasItem_OutdatedItem() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(10, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void NormalItem_NormalCase() {
        Item[] items = new Item[] { new Item("Normal", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void NormalItem_OutdatedItem() {
        Item[] items = new Item[] { new Item("Normal", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(8, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void ItemFunctionToString() {
        Item[] items = new Item[] { new Item("Normal", 0, 10) };
        GildedRose app = new GildedRose(items);

        assertEquals("Normal, 0, 10",app.items[0].toString());
    }
}

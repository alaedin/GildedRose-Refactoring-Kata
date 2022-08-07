package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.lambda.utils.Range;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GildedRoseTest {

    private String NORMAL;
    private String BRIE;
    private String BACKSTAGE;
    private String SULFURAS;

    @BeforeAll
    void init() {
        NORMAL = "foo";
        BRIE = "Aged Brie";
        BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
        SULFURAS = "Sulfuras, Hand of Ragnaros";
    }

    @Test
    void updateQuality() {
        Integer[] sellInRange = Range.get(-1, 11);
        Integer[] qualityRange = Range.get(0, 50);
        String[] names = {NORMAL, BRIE, BACKSTAGE, SULFURAS,};

        CombinationApprovals.verifyAllCombinations(
            this::doUpdateQuality,
            names,
            sellInRange,
            qualityRange);
    }

    private Item doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        return gildedRose.items[0];
    }

}

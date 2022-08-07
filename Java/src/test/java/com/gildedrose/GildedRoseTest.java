package com.gildedrose;

import com.gildedrose.entity.Item;
import com.gildedrose.utils.ConstantUtils;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.lambda.utils.Range;

import static org.apache.commons.lang3.math.NumberUtils.BYTE_MINUS_ONE;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GildedRoseTest implements ConstantUtils {



    @Test
    void updateQuality() {
        Integer[] sellInRange = Range.get(BYTE_MINUS_ONE, MAX_REMINING_DAYS);
        Integer[] qualityRange = Range.get(ZERO, MAX_QUALITY);
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

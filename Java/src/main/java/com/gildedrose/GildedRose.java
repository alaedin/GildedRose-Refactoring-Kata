package com.gildedrose;

import static com.gildedrose.utils.ConstantUtils.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case BRIE:
                    updateBrie(item);
                    continue;
                case BACKSTAGE:
                    updateBackstage(item);
                    continue;
                case SULFURAS:
                    continue;
                default:
                    updateNormal(item);
            }
        }
    }

    public void updateBrie(Item item) {
        if (isQualityLessThan(item, MAX_QUALITY)) {
            increaseQuality(item);
        }

        increaseSellIn(item);

        if (isSellInLessThan(item, ZERO) && isQualityLessThan(item, MAX_QUALITY)) {
            increaseQuality(item);
        }
    }

    public void updateBackstage(Item item) {
        if (isQualityLessThan(item, MAX_QUALITY)) {
            increaseQuality(item);

            if (isSellInAndQualityLessThan(item, MAX_REMINING_DAYS, MAX_QUALITY)) {
                increaseQuality(item);
            }

            if (isSellInLessThan(item, MIN_REMINING_DAYS) && isQualityLessThan(item, MAX_QUALITY)) {
                increaseQuality(item);
            }
        }

        increaseSellIn(item);

        if (isSellInLessThan(item, ZERO)) {
            item.quality = ZERO;
        }

    }

    public void updateSulfuras(Item item) {

    }

    public void updateNormal(Item item) {

        if (isQualityBiggerThan(item, ZERO)) {
            decreaseQuality(item);

        }

        increaseSellIn(item);

        if (isSellInLessThan(item, ZERO) && isQualityBiggerThan(item, ZERO)) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        item.quality--;
    }

    private boolean isQualityBiggerThan(Item item, int quality) {
        return item.quality > quality;
    }

    private void increaseSellIn(Item item) {
        item.sellIn--;
    }

    private void increaseQuality(Item item) {
        item.quality++;
    }

    private boolean isSellInAndQualityLessThan(Item item, int sellIn, int quality) {
        return isSellInLessThan(item, sellIn) && isQualityLessThan(item, quality);
    }

    private boolean isQualityLessThan(Item item, int quality) {
        return item.quality < quality;
    }

    private boolean isSellInLessThan(Item item, int sellIn) {
        return item.sellIn < sellIn;
    }

}

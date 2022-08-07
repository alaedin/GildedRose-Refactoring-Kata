package com.gildedrose.entity;

public class Brie extends Item {
    public Brie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        if (isQualityLessThan(MAX_QUALITY)) {
            increaseQuality();
        }

        increaseSellIn();

        if (isSellInLessThan(ZERO) && isQualityLessThan(MAX_QUALITY)) {
            increaseQuality();
        }
    }
}

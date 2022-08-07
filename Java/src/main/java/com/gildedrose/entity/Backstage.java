package com.gildedrose.entity;

public class Backstage extends Item {
    public Backstage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        if (isQualityLessThan(MAX_QUALITY)) {
            increaseQuality();

            if (isSellInAndQualityLessThan(MAX_REMINING_DAYS, MAX_QUALITY)) {
                increaseQuality();
            }

            if (isSellInLessThan(MIN_REMINING_DAYS) && isQualityLessThan(MAX_QUALITY)) {
                increaseQuality();
            }
        }

        increaseSellIn();

        if (isSellInLessThan(ZERO)) {
            resetQuality();
        }

    }
}

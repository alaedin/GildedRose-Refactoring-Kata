package com.gildedrose.entity;

public class Normal extends Item {
    public Normal(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {

        if (isQualityBiggerThan(ZERO)) {
            decreaseQuality();

        }

        increaseSellIn();

        if (isSellInLessThan(ZERO) && isQualityBiggerThan(ZERO)) {
            decreaseQuality();
        }

    }
}

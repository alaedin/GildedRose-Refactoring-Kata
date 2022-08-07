package com.gildedrose.entity;

public class Conjured extends Item {
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        if (isQualityBiggerThan(ZERO)) {
            decreaseQualityBy(TWO);
        }

        decreaseSellIn();

        if (isSellInLessOrEqualTo(ZERO) && isQualityBiggerThan(ZERO)) {
            decreaseQualityBy(TWO);
        }
    }
}

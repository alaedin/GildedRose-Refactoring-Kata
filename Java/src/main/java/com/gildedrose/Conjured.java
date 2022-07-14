package com.gildedrose;

public class Conjured extends Item {

    Conjured(String name, int quality, int sellIn) {
        super(name, quality, sellIn);
    }

    @Override
    protected void tick() {
        sellIn--;
        if (quality == 0) {
            return;
        }
        quality -= 2;
        if (sellIn <= 0) {
            quality -= 2;
        }

    }
}

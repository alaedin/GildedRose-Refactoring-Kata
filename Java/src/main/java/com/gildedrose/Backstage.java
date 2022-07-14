package com.gildedrose;

public class Backstage extends Item {

    Backstage(String name, int quality, int sellIn) {
        super(name, quality, sellIn);
    }

    @Override
    protected void tick() {
        sellIn--;

        if (quality >= 50) {
            return;
        }

        if (sellIn < 0) {
            quality = 0;
        }

        quality++;
        if (sellIn < 10) {
            if (sellIn < 5) {
                quality++;
            }
            quality++;
        }

    }
}

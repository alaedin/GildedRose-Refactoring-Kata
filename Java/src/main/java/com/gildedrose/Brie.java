package com.gildedrose;

public class Brie extends Item {


    Brie(String name, int quality, int sellIn) {
        super(name, quality, sellIn);
    }

    @Override
    protected void tick() {
        sellIn--;
        if (quality >= 50) {
            return;
        }
        quality++;
        if (sellIn <= 0) {
            quality++;
        }

    }
}


package com.gildedrose;

public class Normal extends Item {


    Normal(String name, int quality, int sellIn) {
        super(name, quality, sellIn);
    }

    @Override
    protected void tick() {
        sellIn--;
        if (quality == 0) {
            return;
        }

        quality--;

        if (sellIn <= 0) {
            quality--;
        }
    }
}


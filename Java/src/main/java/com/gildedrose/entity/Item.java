package com.gildedrose.entity;

import com.gildedrose.utils.ConstantUtils;

public class Item implements ConstantUtils {

    protected String name;

    protected int sellIn;

    protected int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void update() {
    }

    public void decreaseQuality() {
        quality--;
    }

    public void increaseSellIn() {
        sellIn--;
    }

    public void increaseQuality() {
        quality++;
    }

    public boolean isQualityBiggerThan(int quality) {
        return this.quality > quality;
    }

    public boolean isSellInAndQualityLessThan(int sellIn, int quality) {
        return isSellInLessThan(sellIn) && isQualityLessThan(quality);
    }

    public boolean isQualityLessThan(int quality) {
        return this.quality < quality;
    }

    public boolean isSellInLessThan(int sellIn) {
        return this.sellIn < sellIn;
    }

    public void decreaseQualityBy(int degrade) {
        quality -= degrade;
    }

    public void decreaseSellIn() {
        sellIn--;
    }

    public boolean isSellInLessOrEqualTo(int sellIn) {
        return this.sellIn < sellIn;
    }

    public void resetQuality() {
        quality = ZERO;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}

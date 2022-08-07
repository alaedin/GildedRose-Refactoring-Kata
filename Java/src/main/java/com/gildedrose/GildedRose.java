package com.gildedrose;

import com.gildedrose.entity.Item;
import com.gildedrose.utils.ItemDefiner;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        items = Arrays.stream(items)
            .map(this::updateQuality)
            .toArray(Item[]::new);
    }

    public Item updateQuality(Item item) {

        ItemDefiner.required(item);

        item = ItemDefiner.identifyItemType(item);
        item.update();
        return item;
    }


}

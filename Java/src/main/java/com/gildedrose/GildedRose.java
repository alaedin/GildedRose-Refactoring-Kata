package com.gildedrose;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

class GildedRose {
    private static final Class<Item> DEFAULT_CLASS = Item.class;

    public static final Map<String, String> SPECIALIZED_CLASSES;

    static {
        SPECIALIZED_CLASSES = new HashMap<>();
        SPECIALIZED_CLASSES.put("normal", Normal.class.getName());
        SPECIALIZED_CLASSES.put("Aged Brie", Brie.class.getName());
        SPECIALIZED_CLASSES.put("Backstage passes to a TAFKAL80ETC concert", Backstage.class.getName());
        SPECIALIZED_CLASSES.put("Conjured Mana Cake", Conjured.class.getName());
    }
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item[] updateQuality() {
        Class<?> clazz;
        Item[] result = new Item[items.length];
        for (int i = 0; i < items.length; i++) {

            clazz = getClassByName(items[i]);
            try {
                result[i] = (Item) clazz.getDeclaredConstructor(String.class, int.class, int.class).newInstance(items[i].name,
                    items[i].sellIn, items[i].quality);
                result[i].tick();

            } catch (InstantiationException | InvocationTargetException | NoSuchMethodException
                     | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private Class<?> getClassByName(Item item) {

        try {
            return Class.forName(SPECIALIZED_CLASSES.get(item.name));
        } catch (ClassNotFoundException | NullPointerException e) {
            return DEFAULT_CLASS;
        }
    }
}

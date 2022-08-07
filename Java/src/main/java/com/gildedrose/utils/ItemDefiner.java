package com.gildedrose.utils;

import com.gildedrose.entity.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ItemDefiner implements ConstantUtils {

    private static final Class<Normal> DEFAULT_ITEM_TYPE = Normal.class;

    private static final Map<String, String> SPECIALIZED_ITEM_TYPE;

    static {
        SPECIALIZED_ITEM_TYPE = new HashMap<>();
        SPECIALIZED_ITEM_TYPE.put(BRIE, Brie.class.getName());
        SPECIALIZED_ITEM_TYPE.put(BACKSTAGE, Backstage.class.getName());
        SPECIALIZED_ITEM_TYPE.put(SULFURAS, Sulfuras.class.getName());
        SPECIALIZED_ITEM_TYPE.put(CONJURED, Conjured.class.getName());
    }

    public static <T extends Item> Item identifyItemType(Item item) {

        required(item);

        Class<?> clazz;
        try {
            clazz = Class.forName(SPECIALIZED_ITEM_TYPE.get(item.getName()));
        } catch (final ClassNotFoundException | NullPointerException e) {
            clazz = DEFAULT_ITEM_TYPE;
        }

        try {
            Constructor<?> constructor = clazz.getConstructor(String.class, int.class, int.class);
            item = (T) constructor.newInstance(item.getName(), item.getSellIn(), item.getQuality());
        } catch (final InstantiationException | InvocationTargetException | NoSuchMethodException |
                       IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return item;
    }

    public static void required(Item item) {
        Objects.requireNonNull(item);
        Objects.requireNonNull(item.getName());

    }

}

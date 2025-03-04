package com.example.fauxcrudapplication;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static final List<Item> items = new ArrayList<>();

    public static void addItem(Item item)
    {
        items.add(item);
    }

    public static void deleteItem(Item item)
    {
        items.remove(item);
    }

    public static List<Item> getItems()
    {
        return items;
    }
}
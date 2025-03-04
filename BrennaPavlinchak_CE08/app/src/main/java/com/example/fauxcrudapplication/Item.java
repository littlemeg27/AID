package com.example.fauxcrudapplication;

import java.io.Serializable;

public class Item implements Serializable
{
    private String name;
    private String category; // Changed from description
    private int quantity;

    public Item(String name, String category, int quantity)
    {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public String getCategory() { return category; } // Changed from getDescription
    public int getQuantity() { return quantity; }

    @Override
    public String toString()
    {
        return name;
    }
}
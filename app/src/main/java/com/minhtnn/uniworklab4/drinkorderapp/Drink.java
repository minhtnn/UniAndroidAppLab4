package com.minhtnn.uniworklab4.drinkorderapp;

public class Drink {
    private String name;
    private String description;
    private int price;
    private int imageResId;

    public Drink(String name, String description, int price, int imageResId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResId = imageResId;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getPrice() { return price; }
    public int getImageResId() { return imageResId; }
}

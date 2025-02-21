package com.minhtnn.uniworklab4.foodorderapp;

public class Food {
    private String name;
    private String description;
    private int price;
    private int imageResId;

    public Food(String name, String description, int price, int imageResId) {
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

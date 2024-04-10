package com.example.wishingcloud.models;

public class Product {
    private int productID;
    private String name;
    private double price;
    private String url;
    private int amount;
    private String description;
// private object picture // TODO
    public Product() { // empty for Spring DI and IOC MAGIC BABY
    }

    public Product(int productID, String name, double price, String url, int amount, String description) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.url = url;
        this.amount = amount;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
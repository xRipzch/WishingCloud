package com.example.wishingcloud.models;

public class Product {
    private int productId;
    private String name;
    private double price;
    private String url;
    private int amount;
    private String description;

    public Product() { // empty for Spring DI and IOC MAGIC BABY
    }

    public Product(int productId, String name, double price, String url, int amount, String description) {
        this.productId = productId;
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

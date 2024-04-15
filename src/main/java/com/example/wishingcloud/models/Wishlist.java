package com.example.wishingcloud.models;

public class Wishlist {
    private String name;
    private int wishlistId;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public Wishlist(String name, int wishlistId, int userId) {
        this.name = name;
        this.wishlistId = wishlistId;
        this.userId = userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }

    public Wishlist(String name, int wishlistId) {
        this.name = name;
        this.wishlistId = wishlistId;
    }

    public Wishlist(){

    }
}

package com.example.wishingcloud.models;

public class Wishlist {
    private String name;
    private int wishlistID;
//    private int userID; // TODO No do. We dont need

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWishlistID() {
        return wishlistID;
    }

    public void setWishlistID(int wishlistID) {
        this.wishlistID = wishlistID;
    }

    public Wishlist(String name, int wishlistID) {
        this.name = name;
        this.wishlistID = wishlistID;
    }

    public Wishlist(){

    }
}

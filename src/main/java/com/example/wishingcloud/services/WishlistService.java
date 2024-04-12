package com.example.wishingcloud.services;

import com.example.wishingcloud.models.Wishlist;
import com.example.wishingcloud.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    WishlistRepository wishlistRepository;

    public void addWishlist(int userId, Wishlist w){ // skal vel ikke bruge userID og wishlist som parametre ?
        wishlistRepository.addWishlist(userId, w);
    }
    public void createWishlist(String wishlistName, int userID){
        wishlistRepository.createWishlist(wishlistName, userID);
    }

    public List<Wishlist> getWishLists(int userId){
        return wishlistRepository.getWishlists(userId);
    }

    public Wishlist getWishList(int wishlistId){
        return wishlistRepository.getWishlist(wishlistId);
    }
}

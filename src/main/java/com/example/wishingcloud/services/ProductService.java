package com.example.wishingcloud.services;

import com.example.wishingcloud.models.Product;
import com.example.wishingcloud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    
    @Autowired
    ProductRepository productRepository;

    public void addProduct(String productName, String url, String description, double price, int amount, int wishlistId){
        productRepository.addProduct(productName, url, description, price, amount, wishlistId);
    }

    public List<Product> getProducts(int wishlistId){
       return productRepository.getProducts(wishlistId);
    }

    public Product getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public void deleteProductFromWishlist(int productId){
        productRepository.deleteProductFromWishlist(productId);
    }

    public void editProductFromWishlist(int productId){
//        productRepository.editProductFromWishlist(productId);
    }

}

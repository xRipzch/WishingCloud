package com.example.wishingcloud.controllers;

import com.example.wishingcloud.models.Product;
import com.example.wishingcloud.services.ProductService;
import com.example.wishingcloud.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    WishlistService wishlistService;

    @GetMapping ("/product")
    public String showAllProducts(@RequestParam int id, Model model) {
        model.addAttribute("products", productService.getProducts(id));
        model.addAttribute("wishlist", wishlistService.getWishList(id));
        return "home/product";
    }
    @PostMapping("/addProduct")
    public String addProduct(@RequestParam String productName, @RequestParam String url, @RequestParam String description,
                             @RequestParam double price, @RequestParam int amount, @RequestParam int wishlistId, Model model) {
        if(productName.isEmpty() || url.isEmpty() || description.isEmpty()|| price == 0 || amount == 0) {
            return "redirect:/product?id=" + wishlistId;
        }
        if(price <= 0 || amount <= 0) {
            return "redirect:/product?id=" + wishlistId;
        }

        productService.addProduct(productName, url, description, price, amount, wishlistId);
        model.addAttribute("products", productService.getProducts(wishlistId));
        return "redirect:/product?id=" + wishlistId;
    }

}
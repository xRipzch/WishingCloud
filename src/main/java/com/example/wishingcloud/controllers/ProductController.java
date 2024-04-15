package com.example.wishingcloud.controllers;

import com.example.wishingcloud.models.Product;
import com.example.wishingcloud.services.ProductService;
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
    @GetMapping ("/product")
    public String showAllProducts(@RequestParam int id, Model model) {
        model.addAttribute("products", productService.getProducts(id));
        return "home/product";
    }
    @PostMapping("/addProduct")
    public String addProduct(@RequestParam String productName, @RequestParam String url, @RequestParam String description,
                             @RequestParam double price, @RequestParam int amount, @RequestParam int wishlistId) {
        if(productName.equals("") || url.equals("") || description.equals("") || price == 0 || amount == 0) {
            return "redirect:/product?id=" + wishlistId;
        }
        if(price < 0 || amount < 0) {
            return "redirect:/product?id=" + wishlistId;
        }

        productService.addProduct(productName, url, description, price, amount, wishlistId);
        return "redirect:/product?id=" + wishlistId;
    }

}

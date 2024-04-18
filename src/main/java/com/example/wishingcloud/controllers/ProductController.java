package com.example.wishingcloud.controllers;

import com.example.wishingcloud.services.ProductService;
import com.example.wishingcloud.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    WishlistService wishlistService;

    @GetMapping("/product")
    public String showAllProducts(@RequestParam int wishlistId, Model model) {
        model.addAttribute("products", productService.getProducts(wishlistId));
        model.addAttribute("wishlist", wishlistService.getWishList(wishlistId));
        return "home/product";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam String productName, @RequestParam String url, @RequestParam String description,
                             @RequestParam double price, @RequestParam int amount, @RequestParam int wishlistId, Model model) {
        if (productName.isEmpty() || url.isEmpty() || description.isEmpty() || price == 0 || amount == 0) {
            return "redirect:/product?wishlistId=" + wishlistId;
        }
        if (price <= 0 || amount <= 0) {
            return "redirect:/product?wishlistId=" + wishlistId;
        }
        productService.addProduct(productName, url, description, price, amount, wishlistId);
        model.addAttribute("products", productService.getProducts(wishlistId));
        return "redirect:/product?wishlistId=" + wishlistId;
    }

    @GetMapping("/sharedwishlist" )
    public String shareWishList(@RequestParam int id, Model model) {
        model.addAttribute("wishlist", wishlistService.getWishList(id));
        model.addAttribute("products", productService.getProducts(id));
        return "home/sharedwishlist";

    }
    @PostMapping("/confirm_delete_product")
    public String deleteProductFromWishlist(@RequestParam int productId, @RequestParam int wishlistId, RedirectAttributes redirectAttributes) {
        productService.deleteProductFromWishlist(productId);
        redirectAttributes.addAttribute("wishlistId", wishlistId);
        return "redirect:/product";
    }

    @GetMapping("/edit_product1")
    public String editProductFromWishlist(@RequestParam int productId, Model model) {
        model.addAttribute("product", productService.getProduct(productId));
        return "home/edit_product";

    }
    @PostMapping ("/edit_product2")
    public String editProductFromWishlist (@RequestParam String productName, @RequestParam String url, @RequestParam String description, @RequestParam double price, @RequestParam int productId,  @RequestParam int amount){
        productService.editProductFromWishlist(productName,url,description,price,amount,productId);
        int wishlistId = productService.getWishlistIdFromProduct(productId);
        return "redirect:/product?wishlistId=" + wishlistId;
    }



}
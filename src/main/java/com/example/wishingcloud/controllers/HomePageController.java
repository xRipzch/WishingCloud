package com.example.wishingcloud.controllers;
import com.example.wishingcloud.services.UserService;
import com.example.wishingcloud.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {
    @Autowired
    UserService userService;

    @Autowired
    WishlistService wishService;

    @GetMapping("/homepage")
    public String homePage(Model model, @RequestParam String email, @RequestParam String password) {
        int userId = userService.getUserId(email);
        model.addAttribute("user", userService.getUser(userId));
        return "home/homepage";
    }

    @PostMapping("/createWishlist")
    public String createWishlist(@RequestParam String wishlistName, @RequestParam String firstName) {
      wishService.createWishlist(wishlistName, userService.getUserId(firstName));
        return "redirect:/home/homepage";

    }
}

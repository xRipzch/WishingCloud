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
    @Autowired
    private WishlistService wishlistService;

    @GetMapping("/homepage")
    public String homePage(Model model, @RequestParam String email) {
        int userId = userService.getUserId(email);
        model.addAttribute("user", userService.getUser(userId));
        model.addAttribute("wishlists", wishlistService.getWishLists(userService.getUserId(email)));
        return "home/homepage";
    }

    @PostMapping("/createWishlist")
    public String createWishlist(Model model, @RequestParam String wishlistName,
                                 @RequestParam String email) {
      wishService.createWishlist(wishlistName, userService.getUserId(email)); //finder userId ud fra firstname, som ikke er unikt?
        int userId = userService.getUserId(email);
        model.addAttribute("user", userService.getUser(userId));
        return "home/homepage";
    }
}

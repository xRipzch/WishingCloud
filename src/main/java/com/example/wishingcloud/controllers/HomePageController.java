package com.example.wishingcloud.controllers;

import com.example.wishingcloud.services.UserService;
import com.example.wishingcloud.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomePageController {

    @Autowired
    UserService userService;

    @Autowired
     WishlistService wishlistService;

    @GetMapping("/homepage")
    public String homePage(Model model, @RequestParam String email) {
        int userId = userService.getUserId(email);
        model.addAttribute("user", userService.getUser(userId));
        model.addAttribute("wishlists", wishlistService.getWishLists(userService.getUserId(email)));
        return "home/homepage";
    }

    @PostMapping("/createWishlist")

    public String createWishlist( @RequestParam String wishlistName,
                                 @RequestParam String email, RedirectAttributes redirectAttributes) {
        wishlistService.createWishlist(wishlistName, userService.getUserId(email)); //finder userId ud fra firstname, som ikke er unikt?
        int userId = userService.getUserId(email);
        redirectAttributes.addAttribute("email", email);

        return "redirect:/homepage";
    }

    @PostMapping("/confirm_delete") // TODO vi er nødt til at lave noget fis her med email når vi redirecter
    public String deleteWishlist(@RequestParam int wishlistId, @RequestParam String email, RedirectAttributes redirectAttributes) {
        wishlistService.deleteWishlist(wishlistId);
        redirectAttributes.addAttribute("email", email);
        return "redirect:/homepage";
    }

}

package com.example.wishingcloud.controllers;

import com.example.wishingcloud.services.UserService;
import com.example.wishingcloud.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ValidateController {
    @Autowired
    UserService userService;

    @Autowired
    WishlistService wishlistService;



    @PostMapping("/validate")
    // todo rewrite method to match username with given pass and pass in DB to check if user is legit.
    public String validate(Model model, @RequestParam String email, @RequestParam String password) {
        String loginStatus = userService.checkPass(email,password);
        if (loginStatus.equals("UserApproved")) {
            model.addAttribute("user", userService.getUser(userService.getUserId(email))); //Hvorfor bruger vi ikke bare email som primary key?
            model.addAttribute("wishlists", wishlistService.getWishLists(userService.getUserId(email)));
            return "home/homepage"; // TODO Vi skal have den her til at redirecte til HomepageController (måske)
        } else if (loginStatus.equals("NoUserFound")) {

            model.addAttribute("error", "This email does not exist in the database");
            return "home/login";
        } else {
            model.addAttribute("error", "Wrong password");
        }
        return "home/login";
    }
}

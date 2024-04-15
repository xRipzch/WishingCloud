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
        if (userService.checkPass(email, password).equals("UserApproved")) {
            model.addAttribute("user", userService.getUser(userService.getUserID(email)));
            return "home/homepage";
        } else if (userService.checkPass(email, password).equals("NoUserFound")) {
            model.addAttribute("error", "This email does not exist in the database");
            return "home/login";
        } else {
            model.addAttribute("error", "Wrong password");
        }
        return "home/login";
    }
}

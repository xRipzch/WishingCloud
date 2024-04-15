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

    public String validate(Model model, @RequestParam String email, @RequestParam String password) {
        String loginStatus = userService.checkPass(email,password);
        if (loginStatus.equals("UserApproved")) {
            model.addAttribute("user", userService.getUser(userService.getUserId(email)));
            model.addAttribute("wishlists", wishlistService.getWishLists(userService.getUserId(email)));
            return "redirect:home/homepage";
        } else if (loginStatus.equals("NoUserFound")) {
            model.addAttribute("error", "This email does not exist in the database");
            return "home/login";
        } else {
            model.addAttribute("error", "Wrong password");
        }
        return "home/login";
    }
}

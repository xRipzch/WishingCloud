package com.example.wishingcloud.controllers;

import com.example.wishingcloud.services.UserService;
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

    @PostMapping("/validate")
    // todo rewrite method to match username with given pass and pass in DB to check if user is legit.
    public String validate(Model model, @RequestParam String email, @RequestParam String password) {
        if (userService.checkPass(email, password)) {
            model.addAttribute("message", "Right!");
            return "home/homepage";
        } else model.addAttribute("message", "Wrong!");
        return "home/login";


    }
}

package com.example.wishingcloud.controllers;


import com.example.wishingcloud.models.User;
import com.example.wishingcloud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class HomeController {
    @Autowired
    UserService userService;


    @GetMapping("/test")
    public  String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers() );
        return  "home/index";
    }

    @GetMapping("/")
    public String index() {
        return "home/index";
    }
    @GetMapping ("/signup")
    public String signup () {
        return "home/signup";
    }

    @GetMapping("/login")
    public String login() {
        return "home/login";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute User u, @RequestParam String firstName, @RequestParam String lastName,
                         @RequestParam String email, @RequestParam String password, @RequestParam String address,
                         @RequestParam char gender, @RequestParam LocalDate dateOfBirth) {
        userService.addUser(u);
        return "home/signup"; // TODO
    }
}

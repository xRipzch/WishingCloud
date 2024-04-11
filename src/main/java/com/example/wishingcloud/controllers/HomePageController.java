package com.example.wishingcloud.controllers;
import com.example.wishingcloud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {
    @Autowired
    UserService userService;

    @GetMapping ("/homepage")
    public String homePage(Model model,@RequestParam String email, @RequestParam String password)  {
        model.addAttribute("user", userService.getUserID(email));
        return "home/homepage";
    }


}

package com.example.wishingcloud.controllers;

import com.example.wishingcloud.services.UserService;
import com.example.wishingcloud.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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

    public String validate(Model model, @RequestParam String email, @RequestParam String password, RedirectAttributes redirectAttributes) {
        String loginStatus = userService.checkPass(email,password);
        if (loginStatus.equals("UserApproved")) {
            redirectAttributes.addAttribute("email", email); //det er sådan her man sender ting fra en controller til en anden
            return "redirect:/homepage";
        } else if (loginStatus.equals("NoUserFound")) {
            model.addAttribute("error", "This email does not exist in the database");
            return "home/login";
        } else {
            model.addAttribute("error", "Wrong password");
        }
        return "home/login";
    }
}

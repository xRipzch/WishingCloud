package com.example.wishingcloud.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ValidateController {

    @PostMapping("/validate")
    public String validate(Model model, @RequestParam String name, @RequestParam String password) {
        if (name.equals(password)) {
            model.addAttribute("message", "Right!");
            return "home/index"; // Indsæt nyt side her, som brugeren bliver sendt til, hvis brugernavn og password er ens/korrekt
        } else {
            model.addAttribute("message", "Sorry, wrong username or password. Please try again.");
            return "home/errorLogin";
        }
    }
}

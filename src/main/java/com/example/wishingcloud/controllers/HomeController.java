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
import java.time.format.DateTimeFormatter;


import java.time.LocalDate;

@Controller
public class HomeController {
    @Autowired
    UserService userService;

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
    public String signup(@RequestParam String firstName, @RequestParam String lastName,
                         @RequestParam String email, @RequestParam String password,
                         @RequestParam String address, @RequestParam String gender,
                         @RequestParam String dateOfBirthString) {
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString);
        String formattedDateOfBirth = dateOfBirth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Create a new User object
        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setAddress(address);
        newUser.setGender(gender);
        newUser.setDateOfBirth(LocalDate.parse(formattedDateOfBirth));
        userService.addUser(newUser);

        return "home/signup"; // TODO: Return appropriate view
    }


}

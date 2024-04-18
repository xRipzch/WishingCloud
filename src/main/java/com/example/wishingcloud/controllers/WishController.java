package com.example.wishingcloud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class WishController {

    @PostMapping("/searchWish")
    public String searchWish(@RequestParam String wish) {
        String encodedWish = URLEncoder.encode(wish, StandardCharsets.UTF_8);
        return "redirect:https://www.google.com/search?q=" + encodedWish + "&tbm=isch";
    }
}


/*Vi bruger URLEncoder.encode til at sikre, at brugerens ønske sikkert inkluderes i URL'en. Dette forhindrer potentielle problemer med specielle tegn.
Metoden returnerer derefter en omdirigeringsstreng, der peger på Google Billeder-søgning efter det kodede ønsketerm.
Vi tilføjer &tbm=isch til URL'en for specifikt at angive søgning efter billeder.*/
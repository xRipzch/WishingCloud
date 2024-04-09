package com.example.wishingcloud.Controller;

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


// We use URLEncoder.encode to ensure the user's wish is safely included in the URL. This prevents potential issues with special characters.
// The method then returns a redirect string that points to Google Images search for the encoded wish term.
// We append &tbm=isch to the URL to specifically indicate searching for images.
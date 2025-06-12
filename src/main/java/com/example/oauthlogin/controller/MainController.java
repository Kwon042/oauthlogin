package com.example.oauthlogin.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        System.out.println("index 호출됨 (인증 여부 무관)");
        return "index";
    }

    @GetMapping("/login")
    public String login(@AuthenticationPrincipal OAuth2User principal) {
        if (principal != null) {
            return "redirect:/home";
        }
        return "login";
    }

}

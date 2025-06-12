package com.example.oauthlogin.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model, @AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            System.out.println("principal is null! 로그인 정보 없음");
            return "redirect:/";  // 로그인 안 된 경우 메인으로 리다이렉트
        }
        System.out.println("principal.getAttributes() = " + principal.getAttributes());
        String name = principal.getAttribute("name");
        String email = principal.getAttribute("email");
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        return "home";
    }
}

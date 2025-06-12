package com.example.oauthlogin;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvCheck {

    // :NOT_FOUND는 기본값 (default value) 이라는 뜻
    @Value("${GOOGLE_CLIENT_ID:NOT_FOUND}")
    private String clientId;

    @PostConstruct
    public void printEnv() {
        System.out.println("✅ GOOGLE_CLIENT_ID: " + clientId);
    }
}
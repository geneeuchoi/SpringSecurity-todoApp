package com.sparta.springsecuritytodoapp.config;

import jakarta.annotation.PostConstruct;
import lombok.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Value("${jwt.secret.key}")
    private String SECRET_KEY;

    @Value("${jwt.expiration}")
    private Long EXPIRATION;

    public static String staticSecretKey;
    public static Long staticExpiration;

    @PostConstruct
    public void init() {
        staticSecretKey = SECRET_KEY;
        staticExpiration = EXPIRATION;
    }
}
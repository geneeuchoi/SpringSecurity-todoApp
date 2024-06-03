package com.sparta.springsecuritytodoapp.dto;

import lombok.Getter;

@Getter
public class AuthRequest {
    private String username;
    private String password;
}
package com.sparta.springsecuritytodoapp.dto;

import lombok.Getter;

@Getter
public class ToDoRequestDto {
    private String title;
    private String contents;
    private String manager;
    private String password;
}


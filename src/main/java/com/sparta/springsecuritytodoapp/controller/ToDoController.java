package com.sparta.springsecuritytodoapp.controller;

import com.sparta.springsecuritytodoapp.dto.ToDoRequestDto;
import com.sparta.springsecuritytodoapp.dto.ToDoResponseDto;
import com.sparta.springsecuritytodoapp.service.ToDoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ToDoController {

    private final ToDoService todoService;
    public ToDoController(ToDoService todoService) {
        this.todoService = todoService;
    }
    @PostMapping("/todo")
    public ToDoResponseDto createTodo(@RequestBody ToDoRequestDto todoRequestDto){
        return todoService.createTodo(todoRequestDto);
    }
}
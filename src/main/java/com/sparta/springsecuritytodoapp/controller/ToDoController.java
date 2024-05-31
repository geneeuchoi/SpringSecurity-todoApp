package com.sparta.springsecuritytodoapp.controller;

import com.sparta.springsecuritytodoapp.dto.ToDoRequestDto;
import com.sparta.springsecuritytodoapp.dto.ToDoResponseDto;
import com.sparta.springsecuritytodoapp.service.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    //1단계 - 생성
    @PostMapping("/toDo")
    public ToDoResponseDto createToDo(@RequestBody ToDoRequestDto toDoRequestDto){
        return toDoService.createTodo(toDoRequestDto);
    }
    //2단계 - 선택일정 조회(PathVariable 이용)
    @GetMapping("/toDo/{id}")
    public ToDoResponseDto getToDo(@PathVariable Long id){
        return toDoService.getToDo(id);
    }

    //3단계 - 등록된 일정 전체 조회, 작성일 기준 내림차순 정렬
    @GetMapping("/toDo/{id}")
    public List<ToDoResponseDto> getAllToDo(){
        return toDoService.getAllToDo();
    }


}
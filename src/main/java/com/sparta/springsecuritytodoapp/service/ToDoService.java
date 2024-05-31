package com.sparta.springsecuritytodoapp.service;

import com.sparta.springsecuritytodoapp.dto.ToDoRequestDto;
import com.sparta.springsecuritytodoapp.dto.ToDoResponseDto;
import com.sparta.springsecuritytodoapp.entity.ToDo;
import com.sparta.springsecuritytodoapp.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;
    public ToDoResponseDto createTodo(ToDoRequestDto requestDto) {
        ToDo toDo = toDoRepository.save(new ToDo(requestDto));
        return new ToDoResponseDto(toDo);
    }
}

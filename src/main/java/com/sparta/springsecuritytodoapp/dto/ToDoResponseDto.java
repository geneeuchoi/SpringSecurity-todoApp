package com.sparta.springsecuritytodoapp.dto;

import com.sparta.springsecuritytodoapp.entity.ToDo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ToDoResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String manager;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public ToDoResponseDto(ToDo toDo){
        this.id = toDo.getId();
        this.title = toDo.getTitle();
        this.contents = toDo.getContents();
        this.manager = toDo.getManager();
        this.createAt = toDo.getCreatedAt();
        this.modifiedAt = toDo.getModifiedAt();
    }
}
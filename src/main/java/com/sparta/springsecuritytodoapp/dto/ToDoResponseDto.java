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

    public ToDoResponseDto(ToDo todo){
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.contents = todo.getContents();
        this.manager = todo.getManager();
        this.createAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
    }
}
package com.sparta.springsecuritytodoapp.entity;

import com.sparta.springsecuritytodoapp.dto.ToDoRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ToDo extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "contents", nullable = true, length = 100)
    private String contents;
    @Column(name = "manager", nullable = false)
    private String manager;
    @Column(name = "password", nullable = false)
    private String password;

    public ToDo(ToDoRequestDto toDoRequestDto) {
        this.title = toDoRequestDto.getTitle();
        this.contents = toDoRequestDto.getContents();
        this.manager = toDoRequestDto.getManager();
        this.password = toDoRequestDto.getPassword();
    }

    public void update(ToDoRequestDto toDoRequestDto) {
        this.title = toDoRequestDto.getTitle();
        this.contents = toDoRequestDto.getContents();
        this.manager = toDoRequestDto.getManager();
    }
}
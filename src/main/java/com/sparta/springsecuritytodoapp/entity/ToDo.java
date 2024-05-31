package com.sparta.springsecuritytodoapp.entity;

import com.sparta.springsecuritytodoapp.dto.ToDoRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "ToDo")
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

    // 하나의 스케쥴에 다수의 댓글이 달리므로 댓글N : 스케쥴1 관계 설정
    @OneToMany(mappedBy = "toDo")
    private List<Comment> commentList;

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

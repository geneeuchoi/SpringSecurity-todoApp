package com.sparta.springsecuritytodoapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "comment")
@NoArgsConstructor
public class Comment extends Timestamped {
    //아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //댓글 내용
    @Column(name = "content", nullable = false)
    private String content;

    //사용자 아이디
    @Column(name = "userId", nullable = false)
    private String userId;

    //작성 일자
    @CreatedDate
    @Column(name = "createAt", updatable = false)
    private LocalDateTime createdAt;

    //N:1 관계, 한 일정당 여러 개의 댓글이 있을 수 있다.
    //toDo_id를 FK로 가진다.
    @ManyToOne
    @JoinColumn(name = "toDo_id", nullable = false)
    private ToDo toDo;

}

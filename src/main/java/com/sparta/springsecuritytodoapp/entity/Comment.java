package com.sparta.springsecuritytodoapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sparta.springsecuritytodoapp.dto.CommentRequestDto;
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
    //자동 생성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //댓글 내용
    @Column(name = "content", nullable = false)
    private String content;

    //사용자 아이디
    @Column(name = "comment_Id", nullable = false)
    private Long comment_Id;

    //N:1 관계, 한 일정당 여러 개의 댓글이 있을 수 있다.
    //toDo_id를 FK로 가진다.
    //일정 아이디
    @ManyToOne
    @JoinColumn(name = "toDo_Id", nullable = false)
    private ToDo toDo;

    //작성 일자
    @CreatedDate
    @Column(name = "createAt", updatable = false)
    private LocalDateTime createdAt;


    public Comment(CommentRequestDto requestDto, ToDo toDo) {
        this.content = requestDto.getContent();
        this.comment_Id = requestDto.getComment_Id();
        this.toDo = toDo;
    }
}

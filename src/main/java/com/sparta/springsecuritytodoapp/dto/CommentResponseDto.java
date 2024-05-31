package com.sparta.springsecuritytodoapp.dto;

import com.sparta.springsecuritytodoapp.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentResponseDto {
    private String content;
    private Long comment_Id;
    private Long toDo_Id;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public CommentResponseDto(Comment comment) {
        this.content = comment.getContent();
        this.comment_Id = comment.getComment_Id();
        this.toDo_Id = comment.getToDo().getId();
        this.createAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }

}

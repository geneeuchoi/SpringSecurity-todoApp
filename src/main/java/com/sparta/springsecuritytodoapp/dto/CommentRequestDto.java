package com.sparta.springsecuritytodoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentRequestDto {
    private String content;        // 댓글 내용
    private Long comment_Id;     // 사용자 아이디
    private Long toDo_Id;    // 일정 아이디
}

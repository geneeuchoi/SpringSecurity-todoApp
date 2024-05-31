package com.sparta.springsecuritytodoapp.controller;

import com.sparta.springsecuritytodoapp.dto.CommentRequestDto;
import com.sparta.springsecuritytodoapp.dto.CommentResponseDto;
import com.sparta.springsecuritytodoapp.dto.ToDoRequestDto;
import com.sparta.springsecuritytodoapp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;


    //2단계 - 댓글 등록
    @PostMapping("/comment")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto requestDto) {
        return commentService.createComment(requestDto);
    }

    //3단계 - 댓글 수정
    @PutMapping("/comment/{comment_Id}")
    public CommentResponseDto createComment(@PathVariable Long comment_Id, @RequestBody CommentRequestDto requestDto) {
        return commentService.updateComment(requestDto, comment_Id);
    }

    //4단계 - 댓글 삭제
    @DeleteMapping("/comment/{comment_Id}")
    @ResponseStatus(HttpStatus.CREATED)
    public String deleteComment(@PathVariable Long comment_Id, @RequestBody CommentRequestDto requestDto) {
        return commentService.deleteComment(comment_Id, requestDto);
    }

}

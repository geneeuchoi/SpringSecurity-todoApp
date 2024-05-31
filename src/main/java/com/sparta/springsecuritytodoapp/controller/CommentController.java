package com.sparta.springsecuritytodoapp.controller;

import com.sparta.springsecuritytodoapp.dto.CommentRequestDto;
import com.sparta.springsecuritytodoapp.dto.CommentResponseDto;
import com.sparta.springsecuritytodoapp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

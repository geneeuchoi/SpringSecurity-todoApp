package com.sparta.springsecuritytodoapp.service;

import com.sparta.springsecuritytodoapp.dto.CommentRequestDto;
import com.sparta.springsecuritytodoapp.dto.CommentResponseDto;
import com.sparta.springsecuritytodoapp.dto.ToDoResponseDto;
import com.sparta.springsecuritytodoapp.entity.Comment;
import com.sparta.springsecuritytodoapp.entity.ToDo;
import com.sparta.springsecuritytodoapp.repository.CommentRepository;
import com.sparta.springsecuritytodoapp.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {


    private final CommentRepository commentRepository;
    private final ToDoRepository toDoRepository;

    public CommentResponseDto createComment(CommentRequestDto requestDto) {
        //선택한 일정이 있다면 댓글을 등록
        //댓글이 등록되었다면 클라이언트에게 반환
        //선택 일정이 db에 있어야 함
        //고유번호, 댓글내용, 사용자 아이디, 일정 아이디, 작성일자를 저장


        // 예외처리: 선택한 일정의 ID를 입력 받지 않은 경우
        // nullable = false로 했는데 굳이 예외 처리를 해야 하나 싶긴 함.
        if (requestDto.getToDo_Id() == null){
            throw new IllegalArgumentException("일정 ID를 입력해주세요");
        }
        // 예외처리: 댓글 내용이 비어 있는 경우
        if (requestDto.getContent().isBlank()) {
            throw new IllegalArgumentException("댓글 내용이 없습니다.");
        }
        // 예외처리: 일정이 DB에 저장되지 않은 경우
        // findById를 통해 toDo를 가져옴
        ToDo toDo= toDoRepository.findById(requestDto.getToDo_Id()).orElseThrow(
                () -> new IllegalArgumentException("선택한 일정이 존재하지 않습니다.")
        );

        return new CommentResponseDto(commentRepository.save(new Comment(requestDto, toDo)));
    }
}

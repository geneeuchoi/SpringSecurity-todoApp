package com.sparta.springsecuritytodoapp.service;

import com.sparta.springsecuritytodoapp.dto.ToDoRequestDto;
import com.sparta.springsecuritytodoapp.dto.ToDoResponseDto;
import com.sparta.springsecuritytodoapp.entity.ToDo;
import com.sparta.springsecuritytodoapp.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;
    public ToDoResponseDto createTodo(ToDoRequestDto requestDto) {
        ToDo toDo = toDoRepository.save(new ToDo(requestDto));
        return new ToDoResponseDto(toDo);
    }

    public ToDoResponseDto getToDo(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("선택한 일정이 존재하지 않습니다."));
        return new ToDoResponseDto(toDo);
    }

    public List<ToDoResponseDto> getAllToDo() {
        return toDoRepository.findAllByOrderByModifiedAtDesc().stream().map(ToDoResponseDto::new).toList();
    }

    @Transactional
    public ToDoResponseDto updateToDo(Long id, ToDoRequestDto toDoRequestDto) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("선택한 일정이 존재하지 않습니다."));

        //저장된 패스워드와 responseDto의 패스워드가 같은지 검사
        if(toDo.getPassword().equals(toDoRequestDto.getPassword())) {
            toDo.update(toDoRequestDto);
            //변경사항을 저장
            //toDoRepository.save(toDo);
            return new ToDoResponseDto(toDo);
        } else {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}

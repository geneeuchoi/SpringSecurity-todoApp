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
        ToDo toDo = this.findTodo(id);

        // 이 메소드를 통과하면 패스워드가 검증된 것,
        // 검증되지 않으면 exception이 던져지므로 나머지 로직이 수행되지 않는다.
        this.verifyPassword(toDo, toDoRequestDto);

        toDo.update(toDoRequestDto);

        return new ToDoResponseDto(toDo);
    }

    public Long deleteToDo(Long id, ToDoRequestDto toDoRequestDto) {
        ToDo toDo = this.findTodo(id);

        this.verifyPassword(toDo, toDoRequestDto);
        toDoRepository.delete(toDo);

        return id;
    }

    private ToDo findTodo(Long id) {
        return toDoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("선택한 일정이 존재하지 않습니다."));
    }

    private void verifyPassword(ToDo toDo, ToDoRequestDto toDoRequestDto) {
        if(!toDo.getPassword().equals(toDoRequestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}

package com.sparta.springsecuritytodoapp.repository;

import com.sparta.springsecuritytodoapp.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findAllByOrderByModifiedAtDesc();
}

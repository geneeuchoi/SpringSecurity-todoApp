package com.sparta.springsecuritytodoapp.repository;

import com.sparta.springsecuritytodoapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

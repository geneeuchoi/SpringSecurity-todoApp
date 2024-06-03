package com.sparta.springsecuritytodoapp.repository;

import com.sparta.springsecuritytodoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

package com.sparta.springsecuritytodoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringSecurityTodoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityTodoAppApplication.class, args);
    }

}

package org.example.todoapispring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//annotations are going to be identifiers to your spirngboot applications that will help us to add some functionality or trigger spirng boot to some functionality level applications 
public class TodoApiSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoApiSpringApplication.class, args);
    }

}

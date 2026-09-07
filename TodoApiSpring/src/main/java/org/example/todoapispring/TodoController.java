package org.example.todoapispring;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;
@RestController
@RequestMapping("/api/v1/todos")
// By writing @RestController(@Controller+@ResponseBody) we define controller is our entry point that means this is the first layer that is going to collect our request
//majorly two use cases  1.Collecting the request 2.Returning the responses.
// Help in serialization like jave object ->>JSON
//whatever return body you give your function that return value is going to be stratgh away return in the response body of HTTP rsponse object
public class TodoController {

    private static List<Todo> todoList;

    public TodoController() {
        todoList = new ArrayList<>();
        todoList.add(new Todo(1, false, "Todo 1", 1000));
        todoList.add(new Todo(2, true, "Todo 2", 1001));
    }
    //For filtration, we use QueryParam @RequestParam

    //GET
    @GetMapping("/")
    public ResponseEntity<List<Todo>> getTodos(@RequestParam(required = false,defaultValue = "true") Boolean isCompleted) {
        System.out.println("Incoming Query Param is : "+ isCompleted);
        return ResponseEntity.status(HttpStatus.OK).body(todoList);
    }
    //POST
    @PostMapping("/")
    //  @ResponseStatus(HttpStatus.CREATED) //show the status 201 CREATED explicitly
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {//@RequestBody tells whatever the incoming request body in the http request that body should be accesable inside this createTodo method
        //ResponseEntiity class manually handle the status of the http whatever you sending to the client

        todoList.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);

    }

    @GetMapping("{todoId}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long todoId){
        for(Todo todo:todoList){
            if(todo.getId()==todoId){
                return ResponseEntity.ok(todo);
            }
        }
        return  ResponseEntity.notFound().build();
    }

    //DELETE
    @DeleteMapping("{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long todoId) {

        for (Todo todo : todoList) {
            if (todo.getId()==(todoId)) {
                todoList.remove(todo);
                return ResponseEntity.noContent().build(); // 204 No Content
            }
        }

        return ResponseEntity.notFound().build();
    }
    //PATCH
    @PatchMapping("{todoId}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable int todoId,
            @RequestBody TodoPatchRequest request) {

        for (Todo todo : todoList) {

            if (todo.getId() == todoId) {

                if (request.getCompleted() != null) {
                    todo.setCompleted(request.getCompleted());
                }

                if (request.getTitle() != null) {
                    todo.setTitle(request.getTitle());
                }

                if (request.getUserId() != null) {
                    todo.setUserId(request.getUserId());
                }

                return ResponseEntity.ok(todo);
            }
        }

        return ResponseEntity.notFound().build();
    }

}

/*
 * Link:https://www.geeksforgeeks.org/springboot/spring-boot-pathvariable-and-requestparam-annotations/
 * Link:https://www.baeldung.com/spring-request-param
 * Link:https://blog.masteringbackend.com/mastering-request-param-in-spring-boot
 *
 *
 *  */

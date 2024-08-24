package com.example.todo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.todo.Todo;
import com.example.todo.TodoRepository;
import com.example.todo.TodoService;

@RestController
public class TodoController {
    TodoService service = new TodoService();

    @GetMapping("/todos")
    public ArrayList<Todo> gettodosdetails() {
        return service.gettodosdetails();
    }

    @GetMapping("/todos/{id}")
    public Todo gettododetails(@PathVariable("id") int id) {

        return service.gettododetails(id);

    }

    @PostMapping("/todos")
    public Todo addtodo(@RequestBody Todo todo) {
        return service.addtodo(todo);
    }

    @PutMapping("/todos/{id}")
    public Todo updatetodo(@PathVariable("id") int id, @RequestBody Todo todo) {
        return service.updatetodo(id, todo);
    }

    @DeleteMapping("/todos/{id}")

    public void deletetodo(@PathVariable("id") int id) {
        service.deletetodo(id);
    }

}
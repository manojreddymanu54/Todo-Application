
package com.example.todo;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.todo.Todo;
import com.example.todo.TodoRepository;

import java.util.*;

// Do not modify the below code

public class TodoService implements TodoRepository {

    private static HashMap<Integer, Todo> todoList = new HashMap<>();

    public TodoService() {
        todoList.put(1, new Todo(1, "Watch Movie", "LOW", "TO DO"));
        todoList.put(2, new Todo(2, "Finish Project", "HIGH", "IN PROGRESS"));
        todoList.put(3, new Todo(3, "Buy Groceries", "MEDIUM", "TO DO"));
        todoList.put(4, new Todo(4, "Learning from NxtWave", "HIGH", "IN PROGRESS"));
        todoList.put(5, new Todo(5, "Go for a Run", "MEDIUM", "DONE"));

    }

    int uniqueId = 6;

    @Override
    public ArrayList<Todo> gettodosdetails() {
        Collection<Todo> todoscollection = todoList.values();
        ArrayList<Todo> todosdetails = new ArrayList<>(todoscollection);
        return todosdetails;

    }

    @Override
    public Todo gettododetails(int id) {
        Todo details = todoList.get(id);
        if (details == null) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return details;
    }

    @Override
    public Todo addtodo(Todo todo) {
        todo.setId(uniqueId);
        todoList.put(uniqueId, todo);
        uniqueId = uniqueId + 1;

        return todo;
    }

    @Override
    public Todo updatetodo(int id, Todo todo) {
        Todo exsist = todoList.get(id);
        if (exsist == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

        if (todo.getTodo() != null) {
            exsist.setTodo(todo.getTodo());
        }

        if (todo.getPriority() != null) {
            exsist.setPriority(todo.getPriority());
        }

        if (todo.getStatus() != null) {
            exsist.setStatus(todo.getStatus());
        }

        return exsist;
    }

    @Override
    public void deletetodo(int id) {
        Todo play = todoList.get(id);
        if (play == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        else {
            todoList.remove(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }

}

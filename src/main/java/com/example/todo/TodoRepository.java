package com.example.todo;

import java.util.*;

import com.example.todo.Todo;

public interface TodoRepository {
    ArrayList<Todo> gettodosdetails();

    Todo gettododetails(int id);

    Todo addtodo(Todo todo);

    Todo updatetodo(int id, Todo todo);

    void deletetodo(int id);
}

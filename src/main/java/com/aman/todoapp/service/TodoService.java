package com.aman.todoapp.service;

import com.aman.todoapp.entities.TodoEntity;
import com.aman.todoapp.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todo;

    public List<TodoEntity> getTodos(){
        List<TodoEntity> allTodos = todo.findAll();
        return allTodos;
    }

    public List<TodoEntity>  addTodo(TodoEntity newTodo){
         todo.save(newTodo);
         return todo.findAll();
    }

    public List<TodoEntity>  updateTodo(String id,TodoEntity updatedTodo){

        Optional<TodoEntity> oldTodo = todo.findById(id);
        if(oldTodo.isPresent()){
            updatedTodo.setId(id);
            todo.save(updatedTodo);
            return todo.findAll();
        }else
          return todo.findAll();

    }

    public List<TodoEntity>  deleteTodo(String id){
        todo.deleteById(id);
        return todo.findAll();
    }
}

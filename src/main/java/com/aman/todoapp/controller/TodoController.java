package com.aman.todoapp.controller;

import com.aman.todoapp.entities.TodoEntity;
import com.aman.todoapp.repository.TodoRepo;
import com.aman.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "*")
public class TodoController {

    @Autowired
    private TodoService todoService;
    @GetMapping("/")
    public List<TodoEntity> getTodos(){
        return todoService.getTodos();
    }

    @PostMapping("/")
    public List<TodoEntity> addTodo(@RequestBody TodoEntity newTodo){
        return todoService.addTodo(newTodo);
    }

    @PutMapping("/")
    public List<TodoEntity> updateTodo(@RequestParam String id, @RequestBody TodoEntity updatedTodo){
        return todoService.updateTodo(id, updatedTodo);
    }

   @DeleteMapping("/")
    public  List<TodoEntity> deleteTodo(@RequestParam String id){
        return  todoService.deleteTodo(id);
   }

}

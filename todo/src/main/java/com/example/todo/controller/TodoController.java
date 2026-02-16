package com.example.todo.controller;

import com.example.todo.model.TodoModel;
import com.example.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TodoController {
    private final TodoService service;
    public TodoController(TodoService service) {
        this.service = service;
    }
    @GetMapping("/")
    public List<TodoModel> getTodos(){
        return service.findAll();
    }
    @PostMapping("/create")
    public TodoModel create(@RequestBody TodoModel todoModel){
        todoModel.setId(null);
        return service.create(todoModel);
    }
    @PutMapping("/update/{id}")
    public TodoModel update(@PathVariable String id,@RequestBody TodoModel todoModel){
       return  service.update(id, todoModel);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
            service.delete(id);
    }
}

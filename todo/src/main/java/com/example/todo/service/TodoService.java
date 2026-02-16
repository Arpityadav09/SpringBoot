package com.example.todo.service;

import com.example.todo.model.TodoModel;
import com.example.todo.repository.TodoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    public final TodoRepo todoRepo;
    public TodoService(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }
    public List<TodoModel> findAll(){
        return todoRepo.findAll();
    }

    public TodoModel create(TodoModel todoModel){
        return todoRepo.save(todoModel);
    }
    public TodoModel update(String id,TodoModel todoModel){
        TodoModel temp=todoRepo.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        temp.setTitle(todoModel.getTitle());
        temp.setCompleted(todoModel.isCompleted());
        return todoRepo.save(temp);
    }
    public void delete(String id){
        todoRepo.deleteById(id);
    }
}

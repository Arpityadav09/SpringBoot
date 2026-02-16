package com.example.todo.repository;

import com.example.todo.model.TodoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepo extends MongoRepository<TodoModel,String> {
}

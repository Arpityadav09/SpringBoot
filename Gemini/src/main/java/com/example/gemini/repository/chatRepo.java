package com.example.gemini.repository;

import com.example.gemini.model.chatModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface chatRepo extends MongoRepository<chatModel,String> {
}

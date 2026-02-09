package com.example.gemini.Service;

import com.example.gemini.model.chatModel;
import com.example.gemini.repository.chatRepo;
import org.springframework.stereotype.Service;

@Service
public class chatService {
    private chatRepo chatRepository;
    public chatService(chatRepo repository){this.chatRepository=repository;}
    public chatModel addrequest(chatModel chat){
        return chatRepository.save(chat);
    }
}

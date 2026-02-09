package com.example.gemini.controller;

import com.example.gemini.Service.chatService;
import com.example.gemini.model.chatModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class chatController {
    private final chatService service;
    public chatController (chatService service){this.service=service;}

    @PostMapping("/")
    public chatModel addChat(chatModel chat){
        return service.addrequest(chat);
    }
}

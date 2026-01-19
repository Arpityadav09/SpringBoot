package com.example.day1_revision;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Route {
    @GetMapping("/")
    static String home(){
        return "Home page";
    }
    @GetMapping("/user")
    static String yser(){
        return "User page";
    }
}

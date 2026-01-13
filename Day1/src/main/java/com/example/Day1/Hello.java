package com.example.Day1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Hello {
    @GetMapping("/")
    public String hello(){
        return "HI how are you";
    }
    @GetMapping("/home")
    public String home(){
        return "home page";
    }
    @GetMapping("/user")
    public String user(){
        return "user page";
    }

}

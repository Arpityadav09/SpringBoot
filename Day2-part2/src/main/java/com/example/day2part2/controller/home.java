package com.example.day2part2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class home {
    @GetMapping("/about")
    String about(){
        return "this is about";
    }

}

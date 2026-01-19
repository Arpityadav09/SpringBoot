package com.example.day2part2.controller;

import com.example.day2part2.model.StudentModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class home {
    @GetMapping("/")
    StudentModel getStudent(){
        StudentModel student=new StudentModel(1,"Arpit","arpit@gmail.com");
        return student;
    }
    @GetMapping("/about")
    String about(){
        return "this is about";
    }

}

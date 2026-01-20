package com.example.day3sms.controller;

import com.example.day3sms.model.StudentModel;
import com.example.day3sms.serves.StudentServes;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
   private final StudentServes service;
   public StudentController (StudentServes service){
       this.service=service;
   }
   @PostMapping("addstudent/")
    public StudentModel addStudent(@RequestBody StudentModel student){
       return service.addStudent(student);
   }
}

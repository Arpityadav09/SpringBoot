package com.example.day3sms.controller;

import com.example.day3sms.dto.StudentRequestdto;
import com.example.day3sms.dto.StudentResponseDto;
import com.example.day3sms.model.StudentModel;
import com.example.day3sms.serves.StudentServes;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
   private final StudentServes service;
   public StudentController (StudentServes service){
       this.service=service;
   }
   @PostMapping("addstudent/")
    public StudentResponseDto addStudent(@Valid  @RequestBody StudentRequestdto student){
       return service.addStudent(student);
   }
   @GetMapping("/students")
    public List<StudentResponseDto> getStudent(){
       return service.getStudents();
   }
    @GetMapping("/upadate/{id}")
    public StudentModel updateStudent(@PathVariable String id, @RequestBody StudentModel student){
       return service.upadteStudent(id,student);
    }
}

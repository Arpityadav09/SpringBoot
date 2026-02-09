package com.example.day3sms.controller;

import com.example.day3sms.dto.StudentRequestdto;
import com.example.day3sms.dto.StudentResponseDto;
import com.example.day3sms.model.StudentModel;
import com.example.day3sms.serves.StudentServes;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins ="*")
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
   @GetMapping("/getstudents")
    public List<StudentResponseDto> getStudent(){
       return service.getStudents();
   }
    @PutMapping("/update/{id}")
    public StudentModel updateStudent(@PathVariable String id, @RequestBody StudentModel student){
       return service.upadteStudent(id,student);
    }
    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id) {
        service.deleteStudent(id);
        return ResponseEntity.ok(
                Map.of("message", "Student deleted successfully")
        );
    }
    @PatchMapping("/student/{id}")
    public StudentResponseDto patchStudent(
            @PathVariable String id,
            @RequestBody StudentRequestdto studentDto
    ) {
        return service.patchStudent(id, studentDto);
    }
}

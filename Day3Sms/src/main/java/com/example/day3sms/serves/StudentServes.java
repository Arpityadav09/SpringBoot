package com.example.day3sms.serves;

import com.example.day3sms.dto.StudentRequestdto;
import com.example.day3sms.dto.StudentResponseDto;
import com.example.day3sms.model.StudentModel;
import com.example.day3sms.repository.StudentRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServes {
    private StudentRepo repository;

    public StudentServes(StudentRepo repository) {
        this.repository = repository;
    }
    // store data
//    public StudentModel addStudent(StudentModel student){
//        return repository.save(student);
//    }
    public StudentResponseDto addStudent(StudentRequestdto dto) {
        StudentModel student = new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel saved = repository.save(student);

        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }
    // display student
    public List<StudentResponseDto> getStudents(){
        return repository.findAll().stream().map(s->new StudentResponseDto(
                s.getId(),
                s.getName(),
                s.getAge(),
                s.getEmail()
        )).toList();
    }
    // update
    public StudentModel upadteStudent(String id,StudentModel student){
        StudentModel existingStudent= repository.findById(id).orElseThrow(()->new RuntimeException("No Student found"));
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());
        return repository.save(existingStudent);
    }
}

package com.example.day3sms.serves;

import com.example.day3sms.model.StudentModel;
import com.example.day3sms.repository.StudentRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentServes {
    private StudentRepo repository;

    public StudentServes(StudentRepo repository) {
        this.repository = repository;
    }
    public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }
}

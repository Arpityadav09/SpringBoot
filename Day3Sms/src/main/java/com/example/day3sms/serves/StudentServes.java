package com.example.day3sms.serves;

import com.example.day3sms.dto.StudentRequestdto;
import com.example.day3sms.dto.StudentResponseDto;
import com.example.day3sms.exception.ResourceNotFoundException;
import com.example.day3sms.model.StudentModel;
import com.example.day3sms.repository.StudentRepo;
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
    // delete student
    public void deleteStudent(String id) {

        StudentModel student = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id: " + id)
                );

        repository.delete(student);
    }
    public StudentResponseDto patchStudent(String id, StudentRequestdto dto) {
        StudentModel student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Only update if the DTO field is not null
        if (dto.getName() != null) {
            student.setName(dto.getName());
        }
        if (dto.getAge() != 0) { // Assuming int age, default is 0
            student.setAge(dto.getAge());
        }
        if (dto.getEmail() != null) {
            student.setEmail(dto.getEmail());
        }

        StudentModel updated = repository.save(student);
        return convertToResponseDto(updated); // Map back to your response DTO
    }

    private StudentResponseDto convertToResponseDto(StudentModel updated) {
        return new StudentResponseDto(
                updated.getId(),
                updated.getName(),
                updated.getAge(),
                updated.getEmail()
        );
    }
}

package com.example.day2part2.controller;
import java.util.*;
import com.example.day2part2.model.StudentModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class home {
    @GetMapping("/")
     ArrayList<StudentModel> getStudent() {
        StudentModel student1 = new StudentModel(1, "Arpit", "arpit@gmail.com");
        StudentModel student2 = new StudentModel(1, "Arpit", "arpit@gmail.com");
        StudentModel student3 = new StudentModel(1, "Arpit", "arpit@gmail.com");
        StudentModel student4 = new StudentModel(1, "Arpit", "arpit@gmail.com");
        StudentModel student5 = new StudentModel(1, "Arpit", "arpit@gmail.com");
        ArrayList<StudentModel> arr = new ArrayList<>();
        arr.add(student1);
        arr.add(student2);
        arr.add(student3);
        arr.add(student4);
        arr.add(student5);
        return arr;
    }

}

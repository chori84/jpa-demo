package com.chori.jpademo.edu.controller;

import com.chori.jpademo.edu.dto.student.StudentRequest;
import com.chori.jpademo.edu.dto.student.StudentResponse;
import com.chori.jpademo.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping
    public List<StudentResponse> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public StudentResponse findById(@PathVariable(value = "id") Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    public void registerStudent(@RequestBody StudentRequest student) {
        studentService.save(student.getName(), student.getProfessorId());
    }

}

package com.chori.jpademo.edu.controller;

import com.chori.jpademo.edu.dto.StudentDto;
import com.chori.jpademo.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<StudentDto> findAll() {
        return studentService.findAll();
    }
}

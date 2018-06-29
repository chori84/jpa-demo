package com.chori.jpademo.edu.controller;

import com.chori.jpademo.edu.dto.subject.SubjectResponse;
import com.chori.jpademo.edu.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping
    public List<SubjectResponse> findAll() {
        return subjectService.findAll();
    }

    @GetMapping("/{id}")
    public SubjectResponse findById(@PathVariable(value = "id") Long id) {
        return subjectService.findById(id);
    }
}

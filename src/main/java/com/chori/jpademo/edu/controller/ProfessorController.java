package com.chori.jpademo.edu.controller;

import com.chori.jpademo.edu.dto.professor.ProfessorResponse;
import com.chori.jpademo.edu.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("professor")
public class ProfessorController {
    @Autowired
    ProfessorService professorService;

    @GetMapping
    public List<ProfessorResponse> findAll() {
        return professorService.findAll();
    }

    @GetMapping("/{id}")
    public ProfessorResponse findById(@PathVariable(value = "id") Long id) {
        return professorService.findById(id);
    }
}

package com.chori.jpademo.edu.service;

import com.chori.jpademo.edu.model.Professor;

import java.util.List;

public interface ProfessorService {
    List<Professor> findAll();

    Professor findById(Long id);
}

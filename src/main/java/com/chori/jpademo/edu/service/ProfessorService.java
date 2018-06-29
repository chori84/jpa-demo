package com.chori.jpademo.edu.service;

import com.chori.jpademo.edu.dto.professor.ProfessorResponse;

import java.util.List;

public interface ProfessorService {
    List<ProfessorResponse> findAll();

    ProfessorResponse findById(Long id);
}

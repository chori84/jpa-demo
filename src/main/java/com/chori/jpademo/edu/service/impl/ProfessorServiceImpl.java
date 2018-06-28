package com.chori.jpademo.edu.service.impl;

import com.chori.jpademo.edu.model.Professor;
import com.chori.jpademo.edu.repository.ProfessorRepository;
import com.chori.jpademo.edu.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public Professor findById(Long id) {
        return professorRepository.findById(id).get();
    }
}

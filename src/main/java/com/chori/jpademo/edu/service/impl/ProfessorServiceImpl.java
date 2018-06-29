package com.chori.jpademo.edu.service.impl;

import com.chori.jpademo.edu.dto.professor.ProfessorResponse;
import com.chori.jpademo.edu.repository.ProfessorRepository;
import com.chori.jpademo.edu.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;

    @Override
    public List<ProfessorResponse> findAll() {
        return professorRepository.findAll()
                .stream()
                .map(professor -> professor.convertToResponse())
                .collect(Collectors.toList());
    }

    @Override
    public ProfessorResponse findById(Long id) {
        return professorRepository.findById(id).get().convertToResponse();
    }
}

package com.chori.jpademo.edu.service.impl;

import com.chori.jpademo.edu.dto.student.StudentResponse;
import com.chori.jpademo.edu.model.Student;
import com.chori.jpademo.edu.repository.StudentRepository;
import com.chori.jpademo.edu.service.ProfessorService;
import com.chori.jpademo.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ProfessorService professorService;

    @Override
    public List<StudentResponse> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(student -> student.convertToResponse())
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse findById(Long id) {
        return studentRepository.findById(id).get().convertToResponse();
    }

    @Override
    public void save(String name, Long professorId) {
        studentRepository.save(Student.builder()
                .name(name)
                .professor(professorService.findById(professorId).convertToDomain())
                .build());
    }
}

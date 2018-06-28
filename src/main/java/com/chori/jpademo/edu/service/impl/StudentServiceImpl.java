package com.chori.jpademo.edu.service.impl;

import com.chori.jpademo.edu.dto.StudentDto;
import com.chori.jpademo.edu.repository.StudentRepository;
import com.chori.jpademo.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAllFetch()
                .stream()
                .map(student -> student.convertToDto())
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto findById(Long id) {
        return studentRepository.findById(id).get().convertToDto();
    }
}

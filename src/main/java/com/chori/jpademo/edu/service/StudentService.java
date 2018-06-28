package com.chori.jpademo.edu.service;

import com.chori.jpademo.edu.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAll();

    StudentDto findById(Long id);
}

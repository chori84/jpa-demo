package com.chori.jpademo.edu.service;

import com.chori.jpademo.edu.dto.student.StudentResponse;

import java.util.List;

public interface StudentService {
    List<StudentResponse> findAll();

    StudentResponse findById(Long id);

    void save(String name, Long professorId);
}

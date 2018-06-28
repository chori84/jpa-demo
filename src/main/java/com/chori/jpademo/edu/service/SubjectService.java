package com.chori.jpademo.edu.service;

import com.chori.jpademo.edu.model.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> findAll();

    Subject findById(Long id);
}

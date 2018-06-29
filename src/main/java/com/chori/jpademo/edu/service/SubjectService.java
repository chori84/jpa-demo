package com.chori.jpademo.edu.service;

import com.chori.jpademo.edu.dto.subject.SubjectResponse;

import java.util.List;

public interface SubjectService {
    List<SubjectResponse> findAll();

    SubjectResponse findById(Long id);
}

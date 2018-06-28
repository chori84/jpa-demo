package com.chori.jpademo.edu.service.impl;

import com.chori.jpademo.edu.model.Subject;
import com.chori.jpademo.edu.repository.SubjectRepository;
import com.chori.jpademo.edu.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findById(Long id) {
        return subjectRepository.findById(id).get();
    }
}

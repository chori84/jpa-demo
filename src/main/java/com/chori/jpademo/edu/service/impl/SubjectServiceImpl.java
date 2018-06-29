package com.chori.jpademo.edu.service.impl;

import com.chori.jpademo.edu.dto.subject.SubjectResponse;
import com.chori.jpademo.edu.repository.SubjectRepository;
import com.chori.jpademo.edu.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public List<SubjectResponse> findAll() {
        return subjectRepository.findAll()
                .stream()
                .map(subject -> subject.convertToResponse())
                .collect(Collectors.toList());
    }

    @Override
    public SubjectResponse findById(Long id) {
        return subjectRepository.findById(id).get().convertToResponse();
    }
}

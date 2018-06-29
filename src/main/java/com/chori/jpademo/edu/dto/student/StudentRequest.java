package com.chori.jpademo.edu.dto.student;

import lombok.Getter;

import java.util.List;

@Getter
public class StudentRequest {
    private Long id;
    private String name;
    private Long professorId;
    private List<Long> subjectIds;

}

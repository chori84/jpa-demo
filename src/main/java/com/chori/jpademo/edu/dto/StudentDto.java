package com.chori.jpademo.edu.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StudentDto {
    private Long id;
    private String name;
    private List<SubjectForStudent> subjects;
    private ProfessorDto professor;

    public StudentDto(Long id, String name, List<SubjectForStudent> subjects, ProfessorDto professor) {
        this.id = id;
        this.name = name;
        this.subjects = subjects;
        this.professor = professor;
    }

    public StudentDto() {}
}

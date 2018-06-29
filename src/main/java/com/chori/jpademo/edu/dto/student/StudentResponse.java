package com.chori.jpademo.edu.dto.student;

import com.chori.jpademo.edu.dto.subject.SubjectInfo;
import com.chori.jpademo.edu.dto.professor.ProfessorInfo;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StudentResponse {
    private Long id;
    private String name;
    private List<SubjectInfo> subjects;
    private ProfessorInfo professor;
}

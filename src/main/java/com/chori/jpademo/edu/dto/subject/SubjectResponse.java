package com.chori.jpademo.edu.dto.subject;

import com.chori.jpademo.edu.dto.professor.ProfessorInfo;
import com.chori.jpademo.edu.dto.student.StudentInfo;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class SubjectResponse {
    private Long id;
    private String name;
    private List<StudentInfo> students;
    private ProfessorInfo professor;
}

package com.chori.jpademo.edu.dto.professor;

import com.chori.jpademo.edu.dto.student.StudentInfo;
import com.chori.jpademo.edu.dto.subject.SubjectInfo;
import com.chori.jpademo.edu.model.Professor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProfessorResponse {
    private Long id;
    private String name;
    private SubjectInfo subject;
    private List<StudentInfo> students;

    public Professor convertToDomain() {
        return Professor.builder().id(this.id).name(this.name).build();
    }
}

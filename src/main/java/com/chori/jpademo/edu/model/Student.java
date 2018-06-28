package com.chori.jpademo.edu.model;

import com.chori.jpademo.edu.dto.ProfessorDto;
import com.chori.jpademo.edu.dto.StudentDto;
import com.chori.jpademo.edu.dto.SubjectForStudent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
@Entity
@Access(AccessType.FIELD)
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id")
    )
    private List<Subject> subjects;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    protected Student() {}

    public StudentDto convertToDto() {
        List<SubjectForStudent> subjects = new ArrayList<>();
        if(!this.subjects.isEmpty()) {
            this.subjects.forEach(subject ->
                    subjects.add(subject.convertToSubjectForStudent())
            );
        }

        return StudentDto.builder()
                .id(this.getId())
                .name(this.getName())
                .subjects(subjects)
                .professor(this.professor.convertToDto())
                .build();
    }
}

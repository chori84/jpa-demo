package com.chori.jpademo.edu.model;

import com.chori.jpademo.edu.dto.professor.ProfessorInfo;
import com.chori.jpademo.edu.dto.professor.ProfessorResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@Builder
@Entity
@Access(AccessType.FIELD)
@SequenceGenerator(name = "PROFESSOR_SEQ_GENERATOR", sequenceName = "sequence_professor", initialValue = 6, allocationSize = 1)
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROFESSOR_SEQ_GENERATOR")
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private List<Student> students;

    protected Professor() {}

    public ProfessorResponse convertToResponse() {
        return ProfessorResponse.builder()
                .id(this.id)
                .name(this.name)
                .subject(this.subject == null ? null : this.subject.convertToInfo())
                .students(this.students == null ? null : this.students
                        .stream()
                        .map(student -> student.convertToInfo())
                        .collect(Collectors.toList()))
                .build();
    }

    public ProfessorInfo convertToInfo() {
        return ProfessorInfo.builder().id(this.id).name(this.name).build();
    }
}

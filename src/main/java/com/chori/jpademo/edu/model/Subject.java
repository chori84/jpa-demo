package com.chori.jpademo.edu.model;

import com.chori.jpademo.edu.dto.subject.SubjectInfo;
import com.chori.jpademo.edu.dto.subject.SubjectResponse;
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
@SequenceGenerator(name = "SUBJECT_SEQ_GENERATOR", sequenceName = "sequence_subject", initialValue = 4, allocationSize = 1)
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUBJECT_SEQ_GENERATOR")
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;

    @OneToOne(mappedBy = "subject")
    private Professor professor;

    protected Subject() {}

    public SubjectResponse convertToResponse() {
        return SubjectResponse.builder()
                .id(this.id)
                .name(this.name)
                .students(this.students == null ? null : this.students
                        .stream()
                        .map(student -> student.convertToInfo())
                        .collect(Collectors.toList()))
                .professor(this.professor  == null ? null : this.professor.convertToInfo())
                .build();
    }

    public SubjectInfo convertToInfo() {
        return SubjectInfo.builder().id(this.id).name(this.name).build();
    }
}

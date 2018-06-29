package com.chori.jpademo.edu.model;

import com.chori.jpademo.edu.dto.student.StudentInfo;
import com.chori.jpademo.edu.dto.student.StudentResponse;
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
@SequenceGenerator(name = "STUDENT_SEQ_GENERATOR", sequenceName = "sequence_student", initialValue = 17, allocationSize = 1)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_SEQ_GENERATOR")
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

    public StudentResponse convertToResponse() {
        return StudentResponse.builder()
                .id(this.getId())
                .name(this.getName())
                .subjects(this.subjects == null ? null : this.subjects
                        .stream()
                        .map(subject -> subject.convertToInfo())
                        .collect(Collectors.toList()))
                .professor(this.professor == null ? null : this.professor.convertToInfo())
                .build();
    }

    public StudentInfo convertToInfo() {
        return StudentInfo.builder().id(this.id).name(this.name).build();
    }
}

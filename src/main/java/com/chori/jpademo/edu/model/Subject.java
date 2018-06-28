package com.chori.jpademo.edu.model;

import com.chori.jpademo.edu.dto.SubjectForStudent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
@Entity
@Access(AccessType.FIELD)
public class Subject {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;

    @OneToOne(mappedBy = "subject")
    private Professor professor;

    protected Subject() {}

    public SubjectForStudent convertToSubjectForStudent() {
        return SubjectForStudent.builder().id(this.id).name(this.name).build();
    }
}

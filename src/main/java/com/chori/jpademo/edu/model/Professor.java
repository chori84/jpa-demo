package com.chori.jpademo.edu.model;

import com.chori.jpademo.edu.dto.ProfessorDto;
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
public class Professor {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "professor")
    private List<Student> students;

    protected Professor() {}

    public ProfessorDto convertToDto() {
        return ProfessorDto.builder().id(this.id).name(this.name).build();
    }
}

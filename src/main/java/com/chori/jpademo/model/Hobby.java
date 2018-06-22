package com.chori.jpademo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Getter
@AllArgsConstructor
@Builder
@Entity
@Access(AccessType.FIELD)
public class Hobby {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "hobbies")
    private Set<Sawon> sawons;

    protected Hobby() {}
}

package com.chori.jpademo.edu.dto.professor;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProfessorInfo {
    private Long id;
    private String name;
}

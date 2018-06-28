package com.chori.jpademo.edu.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProfessorDto {
    private Long id;
    private String name;
}

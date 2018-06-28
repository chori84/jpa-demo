package com.chori.jpademo.edu.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SubjectForStudent {
    private Long id;
    private String name;
}

package com.chori.jpademo.edu.dto.student;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StudentInfo {
    private Long id;
    private String name;
}

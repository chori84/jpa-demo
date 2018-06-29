package com.chori.jpademo.edu.dto.subject;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SubjectInfo {
    private Long id;
    private String name;
}

package com.chori.jpademo.edu.repository;

import com.chori.jpademo.edu.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}

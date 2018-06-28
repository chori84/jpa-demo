package com.chori.jpademo.edu.repository;

import com.chori.jpademo.edu.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}

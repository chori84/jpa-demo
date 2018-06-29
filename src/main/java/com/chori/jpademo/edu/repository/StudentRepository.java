package com.chori.jpademo.edu.repository;

import com.chori.jpademo.edu.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

package com.chori.jpademo.edu.repository;

import com.chori.jpademo.edu.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s from Student s join fetch s.professor join fetch s.subjects")
    List<Student> findAllFetch();
}

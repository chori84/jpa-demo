package com.chori.jpademo.repository;

import com.chori.jpademo.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Emp, Long> {
}

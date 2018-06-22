package com.chori.jpademo.repository;

import com.chori.jpademo.model.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {
}

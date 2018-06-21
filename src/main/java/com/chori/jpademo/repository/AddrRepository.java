package com.chori.jpademo.repository;

import com.chori.jpademo.model.Addr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddrRepository extends JpaRepository<Addr, Long> {
}

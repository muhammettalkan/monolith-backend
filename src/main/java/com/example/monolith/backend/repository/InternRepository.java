package com.example.monolith.backend.repository;

import com.example.monolith.backend.entity.Intern;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternRepository extends JpaRepository<Intern,Long> {
}

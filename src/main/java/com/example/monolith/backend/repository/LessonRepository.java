package com.example.monolith.backend.repository;

import com.example.monolith.backend.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson,Integer> {
    Lesson findLessonById(int id);
}
